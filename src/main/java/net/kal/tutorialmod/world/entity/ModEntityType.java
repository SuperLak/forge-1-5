package net.kal.tutorialmod.world.entity;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.world.entity.projectile.BoneShardEntity;
import net.kal.tutorialmod.world.entity.projectile.RubyArrowEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityType {

    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<RubyArrowEntity>> RUBY_ARROW = ENTITIES.register("ruby_arrow",
            () ->EntityType.Builder.<RubyArrowEntity>create(
                    RubyArrowEntity::new, EntityClassification.MISC).size(0.5f, 0.5f)
                    .trackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/projectiles").toString()));

    public static final RegistryObject<EntityType<BoneShardEntity>> BONE_SHARD = ENTITIES.register("bone_shard",
            () ->EntityType.Builder.<BoneShardEntity>create(
                    BoneShardEntity::new, EntityClassification.MISC).size(0.5f, 0.5f)
                    .trackingRange(4).updateInterval(20)
                    .build(new ResourceLocation(TutorialMod.MOD_ID, "textures/entity/projectiles").toString()));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}
