package net.kal.tutorialmod.networking.packet;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.Random;
import java.util.function.Supplier;

public class DrinkWaterC2SPacket {
    private static final String MESSAGE_DRINK_WATER = "message.tutorialmod.drink_water";
    private static final String MESSAGE_NO_WATER = "message.tutorialmod.no_water";

    public int key;

    public DrinkWaterC2SPacket() {

    }

    public DrinkWaterC2SPacket(int key) {
        this.key = key;
    }

    public static void encode(DrinkWaterC2SPacket packet, PacketBuffer buffer) {
        buffer.writeInt(packet.key);
    }

    public static DrinkWaterC2SPacket decode(PacketBuffer buffer) {
        return new DrinkWaterC2SPacket(buffer.readInt());
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayerEntity player = context.getSender();
            World worldIn = context.getSender().getEntityWorld();

            // Check if player is near water

            if(hasWaterAround(player, worldIn, 1)) {
                // Notify the player that water has been drunk
                ITextComponent component = new StringTextComponent(MESSAGE_DRINK_WATER);
                Minecraft.getInstance().player.sendMessage(component, null);
            // play the drinking sound
                worldIn.playSound(null, player.getPosition(), SoundEvents.ENTITY_GENERIC_DRINK, SoundCategory.PLAYERS,
                        0.5F, 1.0F);

                // increase the water level / thirst level of player
                // Output the current thirst level

            } else {
                // Notify the player that there is no water around!
                ITextComponent component = new StringTextComponent(MESSAGE_NO_WATER);
                Minecraft.getInstance().player.sendMessage(component, null);
                // Output the current thirst level
            }

        });
        return true;
    }

    private boolean hasWaterAround(ServerPlayerEntity player, World worldIn, int size) {
        return worldIn.func_234853_a_(player.getBoundingBox().grow(size))
                .filter(state -> state.matchesBlock(Blocks.WATER)).toArray().length > 0;
    }
}
