package net.kal.tutorialmod.world.biome;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.util.TutorialTags;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class ModConfiguredSurfaceBuilders {

    public static ConfiguredSurfaceBuilder<?> RIFT_SURFACE = register("rift_surface",
            SurfaceBuilder.DEFAULT.func_242929_a(new SurfaceBuilderConfig(
                    Blocks.END_STONE.getDefaultState(),
                    Blocks.MAGMA_BLOCK.getDefaultState(),
                    Blocks.PACKED_ICE.getDefaultState()
            )));

    private static <SC extends ISurfaceBuilderConfig>ConfiguredSurfaceBuilder<SC> register(String name,
                                                                                           ConfiguredSurfaceBuilder<SC> csb) {
        return WorldGenRegistries.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER,
                new ResourceLocation(TutorialMod.MOD_ID, name), csb);
    }

}
