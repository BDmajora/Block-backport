package bdmajora.backport.fx;

import net.minecraft.client.entity.fx.EntityFlameFX;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.Global;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

import static bdmajora.backport.backport.MOD_ID;

public class EntitySoulFireFx extends EntityFlameFX {
	private static final int star = TextureHelper.getOrCreateItemTextureIndex(MOD_ID, "soul_fire_flame.png");
	public float originalScale;

	public EntitySoulFireFx(World world, double d, double d1, double d2, double d3, double d4, double d5) {
		super(world, d, d1, d2, d3, d4, d5, Type.BLUE);
		this.particleTextureIndex = star;
		particleScale *= 2.25f;
		originalScale = particleScale;
	}

	public void renderParticle(Tessellator t, float partialTick, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY) {
		float f6 = ((float)this.particleAge + partialTick) / (float)this.particleMaxAge;
		this.particleScale = originalScale * (1.0f - f6 * f6 * 0.5f);
		super.renderParticle(t, partialTick, rotationX, rotationXZ, rotationZ, rotationYZ, rotationXY);
	}

	@Override
	public void tick() {
		super.tick();
		this.particleTextureIndex = star;
	}

	public int getFXLayer() {
		return 2;
	}
}
