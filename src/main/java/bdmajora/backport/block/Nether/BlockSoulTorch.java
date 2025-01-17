package bdmajora.backport.block.Nether;

import java.util.Random;

import net.minecraft.client.entity.fx.EntityFlameFX;
import net.minecraft.client.entity.fx.EntitySmokeFX;
import net.minecraft.core.HitResult;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTorch;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import static useless.dragonfly.model.block.BlockModelRenderer.mc;

public class BlockSoulTorch extends BlockTorch {
	public BlockSoulTorch(String key, int id) {
		super(key, id);
		this.setTicking(true);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
		int l = world.getBlockMetadata(x, y, z);
		double d = (float)x + 0.5F;
		double d1 = (float)y + 0.7F;
		double d2 = (float)z + 0.5F;
		double d3 = 0.22;
		double d4 = 0.27;
		if (l == 1) {
           world.spawnParticle("smoke", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
			world.spawnParticle("blueflame", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
		} else if (l == 2) {
            world.spawnParticle("smoke", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
			world.spawnParticle("blueflame", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
		} else if (l == 3) {
           world.spawnParticle("smoke", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
			world.spawnParticle("blueflame", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
		} else if (l == 4) {
           world.spawnParticle("smoke", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
			world.spawnParticle("blueflame", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
		} else {
           world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0);
			world.spawnParticle("blueflame", d, d1, d2, 0.0, 0.0, 0.0);
		}

	}
}

