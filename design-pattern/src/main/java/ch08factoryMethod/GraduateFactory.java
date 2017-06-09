package ch08factoryMethod;

public class GraduateFactory  implements Factory{

	public LeiFeng createLeiFeng() {
		return new Graduate();
	}

 

}
