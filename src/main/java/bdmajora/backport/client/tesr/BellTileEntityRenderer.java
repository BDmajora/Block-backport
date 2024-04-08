package bdmajora.backport.client.tesr;

import bdmajora.backport.backport;
import bdmajora.backport.tile.BellTileEntity;
import bdmajora.backport.block.client.BellModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.render.EntityRenderDispatcher;
import net.minecraft.client.render.block.model.BlockModelDispatcher;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.tileentity.TileEntityRenderer;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.util.helper.MathHelper;
import org.lwjgl.opengl.GL11;

public class BellTileEntityRenderer extends TileEntityRenderer<BellTileEntity> {
	private static final BellModel model = new BellModel();
	private static final String texturePath = "assets/" + backport.MOD_ID + "entity/bell/bell_body.png";
	private final EntityItem entityItem = new EntityItem(null);
	private final ItemEntityRenderer renderer = new ItemEntityRenderer();

	{
		renderer.setRenderDispatcher(EntityRenderDispatcher.instance);
	}

	@Override
	public void doRender(BellTileEntity bell, double x, double y, double z, float partialTicks) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
		float t = bell.ticks + partialTicks;
		float f;
		GL11.glTranslatef(0.0F, 0.1F + MathHelper.sin(t * 0.1F) * 0.01F, 0.0F);

		for (f = bell.bellRot - bell.prevBellRot; f >= (float)Math.PI; f -= ((float)Math.PI * 2.0F));
		while (f < -(float)Math.PI) f += ((float)Math.PI * 2.0F);

		float f2 = bell.prevBellRot + f * partialTicks;
		GL11.glRotatef(-f2 * (180.0F / (float)Math.PI), 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(80.0F, 0.0F, 0.0F, 1.0F);
		this.loadTexture(texturePath);
		float f3 = bell.prevRingProgress + (bell.ringProgress - bell.prevRingProgress) * partialTicks + 0.25F;
		float f4 = bell.prevRingProgress + (bell.ringProgress - bell.prevRingProgress) * partialTicks + 0.75F;
		f3 = (f3 - (float)MathHelper.floor_float(f3)) * 1.6F - 0.3F;
		f4 = (f4 - (float)MathHelper.floor_float(f4)) * 1.6F - 0.3F;

		if (f3 < 0.0F) f3 = 0.0F;
		if (f4 < 0.0F) f4 = 0.0F;
		if (f3 > 1.0F) f3 = 1.0F;
		if (f4 > 1.0F) f4 = 1.0F;

		float f5 = bell.prevBellSpread + (bell.bellSpread - bell.prevBellSpread) * partialTicks;
		GL11.glEnable(GL11.GL_CULL_FACE);
		model.renderBell(f3, f4, f5, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}
}

