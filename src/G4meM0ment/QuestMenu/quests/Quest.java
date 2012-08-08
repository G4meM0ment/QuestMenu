package G4meM0ment.QuestMenu.quests;

public class Quest {
	
	private int id;
	
	private QuestManager qm;
	
	
	public Quest(int id, QuestManager qm) {
		this.id = id;
		this.qm = qm;
	}
	
	public String getQuestName(int id) {
		for(int questID : qm.getAllQuestIDs())
		{
			if(questID == id)
			{
				String questName = qm.getCustomConfig().getString("quests." + id + ".questName");
				return questName;
			}
		}
		return null;
	}

}
