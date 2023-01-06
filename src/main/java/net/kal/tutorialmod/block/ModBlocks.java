package net.kal.tutorialmod.block;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.block.custom.CloudgrassBlock;
import net.kal.tutorialmod.block.custom.FireGemBlock;
import net.kal.tutorialmod.block.custom.LightningChannelerBlock;
import net.kal.tutorialmod.block.custom.trees.OrusTree;
import net.kal.tutorialmod.item.ModItemGroup;
import net.kal.tutorialmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effects;
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

    public static final RegistryObject<Block> FIRE_GEM_BLOCK = registerRubyBlock("fire_gem_block",
            () -> new FireGemBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));

    public static final RegistryObject<Block> RUBY_STAIRS = registerRubyBlock("ruby_stairs",
            () -> new StairsBlock(() -> RUBY_BLOCK.get().getDefaultState(),
                    AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> RUBY_FENCE = registerRubyBlock("ruby_fence",
            () -> new FenceBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));

    public static final RegistryObject<Block> RUBY_FENCE_GATE = registerRubyBlock("ruby_fence_gate",
            () -> new FenceGateBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));

    public static final RegistryObject<Block> RUBY_SLAB = registerRubyBlock("ruby_slab",
            () -> new SlabBlock(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3f)));


    public static final RegistryObject<Block> MADRA_ORE = registerMadraBlock("madra_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> MADRA_BLOCK = registerMadraBlock("madra_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(5f)));

    public static final RegistryObject<Block> CLOUDGRASS = BLOCKS.register("cloudgrass_crop",
            () -> new CloudgrassBlock(AbstractBlock.Properties.from(Blocks.WHEAT)));


    public static final RegistryObject<Block> ORUS_LOG = registerMadraBlock("orus_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> ORUS_WOOD = registerMadraBlock("orus_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_ORUS_LOG = registerMadraBlock("stripped_orus_log",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_ORUS_WOOD = registerMadraBlock("stripped_orus_wood",
            () -> new RotatedPillarBlock(AbstractBlock.Properties.from(Blocks.STRIPPED_OAK_WOOD)));

    public static final RegistryObject<Block> ORUS_PLANKS = registerMadraBlock("orus_planks",
            () -> new Block(AbstractBlock.Properties.from(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> ORUS_LEAVES = registerMadraBlock("orus_leaves",
            () -> new LeavesBlock(AbstractBlock.Properties.create(Material.LEAVES).hardnessAndResistance(0.2f)
                    .tickRandomly().sound(SoundType.PLANT).notSolid()));
    public static final RegistryObject<Block> ORUS_SAPLING = registerMadraBlock("orus_sapling",
            () -> new SaplingBlock(new OrusTree(), AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> OSMANTHUS = registerMadraBlock("osmanthus",
            () -> new FlowerBlock(Effects.HASTE, 2, AbstractBlock.Properties.from(Blocks.OAK_SAPLING)));

    public static final RegistryObject<Block> LIGHTNING_CHANNELER = registerMadraBlock("lightning_channeler",
            () -> new LightningChannelerBlock(AbstractBlock.Properties.create(Material.IRON)));


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
