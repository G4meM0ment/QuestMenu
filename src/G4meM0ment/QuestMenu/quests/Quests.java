package G4meM0ment.QuestMenu.quests;

import java.util.List;

import org.bukkit.entity.Player;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.QuestMenu;

public class Quests {
	
	QuestMenu plugin;
	
	public Quests(QuestMenu plugin)
	{
		this.plugin = plugin;
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
	

}
