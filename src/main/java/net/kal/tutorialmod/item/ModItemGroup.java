package net.kal.tutorialmod.item;

import net.kal.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup RUBY_GROUP = new ItemGroup("rubyTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.RUBY.get());
        }
    };
    public static final ItemGroup MADRA_GROUP = new ItemGroup("madraTab") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MADRA.get());
        }
    };
}
