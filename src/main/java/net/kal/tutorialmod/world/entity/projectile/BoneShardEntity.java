package net.kal.tutorialmod.world.entity.projectile;

import net.kal.tutorialmod.item.ModItems;
import net.kal.tutorialmod.world.entity.ModEntityType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

@SuppressWarnings("EntityConstructor")
public class BoneShardEntity extends AbstractArrowEntity {
    private final Item referenceItem;
    public BoneShardEntity(EntityType<? extends AbstractArrowEntity> type, World worldIn) {
        super(type, worldIn);
        this.referenceItem = ModItems.BONE_SHARD.get();
    }

    public BoneShardEntity(World worldIn, LivingEntity shooter) {
        super(ModEntityType.BONE_SHARD.get(), shooter, worldIn);
        this.referenceItem = ModItems.BONE_SHARD.get();
    }

    public BoneShardEntity(EntityType<? extends AbstractArrowEntity> type, LivingEntity shooter, World worldIn, Item referenceItem) {
        super(ModEntityType.BONE_SHARD.get(), shooter, worldIn);
        this.referenceItem = referenceItem;
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    public ItemStack getArrowStack() {
        return new ItemStack(ModItems.BONE_SHARD.get());
    }
}
