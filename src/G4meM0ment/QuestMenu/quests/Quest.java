package G4meM0ment.QuestMenu.quests;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import G4meM0ment.QuestMenu.QuestMenu;

public class Quest{
	
	private String questID;
	
	private QuestManager qm;
	private QuestMenu plugin;
	
	
	public Quest(String questID) {
		this.questID = questID;
		this.plugin = (QuestMenu) Bukkit.getServer().getPluginManager().getPlugin("QuestMenu");
		this.qm = plugin.qm;
	}
	
	public String getQuestID(Quest quest) {
		if(quest != null)
			return questID;
		else
			return null;
	}
	
	public String getState(Quest quest, Player player) {
		if(quest != null)
			return 	qm.getCustomConfig().getString("players." + player.getName() + "quests." + getQuestID(quest) + ".state");
		else
			return "FAILED";
	}

}
