package net.kal.tutorialmod.client;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.networking.ModMessages;
import net.kal.tutorialmod.networking.packet.DrinkWaterC2SPacket;
import net.kal.tutorialmod.networking.packet.ExampleC2SPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {
    @SubscribeEvent
    public static void onKeyPress(InputEvent.KeyInputEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.world != null) {
            onInput(mc, event.getKey(), event.getAction());
        } else {
            return;
        }
    }
    public static void onInput(Minecraft mc, int key, int action) {
        if (mc.currentScreen == null && ModKeyBindings.exampleKey.isPressed()) {
            // ITextComponent component = new StringTextComponent("Pressed a Key!");
            // Minecraft.getInstance().player.sendMessage(component, null);
            ModMessages.sendToServer(new DrinkWaterC2SPacket());

        }
    }
}
