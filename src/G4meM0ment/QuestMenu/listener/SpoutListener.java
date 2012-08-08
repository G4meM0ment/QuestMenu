package G4meM0ment.QuestMenu.listener;
 
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.getspout.spoutapi.event.input.KeyPressedEvent;
import org.getspout.spoutapi.event.screen.ButtonClickEvent;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.keyboard.Keyboard;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.QuestMenu;
import G4meM0ment.QuestMenu.GUI.GUI;
 
public class SpoutListener implements Listener {
    
	QuestMenu plugin;
	private GUI gui;
   
    public SpoutListener(QuestMenu plugin, GUI gui)
    {
        this.plugin = plugin;
        this.gui = gui;
    }
   
    @EventHandler(ignoreCancelled = true)
    public void onKeyPressed(KeyPressedEvent event)
    {
        SpoutPlayer sp = event.getPlayer();
        if(!plugin.checkSpout(sp)) return;
        
        Keyboard key = Keyboard.KEY_J;
        if(event.getKey() == key)
        {
        	gui.createIngameHUD(sp);
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onButtonClick(ButtonClickEvent event)
    {
        SpoutPlayer sp = event.getPlayer();
        if(!plugin.checkSpout(sp)) return;
        
        GenericButton button = (GenericButton) event.getButton();
        gui.setButton(button, sp);
    }
}
