package G4meM0ment.QuestMenu;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.GUI.GUI;
import G4meM0ment.QuestMenu.GUI.GUIManager;
import G4meM0ment.QuestMenu.listener.CitizenListener;
import G4meM0ment.QuestMenu.listener.PListener;
import G4meM0ment.QuestMenu.listener.SpoutListener;
import G4meM0ment.QuestMenu.quests.QuestManager;

public class QuestMenu extends JavaPlugin {
	
	QuestMenu plugin;
	public GUI gui;
	public PListener plistener;
	public SpoutListener spoutlistener;
	public CitizenListener clistener;
	public QuestManager qm;
	public GUIManager gm;
	public SpoutManager sm;
	public PluginManager pm;
	
	private String dir				=	"plugins/QuestMenu";
	private String dataDir			=	dir+"/data";
	
	private FileConfiguration customConfig = null;
	private File playerData;
	
	public void onDisable() {
		saveConfig();
		saveCustomConfig();
		qm.saveCustomConfig();
	}
	
	public void onEnable() {
		pm = getServer().getPluginManager();
		
		plugin = this;
		gui = new GUI(this,qm,gm);
		qm = new QuestManager(this, dataDir);
		gm = new GUIManager(this, qm);
		
		playerData = new File(dataDir+"/player_data");

		plistener = new PListener(this);
		pm.registerEvents(plistener, this);
		spoutlistener = new SpoutListener(this, gui);
		pm.registerEvents(spoutlistener, this);
		clistener = new CitizenListener(this, qm);
		pm.registerEvents(clistener, this);
		
		getConfig().options().copyDefaults(true);
		saveConfig();
		reloadCustomConfig();
		saveCustomConfig();
		qm.reloadCustomConfig();
		qm.saveCustomConfig();
		
		this.getLogger().info("Enabled!");
	}
			
	public void reloadCustomConfig() {
		if (playerData == null) {
		    	playerData = new File(this.getDataFolder(), "player_data");
		}
		customConfig = YamlConfiguration.loadConfiguration(playerData);
		 
		// Look for defaults in the jar
		InputStream defConfigStream = this.getResource("player_data");
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
		if (customConfig == null || playerData == null) {
		    return;
		 }
		try {
			customConfig.save(playerData);
		} catch (IOException ex) {
			Logger.getLogger(JavaPlugin.class.getName()).log(Level.SEVERE, "Could not save config to " + playerData, ex);
		}
	}
	
	public void newPlayer(Player player) {
		if(existsPlayer(player)) {
			return;
		}
		String pname = player.getName();
		getCustomConfig().set("players." +pname +".quests.actual", null);
		getCustomConfig().set("players." +pname +".quests.showed", null);
		getCustomConfig().set("players." +pname +".quests.active", null);
		getCustomConfig().set("players." +pname +".quests.completed", null);
		getCustomConfig().set("players." +pname +".quests.inactive", null);
		saveCustomConfig();
	}
	
	/**
	 * Checks if the player is already listed	
	 * @param player to be checked
	 * @return boolean
	 */
	public boolean existsPlayer(Player player) {
		ConfigurationSection cfgsel = getCustomConfig().getConfigurationSection("players");
		if (cfgsel == null) return false;
		Set<String> names = cfgsel.getKeys(false);
		String pname = player.getName();
		
		try {
			for (String name : names) {
				if(name.equalsIgnoreCase(pname)) {
					return true;
				}
			}
		}catch (NullPointerException e) {
			return false;
		}
		return false;
	}
	
	public boolean checkSpout(Player player)
	{
		if(SpoutManager.getPlayer(player).isSpoutCraftEnabled())
			return true;
		else
			return false;
	}
	public boolean checkSpout(SpoutPlayer player)
	{
		if(SpoutManager.getPlayer(player).isSpoutCraftEnabled())
			return true;
		else
			return false;
	}
	
}
