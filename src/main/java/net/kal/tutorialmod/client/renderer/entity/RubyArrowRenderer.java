package net.kal.tutorialmod.client.renderer.entity;

import net.kal.tutorialmod.TutorialMod;
import net.kal.tutorialmod.world.entity.projectile.RubyArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RubyArrowRenderer extends ArrowRenderer<RubyArrowEntity> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MOD_ID,
            "textures/entity/projectiles/ruby_arrow.png");

    public RubyArrowRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getEntityTexture(RubyArrowEntity entity) {
        return TEXTURE;
    }
}
