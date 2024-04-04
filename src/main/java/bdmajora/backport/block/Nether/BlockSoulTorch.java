package bdmajora.backport.block.Nether;

import net.minecraft.client.Minecraft;
import net.minecraft.core.Global;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.world.World;
import bdmajora.backport.fx.EntitySoulFireFx; // Import your soul fire particle class

import java.util.Random;

public class BlockSoulTorch extends BlockTorch {
	public BlockSoulTorch(String key, int id, Material material) {
		super(key, id);
	}
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		if (!Global.isServer){
			Minecraft mc = Minecraft.getMinecraft(Minecraft.class);
			int l = world.getBlockMetadata(x, y, z);
			double d = (float)x + 0.5f;
			double d1 = (float)y + 0.575f;
			double d2 = (float)z + 0.5f;
			double d3 = 0.22;
			double d4 = 0.27;
			if (l == 1) {
				mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d - d4, d1 + d3, d2, 0.0, 0.0, 0.0));
			} else if (l == 2) {
				mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d + d4, d1 + d3, d2, 0.0, 0.0, 0.0));
			} else if (l == 3) {
				mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0));
			} else if (l == 4) {
				mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0));
			} else {
				mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1, d2, 0.0, 0.0, 0.0));
			}
		}
	}
}
