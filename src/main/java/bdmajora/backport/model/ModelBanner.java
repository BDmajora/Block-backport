package bdmajora.backport.model;

import net.minecraft.client.render.model.Cube;

public class ModelBanner {
	public Cube bannerPole = new Cube(0, 0, 64, 48);
	public Cube bannerPoleShort;
	public Cube banner;
	public Cube bannerOverlay;
	public Cube bannerBase;

	public ModelBanner() {
		this.bannerPole.addBox(-1.0F, -22.0F, -1.0F, 2, 33, 2, 0.0F);
		this.bannerPoleShort = new Cube(0, 0, 64, 48);
		this.bannerPoleShort.addBox(-1.0F, -22.0F, -1.0F, 2, 16, 2, 0.0F);
		this.banner = new Cube(8, 0, 64, 48);
		this.banner.addBox(1.0F, -21.0F, -0.0F, 24, 16, 0, 0.0F);
		this.bannerOverlay = new Cube(0, 0, 24, 16);
		this.bannerOverlay.addBox(1.0F, -21.0F, -0.0F, 24, 16, 0, 0.0F);
		this.bannerBase = new Cube(0, 40, 64, 48);
		this.bannerBase.addBox(-2.0F, 11.0F, -2.0F, 4, 1, 4, 0.0F);
	}

	public void renderPole() {
		this.bannerPole.render(0.0625F);
	}

	public void renderPoleShort() {
		this.bannerPoleShort.render(0.0625F);
	}

	public void renderBase() {
		this.bannerBase.render(0.0625F);
	}

	public void renderFlag() {
		this.banner.render(0.0625F);
	}

	public void renderFlagOverlay() {
		this.bannerOverlay.render(0.0625F);
	}
}
