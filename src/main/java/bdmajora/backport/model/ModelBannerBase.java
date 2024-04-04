package bdmajora.backport.model;

import net.minecraft.client.render.model.Cube;
import bdmajora.backport.renderer.BannerRenderer;

public class ModelBannerBase {
	public Cube bannerBase = new Cube(0, 0);

	public ModelBannerBase() {
		this.bannerBase.addBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F);
	}

	public void BannerRender() {
		this.bannerBase.render(0.0625F);
	}
}
