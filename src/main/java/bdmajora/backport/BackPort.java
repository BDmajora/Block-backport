package bdmajora.backport;

import bdmajora.backport.block.*;
import bdmajora.backport.crafting.ModCraftingManager;
import bdmajora.backport.entity.ModEntities;
import bdmajora.backport.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.ConfigHandler;
import useless.prismaticlibe.helper.SoundHelper;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

import java.util.Properties;

public class BackPort implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static final String MOD_ID = "backport";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private void handleConfig() {
		Properties prop = new Properties();
		prop.setProperty("starting_block_id","9000");
		prop.setProperty("starting_item_id","20000");
		ConfigHandler config = new ConfigHandler(MOD_ID,prop);
		UtilIdRegistrar.initIds(
			config.getInt("starting_block_id"),
			config.getInt("starting_item_id"));
		config.updateConfig();
	}


	@Override
	public void onInitialize() {
		LOGGER.info("watch out for bugs");
		handleConfig();

		ModItems.register();

		SoundHelper.addStreaming(MOD_ID, "pig_step.ogg");
	}

	@Override
	public void beforeGameStart() {

	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}
