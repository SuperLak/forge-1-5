package net.kal.tutorialmod.item.custom;

import net.kal.tutorialmod.world.entity.projectile.RubyArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// Spear class can still extend from SwordItem, adding the overridden methods from ArrowItem
public class RubyArrowItem extends ArrowItem {

    public RubyArrowItem(Properties builder) {
        super(builder);
    }

    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        RubyArrowEntity rubyArrowEntity = new RubyArrowEntity(worldIn, shooter);
        return rubyArrowEntity;
    }

    public AbstractArrowEntity createArrow(World worldIn, LivingEntity shooter) {
        RubyArrowEntity rubyArrowEntity = new RubyArrowEntity(worldIn, shooter);
        return rubyArrowEntity;
    }

    @Override
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.enchantment.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == RubyArrowItem.class;
    }
}
