package net.kal.tutorialmod.item.custom;

import net.kal.tutorialmod.item.SpearItem;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class JaiSpear extends SpearItem {

    private boolean isActive = false;
    private int tickCounter = 0;

    public JaiSpear(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {

        if (isActive) {
            target.addPotionEffect(new EffectInstance(Effects.GLOWING, 600));
            attacker.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200));
            attacker.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100));
        }
        return super.hitEntity(stack, target, attacker);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (Screen.hasShiftDown()) {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.jai_spear_shift"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip.tutorialmod.jai_spear"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {

        if (isActive) {
            tickCounter++;
            if (tickCounter == 200) {
                int damage = stack.getDamage();
                if (damage < 20) {
                    damage = 20;
                }
                stack.setDamage(damage + 20);
                tickCounter = 0;
                Minecraft.getInstance().player.addPotionEffect(new EffectInstance(Effects.STRENGTH, 200));
            }
        }
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {

        World world = context.getWorld();
        PlayerEntity playerEntity = Objects.requireNonNull(context.getPlayer());
        if (!world.isRemote) {
            if (!isActive) {
                isActive = true;
                ITextComponent component = new StringTextComponent("Active Mode");
                Minecraft.getInstance().player.sendMessage(component, null);
            } else {
                isActive = false;
                ITextComponent component = new StringTextComponent("Inactive Mode");
                Minecraft.getInstance().player.sendMessage(component, null);
            }
        }
        return super.onItemUseFirst(stack, context);
    }
}
