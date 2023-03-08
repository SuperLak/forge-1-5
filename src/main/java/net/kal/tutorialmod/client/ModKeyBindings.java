package net.kal.tutorialmod.client;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.awt.event.KeyEvent;

public class ModKeyBindings {
    public static final String KEY_CATAGORY_TUTORIAL = "key.tutorialmod.tutorial";
    public static final String EXAMPLE_KEY = "key.tutorialmod.example_key";

    public static KeyBinding exampleKey = new KeyBinding(EXAMPLE_KEY, KeyEvent.VK_O, KEY_CATAGORY_TUTORIAL);

    public static void register(final FMLClientSetupEvent event) {
        ClientRegistry.registerKeyBinding(exampleKey);
    }
}
