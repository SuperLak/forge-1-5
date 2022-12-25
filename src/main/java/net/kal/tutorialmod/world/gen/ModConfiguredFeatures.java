package net.kal.tutorialmod.world.gen;

import net.kal.tutorialmod.block.ModBlocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.blockstateprovider.PlainFlowerBlockStateProvider;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

public class ModConfiguredFeatures {

    public static final ConfiguredFeature<BaseTreeFeatureConfig, ?> ORUS =
            register("orus", Feature.TREE.withConfiguration((
                    new BaseTreeFeatureConfig.Builder(
                            new SimpleBlockStateProvider(ModBlocks.ORUS_LOG.get().getDefaultState()),
                            new SimpleBlockStateProvider(ModBlocks.ORUS_LEAVES.get().getDefaultState()),
                            new BlobFoliagePlacer(FeatureSpread.create(2), FeatureSpread.create(0), 3),
                            new StraightTrunkPlacer(4, 2, 0),
                            new TwoLayerFeature(1, 0, 1))).setIgnoreVines().build()));

    public static final ConfiguredFeature<?, ?> OSMANTHUS_CONFIG = Feature.FLOWER.withConfiguration((
            new BlockClusterFeatureConfig.Builder(
                    new SimpleBlockStateProvider(ModBlocks.OSMANTHUS.get().getDefaultState()),
                    SimpleBlockPlacer.PLACER)).tries(12).build())
            .withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).count(5);

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, key, configuredFeature);
    }

}
