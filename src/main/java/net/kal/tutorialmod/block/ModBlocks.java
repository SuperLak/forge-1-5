package net.kal.tutorialmod.block;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.block.custom.OatsBlock;
import net.kal.tutorialmod.item.ModItemGroup;
import net.kal.tutorialmod.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
             DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerRubyBlock("ruby_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> RUBY_BLOCK = registerRubyBlock("ruby_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> RUBY_STAIRS = registerRubyBlock("ruby_stairs",
            () -> new StairsBlock(() -> RUBY_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));


    public static final RegistryObject<Block> MADRA_ORE = registerMadraBlock("madra_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> MADRA_BLOCK = registerMadraBlock("madra_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));
    public static final RegistryObject<Block> OATS = BLOCKS.register("oats_crop",
            () -> new OatsBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));


    public static <T extends Block>RegistryObject<T> registerRubyBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerRubyBlockItem(name, toReturn);
        return toReturn;
    }

    public static <T extends Block>RegistryObject<T> registerMadraBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerMadraBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerRubyBlockItem(String name, RegistryObject<T> block) {
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().group(ModItemGroup.RUBY_GROUP)));
    }

    private static <T extends Block> void registerMadraBlockItem(String name, RegistryObject<T> block) {
            ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().group(ModItemGroup.MADRA_GROUP)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
