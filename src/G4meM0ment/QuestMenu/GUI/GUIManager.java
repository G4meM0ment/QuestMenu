package G4meM0ment.QuestMenu.GUI;

import org.getspout.spoutapi.gui.GenericLabel;
import org.getspout.spoutapi.gui.GenericPopup;
import org.getspout.spoutapi.player.SpoutPlayer;

import G4meM0ment.QuestMenu.QuestMenu;
import G4meM0ment.QuestMenu.quests.QuestManager;

public class GUIManager extends GenericPopup {

	private QuestMenu plugin;
	private QuestManager qm;
	
	public GUIManager(QuestMenu plugin, QuestManager qm) {
		this.plugin = plugin;
		this.qm = qm;
	}
	
	
	public void closePopup(SpoutPlayer sp) {
		if(sp.getMainScreen().isDirty()) {
			sp.getMainScreen().closePopup();
			sp.getMainScreen().setDirty(false);
		}
	}
	
	public void switchActive(SpoutPlayer sp) {
		if(sp.getMainScreen().isDirty()) {
			sp.getMainScreen().closePopup();
			sp.getMainScreen().setDirty(false);
		}
	}
	
	public void switchInactive(SpoutPlayer sp) {
		if(sp.getMainScreen().isDirty()) {
			sp.getMainScreen().closePopup();
			sp.getMainScreen().setDirty(false);
		}
	}
	
	public void switchCompleted(SpoutPlayer sp) {
		if(sp.getMainScreen().isDirty()) {
			sp.getMainScreen().closePopup();
			sp.getMainScreen().setDirty(false);
		}
	}
	
	public void setQuestText(SpoutPlayer sp, GenericLabel label) {
		String quest = qm.getActualPlayerQuest(sp);
		String questText = qm.getQuestText(quest);
		label.setText(questText);
	}
}
