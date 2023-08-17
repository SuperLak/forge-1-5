package net.kal.tutorialmod.events;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.capability.IManaCapability;
import net.kal.tutorialmod.capability.ManaProvider;
import net.kal.tutorialmod.capability.ModCapabilities;
import net.kal.tutorialmod.commands.ReturnHomeCommand;
import net.kal.tutorialmod.commands.SetHomeCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;


public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event) {
        new SetHomeCommand(event.getDispatcher());
        new ReturnHomeCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onPlayerCloneEvent(PlayerEvent.Clone event) {
        if(!event.getOriginal().getEntityWorld().isRemote()) {
            event.getPlayer().getPersistentData().putIntArray(TutorialMod.MOD_ID + "homepos",
                    event.getOriginal().getPersistentData().getIntArray(TutorialMod.MOD_ID + "homepos"));
        }
    }

    @SubscribeEvent
    public static void playerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
        PlayerEntity player = event.getPlayer();
        IManaCapability mana = ModCapabilities.MANA_CAP.getDefaultInstance();

        String message = String.format("Welcome! You have " + mana.getMana() + " mana left");
        player.sendMessage(new StringTextComponent(message), player.getUniqueID());
    }
}
