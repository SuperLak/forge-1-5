package net.kal.tutorialmod.client;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.client.renderer.entity.BoneShardRenderer;
import net.kal.tutorialmod.client.renderer.entity.RubyArrowRenderer;
import net.kal.tutorialmod.world.entity.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventSubscriber {
    
    @SubscribeEvent
    public static void clientSetupEvent(FMLClientSetupEvent event) {
        event.setPhase(EventPriority.HIGH);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.RUBY_ARROW.get(), RubyArrowRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityType.BONE_SHARD.get(), BoneShardRenderer::new);
    }
}
