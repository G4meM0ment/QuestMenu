package G4meM0ment.QuestMenu.listener;

import java.util.List;

import net.citizensnpcs.api.event.NPCRightClickEvent;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import G4meM0ment.QuestMenu.QuestMenu;
import G4meM0ment.QuestMenu.quests.QuestManager;

public class CitizenListener implements Listener{
	
	private QuestMenu plugin;
	private QuestManager qm;
	
	public CitizenListener(QuestMenu plugin, QuestManager qm) {
		this.plugin = plugin;
		this.qm = qm;
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onNPCRightClick(NPCRightClickEvent event) 
	{
		int id = event.getNPC().getId();
		List<Integer> quests = qm.getCustomConfig().getIntegerList("npcs." + id + ".quests");
		if(quests != null)
			qm.getAvailableQuests(quests);
	}

}
