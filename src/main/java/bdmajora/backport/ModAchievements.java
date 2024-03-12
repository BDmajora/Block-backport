//package bdmajora.backport;
//
//import bdmajora.backport.block.ModBlocks;
//import bdmajora.backport.item.ModItems;
//import net.minecraft.client.render.TextureFX;
//import net.minecraft.core.Global;
//import net.minecraft.core.achievement.Achievement;
//import net.minecraft.core.achievement.AchievementList;
//import net.minecraft.core.achievement.stat.StatBase;
//import net.minecraft.core.block.Block;
//import net.minecraft.core.item.Item;
//import net.minecraft.core.util.helper.Side;
//import org.lwjgl.opengl.GL11;
//import turniplabs.halplibe.util.achievements.AchievementPage;
//import turniplabs.halplibe.util.achievements.GuiAchievements;
//import useless.prismaticlibe.helper.ModCheckHelper;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class ModAchievements extends AchievementPage {
//	public static final List<Integer> flowersList = new ArrayList<>();
//
//
//	@Override
//	public void getBackground(GuiAchievements guiAchievements, Random random, int iOffset, int jOffset, int blockX1, int blockY1, int blockX2, int blockY2) {
//		int l7 = 0;
//		while (l7 * 16 - blockY2 < 155) {
//			float f5 = 0.6f - (float) (blockY1 + l7) / 25.0f * 0.3f;
//			GL11.glColor4f(f5, f5, f5, 1.0f);
//			int i8 = 0;
//			while (i8 * 16 - blockX2 < 224) {
//				int k8 = ModBlocks.flintTile.getBlockTextureFromSideAndMetadata(Side.BOTTOM, 0);
//				guiAchievements.drawTexturedModalRect(iOffset + i8 * 16 - blockX2, jOffset + l7 * 16 - blockY2, k8 % Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, k8 / Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain, 16, 16, TextureFX.tileWidthTerrain, 1.0f / (float) (Global.TEXTURE_ATLAS_WIDTH_TILES * TextureFX.tileWidthTerrain));
//				++i8;
//			}
//			++l7;
//		}
//	}
//}
//
//
