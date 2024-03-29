package net.kal.tutorialmod;

import com.google.common.collect.ImmutableMap;
import com.google.common.graph.Network;
import net.kal.tutorialmod.block.ModBlocks;
import net.kal.tutorialmod.capability.IManaCapability;
import net.kal.tutorialmod.capability.ModCapabilities;
import net.kal.tutorialmod.container.ModContainers;
import net.kal.tutorialmod.data.recipes.ModRecipeTypes;
import net.kal.tutorialmod.entity.ModEntityTypes;
import net.kal.tutorialmod.entity.render.BuffZombieRenderer;
import net.kal.tutorialmod.entity.render.PigeonRenderer;
import net.kal.tutorialmod.fluid.ModFluids;
import net.kal.tutorialmod.item.ModItems;
import net.kal.tutorialmod.networking.ModMessages;
import net.kal.tutorialmod.screen.LightningChannelerScreen;
import net.kal.tutorialmod.tileentity.ModTileEntities;
import net.kal.tutorialmod.util.ModItemModelProperties;
import net.kal.tutorialmod.world.biome.ModBiomes;
import net.kal.tutorialmod.world.entity.ModEntityType;
import net.kal.tutorialmod.world.gen.ModBiomeGeneration;
import net.kal.tutorialmod.world.structure.ModStructures;
import net.minecraft.block.Block;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MOD_ID)
public class TutorialMod
{
    // Directly reference a log4j logger.
    public static final String MOD_ID = "tutorialmod";
    private static final Logger LOGGER = LogManager.getLogManager().getLogger("");

    public static final List<IManaCapability> TRINKETS = new ArrayList<>();

    public TutorialMod() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModTileEntities.register(eventBus);
        ModContainers.register(eventBus);

        ModStructures.register(eventBus);

        ModFluids.register(eventBus);

        ModRecipeTypes.register(eventBus);

        ModEntityTypes.register(eventBus);

        ModBiomes.register(eventBus);

        ModEntityType.register(eventBus);

        eventBus.addListener(this::setup);
        // Register the enqueueIMC method for modloading
        eventBus.addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        eventBus.addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        eventBus.addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            AxeItem.BLOCK_STRIPPING_MAP = new ImmutableMap.Builder<Block, Block>().putAll(AxeItem.BLOCK_STRIPPING_MAP)
                    .put(ModBlocks.ORUS_LOG.get(), ModBlocks.STRIPPED_ORUS_LOG.get())
                    .put(ModBlocks.ORUS_WOOD.get(), ModBlocks.STRIPPED_ORUS_WOOD.get()).build();

            ModStructures.setupStructures();

            ModBiomeGeneration.generateBiomes();

            EntitySpawnPlacementRegistry.register(ModEntityTypes.BUFF_ZOMBIE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MonsterEntity::canMonsterSpawn);
            EntitySpawnPlacementRegistry.register(ModEntityTypes.PIGEON.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND,
                    Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::canAnimalSpawn);
        });

        ModCapabilities.register();

        ModMessages.register();
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        event.enqueueWork(() -> {

            RenderTypeLookup.setRenderLayer(ModBlocks.RUBY_DOOR.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.RUBY_TRAPDOOR.get(), RenderType.getCutout());

            ModItemModelProperties.makeBow(ModItems.SOULSEEKER.get());
            RenderTypeLookup.setRenderLayer(ModBlocks.CLOUDGRASS.get(), RenderType.getCutout());

            RenderTypeLookup.setRenderLayer(ModBlocks.ORUS_LEAVES.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.ORUS_SAPLING.get(), RenderType.getCutout());
            RenderTypeLookup.setRenderLayer(ModBlocks.OSMANTHUS.get(), RenderType.getCutout());

            ScreenManager.registerFactory(ModContainers.LIGHTNING_CHANNELER_CONTAINER.get(),
                    LightningChannelerScreen::new);

            RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLUID.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OIL_BLOCK.get(), RenderType.getTranslucent());
            RenderTypeLookup.setRenderLayer(ModFluids.OIL_FLOWING.get(), RenderType.getTranslucent());

            RenderTypeLookup.setRenderLayer(ModBlocks.KAUPEN_ALTAR.get(), RenderType.getCutout());

        });

        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.BUFF_ZOMBIE.get(), BuffZombieRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.PIGEON.get(), PigeonRenderer::new);
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // some example code to dispatch IMC to another mod
        InterModComms.sendTo("examplemod", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // some example code to receive and process InterModComms from other mods
    }
    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }

    @SubscribeEvent
    public void loadComplete(FMLLoadCompleteEvent event) {

    }
}
