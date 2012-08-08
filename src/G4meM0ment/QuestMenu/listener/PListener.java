package G4meM0ment.QuestMenu.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import G4meM0ment.QuestMenu.QuestMenu;

public class PListener implements Listener {
	
	private QuestMenu plugin;
	
	public PListener(QuestMenu plugin) {
	    this.plugin = plugin;
	}

	@EventHandler(ignoreCancelled = true)
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();		
		plugin.newPlayer(player);
	}

}
