package bdmajora.backport.block.client;

import net.minecraft.client.render.model.Cube;
import net.minecraft.client.render.model.ModelBase;
import net.minecraft.core.util.helper.MathHelper;

public class BellModel extends ModelBase {
	public Cube bellBody = new Cube(0, 0);
	public Cube bellTop = new Cube(16, 0);
	public Cube bellBottom = new Cube(0, 10);

	public BellModel() {
		bellBody.addBox(-3.0F, -6.0F, -3.0F, 6, 7, 6);
		bellBody.setRotationPoint(8.0F, 12.0F, 8.0F);
		bellTop.addBox(4.0F, 4.0F, 4.0F, 8, 2, 8);
		bellTop.setRotationPoint(-8.0F, -12.0F, -8.0F);
		bellBottom.addBox(-1.0F, -5.0F, 0.0F, 2, 10, 0);
	}

	public void renderBell(float f3, float f4, float f5, float scale, float v) {
		this.setRotationAngles(f3, f4, f5, 0.0F, 0.0F, scale);
		bellBody.render(scale);
		bellTop.render(scale);
		bellBottom.render(scale);
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbYaw, float limbPitch, float headYaw, float headPitch, float scale) {
		float f = (MathHelper.sin(limbSwing * 0.02F) * 0.1F + 1.25F) * headYaw;
		bellBody.rotateAngleY = ((float)Math.PI + f);
		bellTop.rotateAngleY = -f;
		bellBottom.rotateAngleY = f;
		bellBody.rotationPointX = MathHelper.sin(f);
		bellTop.rotationPointX = MathHelper.sin(f);
		bellBottom.rotationPointX = MathHelper.sin(f);
	}
}
