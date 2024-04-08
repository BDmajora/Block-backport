package bdmajora.backport.tile;

import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.util.helper.MathHelper;

public class BellTileEntity extends TileEntity {
	public int ticks;
	public float ringProgress;
	public float prevRingProgress;
	public float ringT;
	public float ringA;
	public float bellSpread;
	public float prevBellSpread;
	public float bellRot;
	public float prevBellRot;
	public float tRot;
	public float itemRot;

	@Override
	public void tick() {
		ticks++;
		prevBellSpread = bellSpread;
		prevBellRot = bellRot;

		EntityPlayer player = worldObj.getClosestPlayer((float)this.x + 0.5F, (float)this.y + 0.5F, (float)this.z + 0.5F, 3.0D);
		boolean cRot = false;

		if (player != null) {
			double x = player.x - (double)((float)this.x + 0.5F);
			double z = player.z - (double)((float)this.z + 0.5F);
			tRot = (float)Math.atan2(z, x);
			cRot = true;
		}

		if (!cRot) tRot += 0.02F;
		itemRot += 0.03F;

		if (player != null) {
			bellSpread += 0.1F;
			if (bellSpread < 0.5F || worldObj.rand.nextInt(40) == 0) {
				float f = ringT;
				while (true) {
					ringT += (float)(worldObj.rand.nextInt(4) - worldObj.rand.nextInt(4));
					if (f != ringT) break;
				}
			}
		} else bellSpread -= 0.1F;

		while (bellRot >= (float)Math.PI) bellRot -= ((float)Math.PI * 2.0F);
		while (bellRot < -(float)Math.PI) bellRot += ((float)Math.PI * 2.0F);
		while (tRot >= (float)Math.PI) tRot -= ((float)Math.PI * 2.0F);
		while (tRot < -(float)Math.PI) tRot += ((float)Math.PI * 2.0F);
		while (itemRot >= (float)Math.PI) itemRot -= ((float)Math.PI * 2.0F);
		while (itemRot < -(float)Math.PI) itemRot += ((float)Math.PI * 2.0F);

		float f;

		for (f = tRot - bellRot; f >= (float)Math.PI; f -= (float)Math.PI * 2.0F);
		while (f < -(float)Math.PI) f += ((float)Math.PI * 2.0F);

		bellRot += f * 0.4F;
		bellSpread = MathHelper.clamp(bellSpread, 0.0F, 1.0F);
		prevRingProgress = ringProgress;
		float f2 = (ringT - ringProgress) * 0.4F;
		f2 = MathHelper.clamp(f2, -0.2F, 0.2F);
		ringA += (f2 - ringA) * 0.9F;
		ringProgress += ringA;
	}

	public boolean canInteractWith(EntityPlayer player) {
		if (worldObj.getBlockTileEntity(x, y, z) != this) {
			return false;
		}

		return player.distanceToSqr(x + 0.5, y + 0.5, z + 0.5) <= 64.0;
	}
}
