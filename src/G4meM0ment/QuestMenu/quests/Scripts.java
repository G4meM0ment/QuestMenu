package G4meM0ment.QuestMenu.quests;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import G4meM0ment.QuestMenu.QuestMenu;

public class Scripts {
	
	
	private QuestMenu plugin;
	private FileConfiguration customConfig = null;
	private File quests;
	private String dataDir;
	
	public Scripts(QuestMenu plugin, String dataDir)
	{
		this.plugin = plugin;
		this.dataDir = dataDir;
		this.quests = new File(this.dataDir+"/quests");
	}
	 
	public void reloadCustomConfig() {
		if (quests == null) {
		    	quests = new File(plugin.getDataFolder(), "quests");
		}
		customConfig = YamlConfiguration.loadConfiguration(quests);
		 
		// Look for defaults in the jar
		InputStream defConfigStream = plugin.getResource("quests");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			customConfig.setDefaults(defConfig);
		}
	}
		
	public FileConfiguration getCustomConfig() {
		if (customConfig == null) {
			reloadCustomConfig();
		}
		return customConfig;
	}
		
	public void saveCustomConfig() {
		if (customConfig == null || quests == null) {
		    return;
		 }
		try {
			customConfig.save(quests);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + quests, ex);
		}
	}
}
