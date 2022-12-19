package net.kal.tutorialmod.item;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.item.custom.FireGem;
import net.minecraft.item.BowItem;
import net.minecraft.item.Item;
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
    public static final RegistryObject<Item> SOULSEEKER = ITEMS.register("soulseeker",
            () -> new BowItem(new Item.Properties().isImmuneToFire().group(ModItemGroup.TUTORIAL_GROUP)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}