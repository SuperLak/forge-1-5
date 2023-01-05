package net.kal.tutorialmod.item.custom;

import net.kal.tutorialmod.world.entity.projectile.BoneShardEntity;
import net.kal.tutorialmod.world.entity.projectile.RubyArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BoneShardItem extends ArrowItem {
    public BoneShardItem(Properties builder) {
        super(builder);
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        BoneShardEntity boneShardEntity = new BoneShardEntity(worldIn, shooter);
        return boneShardEntity;
    }
}
