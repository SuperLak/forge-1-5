package net.kal.tutorialmod.networking.packet;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacket {

    public int key;

    public ExampleC2SPacket() {

    }

    public ExampleC2SPacket(int key) {
        this.key = key;
    }

    public static void encode(ExampleC2SPacket packet, PacketBuffer buffer) {
        buffer.writeInt(packet.key);
    }

    public static ExampleC2SPacket decode(PacketBuffer buffer) {
        return new ExampleC2SPacket(buffer.readInt());
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayerEntity player = context.getSender();
            ServerWorld worldIn = context.getSender().getServerWorld();
            World world = player.getEntityWorld();

            // Spawns a cow
            EntityType.COW.spawn(worldIn, null, null, player.getPosition(),
                    SpawnReason.COMMAND, true, false);

            // Gives the player a diamond
            player.addItemStackToInventory(new ItemStack(Items.DIAMOND));

            // Changes the block at the player's feet to diamond
            world.setBlockState(player.getPosition().down(), Blocks.DIAMOND_BLOCK.getDefaultState());

        });
        return true;
    }
}
