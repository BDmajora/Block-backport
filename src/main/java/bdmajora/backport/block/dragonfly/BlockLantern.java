package bdmajora.backport.block.dragonfly;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.BlockTransparent;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.phys.AABB;
import net.minecraft.core.world.World;
import useless.dragonfly.model.block.processed.BlockCube;
import useless.dragonfly.model.block.processed.BlockModel;

import java.util.ArrayList;

public class BlockLantern extends BlockTransparent {
	public useless.dragonfly.model.block.processed.BlockModel model;

	public BlockLantern(String key, int id, Material material, BlockModel model) {
		super(key, id, material, true);
		this.model = model;
	}

	@Override
	public void onBlockPlaced(World world, int x, int y, int z, Side side, EntityLiving entity, double sideHeight) {
		if ((side == Side.BOTTOM || side != Side.TOP && sideHeight >= 0.5) && (world.isBlockNormalCube(x, y + 1, z) || Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF))) {
			world.setBlockMetadataWithNotify(x, y, z, 1);
		} else if ((side == Side.TOP || side != Side.BOTTOM && sideHeight < 0.5) && world.canPlaceOnSurfaceOfBlock(x, y - 1, z)) {
			world.setBlockMetadataWithNotify(x, y, z, 0);
		} else {
			if (!world.isBlockNormalCube(x, y + 1, z) && !Block.hasTag(world.getBlockId(x, y + 1, z), BlockTags.CAN_HANG_OFF)) {
				world.setBlockMetadataWithNotify(x, y, z, 0);
			} else {
				world.setBlockMetadataWithNotify(x, y, z, 1);
			}
		}
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean canPlaceOnSurface() {
		return true;
	}

	@Override
	public int getRenderBlockPass() {
		return 0;
	}
	@Override
	public void getCollidingBoundingBoxes(World world, int x, int y, int z, AABB aabb, ArrayList<AABB> aabbList) {
		for (BlockCube cube: model.blockCubes) {
			setBlockBounds(cube.xMin(), cube.yMin(), cube.zMin(), cube.xMax(), cube.yMax(), cube.zMax());
			super.getCollidingBoundingBoxes(world, x, y, z, aabb, aabbList);
		}
		this.setBlockBounds(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	}
}

