//package bdmajora.backport.entity;
//
//import bdmajora.backport.model.ModelBanner;
//import bdmajora.backport.entity.TileEntityBanner;
//import bdmajora.backport.renderer.BannerRenderer;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.render.tileentity.TileEntityRenderer;
//import net.minecraft.core.block.Block;
//import net.minecraft.core.world.World;
//import net.minecraft.core.world.wind.WindManager;
//import org.lwjgl.opengl.GL11;
//
//public class TileEntityRendererBanner extends TileEntityRenderer<TileEntityBanner> {
//	private final ModelBanner bannerModel = new ModelBanner();
//	private BannerRenderer bannerRenderer = null;
//
//	public TileEntityRendererBanner() {
//	}
//
//	public void doRender(TileEntityBanner tileEntity, double x, double y, double z, float partialTick) {
//		World theWorld = Minecraft.getMinecraft(this).theWorld;
//		int blockUnder = theWorld.getBlockId(tileEntity.x, tileEntity.y - 1, tileEntity.z);
//		boolean shortPole = blockUnder == Block.banner.id;
//		WindManager theWind = theWorld.getWorldType().getWindManager();
//		float angle = theWind.getWindDirection(theWorld, (float)x, (float)y, (float)z) * 360.0F;
//		this.doRender(tileEntity, x, y, z, partialTick, shortPole, angle);
//	}
//
//	public void doRender(TileEntityBanner tileEntity, double x, double y, double z, float partialTick, boolean shortPole, float rotationAngle) {
//		if (this.bannerRenderer == null) {
//			this.bannerRenderer = new BannerRenderer(this.renderDispatcher.renderEngine);
//		}
//
//		this.bannerRenderer.updateTexture(tileEntity);
//		float sway = (float)(((double)Minecraft.getMinecraft(this).theWorld.getWorldTime() + (double)partialTick) / 1.5 % 6.283185307179586);
//		GL11.glPushMatrix();
//		float scale = 1.0F;
//		GL11.glTranslatef((float)x + 0.5F, (float)y + 0.75F, (float)z + 0.5F);
//		GL11.glScalef(1.0F, -1.0F, -1.0F);
//		this.loadTexture("/item/banner.png");
//		if (shortPole) {
//			this.bannerModel.renderPoleShort();
//		} else {
//			this.bannerModel.renderBase();
//			this.bannerModel.renderPole();
//		}
//
//		GL11.glPushMatrix();
//		GL11.glRotatef(rotationAngle, 0.0F, 1.0F, 0.0F);
//		GL11.glRotatef((float)Math.sin((double)sway) * 2.0F, 0.0F, 1.0F, 0.0F);
//		this.bannerModel.renderBanner();
//		this.renderDispatcher.renderEngine.bindTexture(this.bannerRenderer.getTexture());
//		GL11.glEnable(3042);
//		GL11.glBlendFunc(769, 768);
//		this.bannerModel.renderBannerOverlay();
//		GL11.glDisable(3042);
//		GL11.glPopMatrix();
//		float f4 = 0.01666667F;
//		GL11.glTranslatef(0.0F, 0.5F, 0.07F);
//		GL11.glScalef(0.01666667F, -0.01666667F, 0.01666667F);
//		GL11.glNormal3f(0.0F, 0.0F, -0.01666667F);
//		GL11.glPopMatrix();
//	}
//}
