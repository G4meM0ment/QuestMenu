package G4meM0ment.QuestMenu.quests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.aufdemrand.denizen.Denizen;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.QuestMenu;

public class QuestManager {
	
	private QuestMenu plugin;
	private FileConfiguration customConfig = null;
	private File quests;
	private String dataDir;
	private Denizen denizen;
	
	public QuestManager(QuestMenu plugin, String dataDir)
	{
		this.plugin = plugin;
		this.dataDir = dataDir;
		this.quests = new File(this.dataDir+"/quests");
	}
	
	//*** Quest File ***
	public void reloadCustomConfig() {
		if (quests == null) {
		    	quests = new File(plugin.getDataFolder(), "read-only-quests");
		}
		customConfig = YamlConfiguration.loadConfiguration(quests);
		
		try {
			ConcatenateQuests();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
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
	
	public boolean fileExists() {
		if(quests == null)
			return false;
		else
			return true;
	}
	
	
	/* got this code from
	 * denizen
	 * thanks to aufdemrand
	 */
	private void ConcatenateQuests() throws IOException {

		try {

			PrintWriter pw = new PrintWriter(new FileOutputStream(plugin.getDataFolder() + File.separator + "read-only-quests.yml"));
			File file = new File(plugin.getDataFolder() + File.separator + "scripts");
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {

				String fileName = files[i].getName();
				if (fileName.substring(fileName.lastIndexOf('.') + 1).equalsIgnoreCase("YML")) {

					plugin.getLogger().log(Level.INFO, "Processing script " + files[i].getPath() + "... ");
					BufferedReader br = new BufferedReader(new FileReader(files[i].getPath()));
					String line = br.readLine();
					while (line != null) {
						pw.println(line);
						line = br.readLine();
					}
					br.close();
				}
			}
			pw.close();
			plugin.getLogger().log(Level.INFO, "All quests loaded!");

		} catch (Throwable error) {
			plugin.getLogger().log(Level.WARNING, "No scripts to load in plugin/QuestMenu/quests");	
		}
	}
	
	//***Set/Add/Remove Quest-Methods***
	public void setShowedPlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.showed", quest);
		}
		else {
			return;
		}
	}
	public void setShowedPlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.showed", quest);
		}
		else {
			return;
		}
	}
	
	public void setActualPlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.actual", quest);
		}
		else {
			return;
		}
	}
	public void setActualPlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.actual", quest);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to add Strings to a StringList in a memory section
	public void addActivPlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.active");
			list.add(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.active", list);
		}
		else {
			return;
		}
	}
	public void addActivPlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.active");
			list.add(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.active", list);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to add Strings to a StringList in a memory section
	public void addCompletedPlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.completed");
			list.add(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.completed", list);
		}
		else {
			return;
		}
	}
	public void addCompletedPlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.completed");
			list.add(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.completed", list);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to add Strings to a StringList in a memory section
	public void addInactivePlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.inactive");
			list.add(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.inactive", list);
		}
		else {
			return;
		}
	}
	public void addInactivePlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.inactive");
			list.add(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.inactive", list);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to remove Strings to a StringList in a memory section
	public void removeActivePlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.active");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.active", list);
		}
		else {
			return;
		}
	}
	public void removeActivePlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.active");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.active", list);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to remove Strings to a StringList in a memory section	
	public void removeCompletedPlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.completed");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.completed", list);
		}
		else {
			return;
		}
	}
	public void removeCompletedPlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.completed");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.completed", list);
		}
		else {
			return;
		}
	}
	
	//TODO find a way to remove Strings to a StringList in a memory section	
	public void removeInactivePlayerQuest(SpoutPlayer sp, String quest)
	{
		if(sp != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(sp))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.inactive");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + sp.getName() + ".quests.inactive", list);
		}
		else {
			return;
		}
	}
	public void removeInactivePlayerQuest(Player p, String quest)
	{
		if(p != null && quest != null && plugin.getCustomConfig().getStringList("quests").contains(quest) && plugin.checkSpout(p))
		{
			List<String> list = plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.inactive");
			list.remove(quest);
			plugin.getCustomConfig().set("players." + p.getName() + ".quests.inactive", list);
		}
		else {
			return;
		}
	}

	//***Get Quests-Methods***
	public String getShowedPlayerQuest(SpoutPlayer sp)
	{
		if(sp != null && plugin.getCustomConfig().getString("players." + sp.getName() + ".quests.showed") != null && plugin.checkSpout(sp)) {
			String actualQuestName = plugin.getCustomConfig().getString("players." + sp.getName() + "quests.showed");
			return actualQuestName;
		}
		else{
			return null;
		}
	}
	public String getShowedPlayerQuest(Player p)
	{
		if(p != null && plugin.getCustomConfig().getString("players." + p.getName() + ".quests.showed") != null && plugin.checkSpout(p)) {
			String actualQuestName = plugin.getCustomConfig().getString("players." + p.getName() + "quests.showed");
			return actualQuestName;
		}
		else{
			return null;
		}
	}
	
	public String getActualPlayerQuest(SpoutPlayer sp)
	{
		if(sp != null && plugin.getCustomConfig().getString("players." + sp.getName() + ".quests.actual") != null && plugin.checkSpout(sp)) {
			String actualQuestName = plugin.getCustomConfig().getString("players." + sp.getName() + "quests.actual");
			return actualQuestName;
		}
		else {
			return null;
		}
	}
	public String getActualPlayerQuest(Player p)
	{
		if(p != null && plugin.getCustomConfig().getString("players." + p.getName() + ".quests.actual") != null && plugin.checkSpout(p)) {
			String actualQuestName = plugin.getCustomConfig().getString("players." + p.getName() + "quests.actual");
			return actualQuestName;
		}
		else {
			return null;
		}
	}
	
	public List<String> getActivePlayerQuests(SpoutPlayer sp)
	{
		if(sp != null && plugin.getCustomConfig().getString("players." + sp.getName() + ".quests.active") != null && plugin.checkSpout(sp))
		{
			return plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.active");
		}
		else {
			return null;
		}
	}
	public List<String> getActivePlayerQuests(Player p)
	{
		if(p != null && plugin.getCustomConfig().getString("players." + p.getName() + ".quests.active") != null && plugin.checkSpout(p))
		{
			return plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.active");
		}
		else {
			return null;
		}
	}
	
	public List<String> getCompletedPlayerQuests(SpoutPlayer sp)
	{
		if(sp != null && plugin.getCustomConfig().getString("players." + sp.getName() + ".quests.completed") != null && plugin.checkSpout(sp))
		{
			return plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.completed");
		}
		else {
			return null;
		}
	}
	public List<String> getCompletedPlayerQuests(Player p)
	{
		if(p != null && plugin.getCustomConfig().getString("players." + p.getName() + ".quests.completed") != null && plugin.checkSpout(p))
		{
			return plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.completed");
		}
		else {
			return null;
		}
	}
	
	public List<String> getInactivePlayerQuests(SpoutPlayer sp)
	{
		if(sp != null && plugin.getCustomConfig().getString("players." + sp.getName() + ".quests.inactive") != null && plugin.checkSpout(sp))
		{
			return plugin.getCustomConfig().getStringList("players." + sp.getName() + ".quests.inactive");
		}
		else {
			return null;
		}
	}
	public List<String> getInactivePlayerQuests(Player p)
	{
		if(p != null && plugin.getCustomConfig().getString("players." + p.getName() + ".quests.inactive") != null && plugin.checkSpout(p))
		{
			return plugin.getCustomConfig().getStringList("players." + p.getName() + ".quests.inactive");
		}
		else {
			return null;
		}
	}

	public String getQuestText(String quest) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Integer> getAllQuestIDs() {
		if(fileExists())
			return getCustomConfig().getIntegerList("quests.allIDs");
		return null;
	}

}
