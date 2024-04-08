package bdmajora.backport;

import bdmajora.backport.biome.ModBiomes;
import bdmajora.backport.block.ModBlocks;
import bdmajora.backport.crafting.ModCraftingManager;
import bdmajora.backport.item.ModItems;
import bdmajora.backport.tile.BellTileEntity;
import bdmajora.backport.world.biome.provider.BiomeProviderNether;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.BlockCoords;
import turniplabs.halplibe.util.ConfigHandler;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class backport implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {

	public static final String MOD_ID = "backport";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","7000");
		prop.setProperty("starting_item_id","30000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		UtilIdRegistrar.initIds(config.getInt("starting_block_id"), config.getInt("starting_item_id"));
		config.updateConfig();
	}

	@Override
	public void onInitialize() {
		LOGGER.info("backport loading! watch out for bugs");
		handleConfig();

		LOGGER.info("BackPort loaded successfully!");
	}

	@Override
	public void beforeGameStart() {
		ModBlocks.register();
		ModItems.register();
		ModBiomes.initializeBiomes();
		BiomeProviderNether.init();

	}

	@Override
	public void afterGameStart() {
//		System.out.println("The length of the BlockCoords used textures array is: " + BlockCoords.usedCoordinates.length);
	}

	@Override
	public void onRecipesReady() {
		ModCraftingManager.onRecipesReady();
	}

	public void initNamespaces() {
		Registries.RECIPES.register(MOD_ID, new RecipeNamespace());
	}
}
