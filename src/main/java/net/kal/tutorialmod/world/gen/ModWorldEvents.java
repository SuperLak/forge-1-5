package net.kal.tutorialmod.world.gen;

import net.kal.tutorialmod.TutorialMod;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {
        ModOreGeneration.generateOres(event);

        ModFlowerGeneration.generateFlowers(event);
        ModTreeGeneration.generateTrees(event);
    }
}
