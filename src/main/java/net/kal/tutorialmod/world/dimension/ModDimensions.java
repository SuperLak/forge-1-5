package net.kal.tutorialmod.world.dimension;

import net.kal.tutorialmod.TutorialMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;

public class ModDimensions {
    public static RegistryKey<World> KalDim = RegistryKey.getOrCreateKey(Registry.WORLD_KEY,
            new ResourceLocation(TutorialMod.MOD_ID, "kaldim"));
}
