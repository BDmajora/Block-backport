package bdmajora.backport.renderer;


import net.minecraft.client.render.FlagRenderer;
import net.minecraft.client.GLAllocation;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.util.helper.Colors;
import net.minecraft.core.block.entity.TileEntityFlag;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.net.command.TextFormatting;

public class BannerRenderer {
	public final int CANVAS_WIDTH = 24;
	public final int CANVAS_HEIGHT = 16;
	private final RenderEngine renderEngine;
	private final int texture;

	public BannerRenderer(RenderEngine renderEngine) {
		this.renderEngine = renderEngine;
		this.texture = renderEngine.createTexture(24, 16);
	}

	protected void finalize() throws Throwable {
		super.finalize();
		GLAllocation.deleteTexture(this.texture);
	}

	public void updateTexture(TileEntityFlag tileEntity) {
		byte[] flagColors = tileEntity.flagColors;
		int[] rgbFlagColors = this.flagDataToRGB(tileEntity, flagColors);
		this.renderEngine.updateTextureData(rgbFlagColors, 24, 16, this.texture);
	}

	public int getTexture() {
		return this.texture;
	}

	private int[] flagDataToRGB(TileEntityFlag tileEntity, byte[] colorData) {
		int[] data = new int[384];

		for(int i = 0; i < 384; ++i) {
			byte color = colorData[i];
			int col = this.getColorMap(tileEntity, color);
			int alpha = col >> 24 & 255;
			int red = col >> 16 & 255;
			int green = col >> 8 & 255;
			int blue = col >> 0 & 255;
			data[i] = alpha << 24 | red << 16 | green << 8 | blue << 0;
		}

		return data;
	}

	private int getColorMap(TileEntityFlag tileEntity, int index) {
		int col = 16777215;
		if (index > 0 && index <= 3) {
			ItemStack stack = tileEntity.getStackInSlot(35 + index);
			if (stack != null && stack.getItem() == Item.dye) {
				col = Colors.allFlagColors[TextFormatting.get(15 - stack.getMetadata()).id].getARGB();
			}
		}

		return col;
	}
}

