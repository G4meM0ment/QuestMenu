package G4meM0ment.QuestMenu.GUI;

import org.bukkit.ChatColor;
import org.getspout.spoutapi.gui.GenericButton;
import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.gui.InGameHUD;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.QuestMenu;
import G4meM0ment.QuestMenu.quests.QuestManager;

public class GUI extends GenericPopup{
	
	QuestMenu plugin;
	private QuestManager qm;
	private GUIManager gm;
	
	public GUI(QuestMenu plugin, QuestManager qm, GUIManager gm) {
		this.plugin = plugin;
		this.qm = qm;
		this.gm = gm;
	}
	
	public void createIngameHUD(final SpoutPlayer sp) {
		IngameHUD(sp);		
	}
	
	public void popupIngameHUD(final SpoutPlayer sp) {
        InGameHUD inGameHud = sp.getMainScreen();
        inGameHud.attachPopupScreen(this);
        inGameHud.setDirty(true);		
	}
	
	public void setButton(GenericButton button, SpoutPlayer sp) {
		if(button.equals(exit))
			gm.closePopup(sp);
		if(button.equals(tab1))
			gm.switchActive(sp);
	}
	
	public GenericButton getButton(GenericButton button) {
		if(button.equals(exit))
			return exit;
		if(button.equals(tab1))
			return tab1;
		if(button.equals(tab2))
			return tab2;
		if(button.equals(tab3))
			return tab3;
		return null;
	}
	
	public GenericLabel getLabel(GenericLabel label) {
		if(label.equals(titleLabel))
			return titleLabel;
		return null;
	}
	
    private GenericButton tab1, tab2, tab3, exit;
    private GenericLabel titleLabel = new GenericLabel();
    //private GenericLabel questInfo = new GenericLabel();

	private void IngameHUD(final SpoutPlayer sp) {
		
		titleLabel.setText(ChatColor.GREEN + "~Quests~");
		titleLabel.setHeight(20);
		titleLabel.setWidth(142);
		titleLabel.setX(242);
		titleLabel.setY(5);
		
		/*questInfo.setText(plugin.getCustomConfig().getString("players." + sp.getName() + ".quests." + quests.getShowedPlayerQuest(sp)));
		questInfo.setHeight(300);
		questInfo.setWidth(300);
		questInfo.setX(100);
		questInfo.setY(40);*/
		
		tab1 = new GenericButton("Active Quests");
		tab1.setHeight(20);
		tab1.setWidth(142);
		tab1.setX(0);
		tab1.setY(20);
		
		tab2 = new GenericButton("Completed Quests");
		tab2.setHeight(20);
		tab2.setWidth(142);
		tab2.setX(142);
		tab2.setY(20);
		
		tab3 = new GenericButton("Inactive Quests");
		tab3.setHeight(20);
		tab3.setWidth(142);
		tab3.setX(286);
		tab3.setY(20);
		

		
		exit = new GenericButton("X");
		exit.setHeight(20);
		exit.setWidth(20);
		exit.setX(407);
		exit.setY(0);
		
		attachWidget(plugin, titleLabel);
		attachWidget(plugin, tab1);
		attachWidget(plugin, tab2);
		attachWidget(plugin, tab3);
		attachWidget(plugin, exit);
	}
}
