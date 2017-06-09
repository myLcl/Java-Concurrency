package ch25mediator;

public class MediatorMain {

	public static void main(String[] args) {
		UnitedNationsSecurityCouncil  unsc = new UnitedNationsSecurityCouncil();
		USA u = new USA(unsc);
		Irag irag = new Irag(unsc);
		
		unsc.setColleague1(u);
		unsc.setColleague2(irag);
		
		u.declare("研制核武器,就发动进攻");
		irag.declare("没有核武器");
	}

}
