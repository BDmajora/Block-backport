//package bdmajora.backport.mixin;
//
//import bdmajora.backport.block.Crops.BlockCropsTorchFlower;
//import bdmajora.backport.block.ModBlocks;
//import net.minecraft.core.block.Block;
//import net.minecraft.core.block.BlockCropsPumpkin;
//import net.minecraft.core.block.BlockCropsWheat;
//import net.minecraft.core.entity.player.EntityPlayer;
//import net.minecraft.core.item.ItemDye;
//import net.minecraft.core.item.ItemStack;
//import net.minecraft.core.util.helper.Side;
//import net.minecraft.core.world.World;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//
//@Mixin(value = ItemDye.class, remap = false)
//public class ItemDyeMixin {
//	@Inject(method = "onItemUse", at = @At("HEAD"), cancellable = true)
//	private void addCropFertilization(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced, CallbackInfoReturnable<Boolean> cir){
//		if (itemstack.getMetadata() == 15) {
//			int id = world.getBlockId(blockX, blockY, blockZ);
//			int meta = world.getBlockMetadata(blockX, blockY, blockZ);
//			if (id == ModBlocks.cropsTorchFlower.id && meta < 1) {
//				if (!world.isClientSide) {
//					((BlockCropsTorchFlower)ModBlocks.cropsTorchFlower).fertilize(world, blockX, blockY, blockZ);
//					if (entityplayer.getGamemode().consumeBlocks()) {
//						--itemstack.stackSize;
//					}
//				}
//				cir.setReturnValue(true);
//			}
//		}
//	}
//}
//
