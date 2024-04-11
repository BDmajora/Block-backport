package bdmajora.backport.block.gui;

import net.minecraft.core.block.BlockAxisAligned;
import net.minecraft.core.block.BlockRotatable;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.entity.EntityLiving;
import net.minecraft.core.enums.PlacementMode;
import net.minecraft.core.util.helper.Axis;
import net.minecraft.core.util.helper.Direction;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.util.helper.Sides;
import net.minecraft.core.world.World;

public class BlockBarrel extends BlockRotatable {

	public BlockBarrel(String key, int id, Material material) {
		super(key, id, material);
	}

}
