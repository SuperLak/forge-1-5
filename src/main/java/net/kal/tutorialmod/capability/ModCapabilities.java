package net.kal.tutorialmod.capability;

import net.kal.tutorialmod.TutorialMod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ModCapabilities {
    @CapabilityInject(IManaCapability.class)
    public static Capability<IManaCapability> MANA_CAP = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IManaCapability.class, new ManaCapabilityStorage(), ManaCapability::new);
    }
}
