package net.kal.tutorialmod.item;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.item.custom.FireGem;
import net.kal.tutorialmod.item.custom.JaiSpear;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> FIRE_GEM = ITEMS.register("fire_gem",
            () -> new FireGem(new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)
                    .maxDamage(120)));

    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModItemTier.RUBY, 3, -2.4f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new SwordItem(ModItemTier.RUBY, 1, -2.8f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new SwordItem(ModItemTier.RUBY, 4, -3.2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new SwordItem(ModItemTier.RUBY, 1, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new SwordItem(ModItemTier.RUBY, -2, -3f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> RUBY_SPEAR = ITEMS.register("ruby_spear",
            () -> new SpearItem(ModItemTier.RUBY, 0, -2f,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));

    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.HEAD,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_CHEST = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.CHEST,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.LEGS,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterial.RUBY, EquipmentSlotType.FEET,
                    new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));


    public static final RegistryObject<Item> JAI_SPEAR = ITEMS.register("jai_spear",
            () -> new JaiSpear(ModItemTier.RUBY, 2, -2f,
                    new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP)));
    public static final RegistryObject<Item> SOULSEEKER = ITEMS.register("soulseeker",
            () -> new BowItem(new Item.Properties().group(ModItemGroup.TUTORIAL_GROUP).maxStackSize(1)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}