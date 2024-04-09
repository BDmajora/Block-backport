package bdmajora.backport.block.Nether;

import java.util.Random;

import net.minecraft.core.HitResult;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.util.phys.Vec3d;
import net.minecraft.core.world.World;

import static useless.dragonfly.model.block.BlockModelRenderer.mc;

public class BlockSoulTorch
	extends Block {
	public BlockSoulTorch(String key, int id, Material material) {
		super(key, id, material);
		this.setTicking(true);
	}

	@Override
	public AABB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public boolean isSolidRender() {
		return false;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	private boolean canPlaceOnTop(World world, int x, int y, int z) {
		int id = world.getBlockId(x, y, z);
		return world.canPlaceOnSurfaceOfBlock(x, y, z) || id == Block.fencePlanksOak.id || id == Block.fencePlanksOakPainted.id;
	}

	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		if (world.isBlockNormalCube(x - 1, y, z)) {
			return true;
		}
		if (world.isBlockNormalCube(x + 1, y, z)) {
			return true;
		}
		if (world.isBlockNormalCube(x, y, z - 1)) {
			return true;
		}
		if (world.isBlockNormalCube(x, y, z + 1)) {
			return true;
		}
		return world.canPlaceOnSurfaceOfBlock(x, y - 1, z);
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		int l = side.getId();
		int i1 = world.getBlockMetadata(x, y, z);
		if (l == 1 && this.canPlaceOnTop(world, x, y - 1, z)) {
			i1 = 5;
		}
		if (l == 2 && world.isBlockNormalCube(x, y, z + 1)) {
			i1 = 4;
		}
		if (l == 3 && world.isBlockNormalCube(x, y, z - 1)) {
			i1 = 3;
		}
		if (l == 4 && world.isBlockNormalCube(x + 1, y, z)) {
			i1 = 2;
		}
		if (l == 5 && world.isBlockNormalCube(x - 1, y, z)) {
			i1 = 1;
		}
		world.setBlockMetadataWithNotify(x, y, z, i1);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand) {
		super.updateTick(world, x, y, z, rand);
		if (world.getBlockMetadata(x, y, z) == 0) {
			this.onBlockAdded(world, x, y, z);
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		if (world.isBlockNormalCube(x - 1, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 1);
		} else if (world.isBlockNormalCube(x + 1, y, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 2);
		} else if (world.isBlockNormalCube(x, y, z - 1)) {
			world.setBlockMetadataWithNotify(x, y, z, 3);
		} else if (world.isBlockNormalCube(x, y, z + 1)) {
			world.setBlockMetadataWithNotify(x, y, z, 4);
		} else if (this.canPlaceOnTop(world, x, y - 1, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 5);
		}
		this.dropTorchIfCantStay(world, x, y, z);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, int blockId) {
		if (this.dropTorchIfCantStay(world, x, y, z)) {
			int i1 = world.getBlockMetadata(x, y, z);
			boolean flag = false;
			if (!world.isBlockNormalCube(x - 1, y, z) && i1 == 1) {
				flag = true;
			}
			if (!world.isBlockNormalCube(x + 1, y, z) && i1 == 2) {
				flag = true;
			}
			if (!world.isBlockNormalCube(x, y, z - 1) && i1 == 3) {
				flag = true;
			}
			if (!world.isBlockNormalCube(x, y, z + 1) && i1 == 4) {
				flag = true;
			}
			if (!this.canPlaceOnTop(world, x, y - 1, z) && i1 == 5) {
				flag = true;
			}
			if (flag) {
				this.dropBlockWithCause(world, EnumDropCause.WORLD, x, y, z, i1, null);
				world.setBlockWithNotify(x, y, z, 0);
			}
		}
	}

	private boolean dropTorchIfCantStay(World world, int i, int j, int k) {
		if (!this.canPlaceBlockAt(world, i, j, k)) {
			this.dropBlockWithCause(world, EnumDropCause.WORLD, i, j, k, world.getBlockMetadata(i, j, k), null);
			world.setBlockWithNotify(i, j, k, 0);
			return false;
		}
		return true;
	}

	@Override
	public HitResult collisionRayTrace(World world, int x, int y, int z, Vec3d start, Vec3d end) {
		int l = world.getBlockMetadata(x, y, z) & 7;
		float f = 0.15f;
		if (l == 1) {
			this.setBlockBounds(0.0f, 0.2f, 0.5f - f, f * 2.0f, 0.8f, 0.5f + f);
		} else if (l == 2) {
			this.setBlockBounds(1.0f - f * 2.0f, 0.2f, 0.5f - f, 1.0f, 0.8f, 0.5f + f);
		} else if (l == 3) {
			this.setBlockBounds(0.5f - f, 0.2f, 0.0f, 0.5f + f, 0.8f, f * 2.0f);
		} else if (l == 4) {
			this.setBlockBounds(0.5f - f, 0.2f, 1.0f - f * 2.0f, 0.5f + f, 0.8f, 1.0f);
		} else {
			float f1 = 0.1f;
			this.setBlockBounds(0.5f - f1, 0.0f, 0.5f - f1, 0.5f + f1, 0.6f, 0.5f + f1);
		}
		return super.collisionRayTrace(world, x, y, z, start, end);
	}

//	@Override
//	public void randomDisplayTick(World world, int x, int y, int z, Random rand) {
//		int l = world.getBlockMetadata(x, y, z);
//		double d = (float)x + 0.5f;
//		double d1 = (float)y + 0.7f;
//		double d2 = (float)z + 0.5f;
//		double d3 = 0.22;
//		double d4 = 0.27;
//		if (l == 1) {
//			world.spawnParticle("smoke", d - d4, d1 + d3, d2, 0.0, 0.0, 0.0);
//			mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d - d4, d1 + d3, d2, 0.0, 0.0, 0.0));
//		} else if (l == 2) {
//			world.spawnParticle("smoke", d + d4, d1 + d3, d2, 0.0, 0.0, 0.0);
//			mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d + d4, d1 + d3, d2,  0.0, 0.0, 0.0));
//		} else if (l == 3) {
//			world.spawnParticle("smoke", d, d1 + d3, d2 - d4, 0.0, 0.0, 0.0);
//			mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1 + d3, d2 - d4,  0.0, 0.0, 0.0));
//		} else if (l == 4) {
//			world.spawnParticle("smoke", d, d1 + d3, d2 + d4, 0.0, 0.0, 0.0);
//			mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1 + d3, d2 + d4,  0.0, 0.0, 0.0));
//		} else {
//			world.spawnParticle("smoke", d, d1, d2, 0.0, 0.0, 0.0);
//			mc.effectRenderer.addEffect(new EntitySoulFireFx(world, d, d1, d2, 0.0, 0.0, 0.0));
//		}
//	}
}

