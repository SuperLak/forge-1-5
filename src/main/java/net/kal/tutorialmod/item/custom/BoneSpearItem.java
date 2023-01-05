package net.kal.tutorialmod.item.custom;

import net.kal.tutorialmod.item.ModItems;
import net.kal.tutorialmod.item.SpearItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class BoneSpearItem extends SpearItem {

    public int shards = 8;

    public BoneSpearItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (playerIn instanceof PlayerEntity) {
            PlayerEntity playerentity = (PlayerEntity)playerIn;
            boolean flag = playerentity.abilities.isCreativeMode;
            if(hasShards() || flag) {
                ItemStack itemStack = new ItemStack(ModItems.BONE_SHARD.get());
                // f = velocity
                float f = 1.0f;
                if (!((double)f < 0.1D)) {
                    if (!worldIn.isRemote) {
                        ArrowItem arrowitem = (ArrowItem)(itemStack.getItem() instanceof ArrowItem ? itemStack.getItem() : Items.ARROW);
                        AbstractArrowEntity boneShardEntity = arrowitem.createArrow(worldIn, itemStack, playerentity);
                        boneShardEntity.setDirectionAndMovement(playerentity, playerentity.rotationPitch, playerentity.rotationYaw, 0.0F, f * 3.0F, 1.0F);

                        if (f == 1.0F) {
                            boneShardEntity.setIsCritical(true);
                        }

                        depleteShard();

                        // No if statement since bone shards are not retrievable
                        boneShardEntity.pickupStatus = AbstractArrowEntity.PickupStatus.CREATIVE_ONLY;

                        // This adds entity (VERY IMPORTANT)
                        worldIn.addEntity(boneShardEntity);

                        // Plays Shoot Bow Sound when fired
                        worldIn.playSound((PlayerEntity)null, playerentity.getPosX(), playerentity.getPosY(), playerentity.getPosZ(), SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (random.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                        // Applies cooldown for 4 seconds
                        spearCooldown(playerentity,80);

                    }
                }
            }
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    public boolean hasShards() {
        if (shards > 0) {
            return true;
        } else {
            return false;
        }
    }
    public void depleteShard() {
        shards--;
    }

    public void spearCooldown(PlayerEntity playerEntity, int ticks) {
        playerEntity.getCooldownTracker().setCooldown(ModItems.BONE_SPEAR.get(), ticks);
    }


    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (shards == 0) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_0"));
        } else if (shards == 1) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_1"));
        } else if (shards == 2) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_2"));
        } else if (shards == 3) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_3"));
        } else if (shards == 4) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_4"));
        } else if (shards == 5) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_5"));
        } else if (shards == 6) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_6"));
        } else if (shards == 7) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_7"));
        } else if (shards == 8) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.bone_spear_8"));
        } else {
            shards = 0;
            addInformation(stack, worldIn, tooltip, flagIn);
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}