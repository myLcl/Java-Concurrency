package ch14observe;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
	public List<Observer> list = new ArrayList<Observer>();
	
	//添加
	public void attach(Observer o) {
		list.add(o);
	}
	
	//减少
	public void detach(Observer o) {
		list.remove(o);
	}
	
	//通知
	public void notice() {
		for (Observer o : list) {
			o.update();
		}

	}
}
