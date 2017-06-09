package ch18Memento;

public class MementoMain {
	public static void main(String[] args) {
		
		//大战boss前
		GameRole role = new GameRole(1);
		role.displayState();
		
		//备份
		RoleStateCaretaker caretaker = new RoleStateCaretaker();
		caretaker.setMementor(role.saveState());
		
		//大战boss
		role.fight();
		role.displayState();
		
		//恢复
		GameRole role1 = new GameRole(caretaker.getMementor().getVit());
		role1.displayState();
		
	}
}
