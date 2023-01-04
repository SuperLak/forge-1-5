package net.kal.tutorialmod.item;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.block.ModBlocks;
import net.kal.tutorialmod.item.custom.FireGemItem;
import net.kal.tutorialmod.item.custom.JaiSpearItem;
import net.kal.tutorialmod.item.custom.RubyArrowItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));

    public static final RegistryObject<Item> FIRE_GEM = ITEMS.register("fire_gem",
            () -> new FireGemItem(new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)
                    .maxDamage(120)));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, 3, -2.4f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModItemTier.RUBY, 1, -2.8f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModItemTier.RUBY, 4, -3.2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModItemTier.RUBY, 1, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModItemTier.RUBY, -2, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));

    public static final RegistryObject<Item> RUBY_SPEAR = ITEMS.register("ruby_spear",
            () -> new SpearItem(ModItemTier.RUBY, 0, -2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_CHEST = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.RUBY_GROUP)));


    public static final RegistryObject<Item> MADRA = ITEMS.register("madra",
            () -> new Item(new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_CHUNK = ITEMS.register("madra_chunk",
            () -> new Item(new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> INFUSED_STICK = ITEMS.register("infused_stick",
            () -> new Item(new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> INFUSED_STRING = ITEMS.register("infused_string",
            () -> new Item(new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> MADRA_SWORD = ITEMS.register("madra_sword",
            () -> new SwordItem(ModItemTier.MADRA, 3, -2.4f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_PICKAXE = ITEMS.register("madra_pickaxe",
            () -> new PickaxeItem(ModItemTier.MADRA, 1, -2.8f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_AXE = ITEMS.register("madra_axe",
            () -> new AxeItem(ModItemTier.MADRA, 4, -3.2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_SHOVEL = ITEMS.register("madra_shovel",
            () -> new ShovelItem(ModItemTier.MADRA, 1, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_HOE = ITEMS.register("madra_hoe",
            () -> new HoeItem(ModItemTier.MADRA, -2, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> MADRA_SPEAR = ITEMS.register("madra_spear",
            () -> new SpearItem(ModItemTier.MADRA, 0, -2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> MADRA_HELMET = ITEMS.register("madra_helmet",
            () -> new ArmorItem(ModArmorMaterial.MADRA, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_CHEST = ITEMS.register("madra_chestplate",
            () -> new ArmorItem(ModArmorMaterial.MADRA, EquipmentSlotType.CHEST,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_LEGGINGS = ITEMS.register("madra_leggings",
            () -> new ArmorItem(ModArmorMaterial.MADRA, EquipmentSlotType.LEGS,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> MADRA_BOOTS = ITEMS.register("madra_boots",
            () -> new ArmorItem(ModArmorMaterial.MADRA, EquipmentSlotType.FEET,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> JAI_SPEAR = ITEMS.register("jai_spear",
            () -> new JaiSpearItem(ModItemTier.MADRA, 2, -2f,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    public static final RegistryObject<Item> SOULSEEKER = ITEMS.register("soulseeker",
            () -> new BowItem(new Item.Properties()
                    .group(ModItemGroup.MADRA_GROUP).maxStackSize(1)));

    public static final RegistryObject<Item> CROWN = ITEMS.register("crown",
            () -> new ArmorItem(ModArmorMaterial.OZ, EquipmentSlotType.HEAD,
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> ORUS_FRUIT = ITEMS.register("orus_fruit",
            () -> new Item(new Item.Properties()
                    .food(new Food.Builder().hunger(3)
                            .saturation(.2f).build())
                    .group(ModItemGroup.MADRA_GROUP)));



    public static final RegistryObject<Item> CLOUDGRASS_SEEDS = ITEMS.register("cloudgrass_seeds",
            () -> new BlockItem(ModBlocks.CLOUDGRASS.get(),
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> CLOUDGRASS = ITEMS.register("cloudgrass",
            () -> new Item( new Item.Properties().group(ModItemGroup.MADRA_GROUP)));

    public static final RegistryObject<Item> RUBY_ARROW = ITEMS.register("ruby_arrow",
            () -> new RubyArrowItem(new Item.Properties().group(ModItemGroup.RUBY_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}