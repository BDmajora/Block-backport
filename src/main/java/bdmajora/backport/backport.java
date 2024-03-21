package bdmajora.backport;

import bdmajora.backport.block.ModBlocks;
import bdmajora.backport.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;
import turniplabs.halplibe.util.ConfigHandler;

import java.util.Properties;

public class backport implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {

	static {
		//this is here to possibly fix some class loading issues, do not delete
		try {
			Class.forName("net.minecraft.core.block.Block");
			Class.forName("net.minecraft.core.item.Item");
		} catch (ClassNotFoundException ignored) {}
	}

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
	}

	@Override
	public void afterGameStart() {

	}

	@Override
	public void onRecipesReady() {

	}
}
