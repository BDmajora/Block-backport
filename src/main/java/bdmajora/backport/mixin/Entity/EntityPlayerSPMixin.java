package bdmajora.backport.mixin.Entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.EntityPlayerSP;
import net.minecraft.core.player.Session;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = EntityPlayerSP.class, remap = false)
public class EntityPlayerSPMixin {
	@Unique
	private final Minecraft mc = Minecraft.getMinecraft(this);
	@Unique
	private final EntityPlayerSP thisAs = (EntityPlayerSP)(Object)this;
	@Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Lnet/minecraft/core/world/World;Lnet/minecraft/core/player/Session;I)V", at = @At("TAIL"))
	private void init(Minecraft minecraft, World world, Session session, int i, CallbackInfo ci){
	}
}
