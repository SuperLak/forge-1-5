package net.kal.tutorialmod.block.custom;

import net.kal.tutorialmod.item.custom.FireGem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FireGemBlock extends Block {

    public FireGemBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Minecraft.getInstance().player.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100));
        super.onEntityWalk(worldIn, pos, entityIn);
    }
}
