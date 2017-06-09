package ch14observe;

public class ObserverMain {
	public static void main(String[] args) {
		ConcreteSubject subject = new ConcreteSubject();
		subject.attach(new ConcreteObserver(subject, "继续工作"));
		
		subject.subjectState = "老板来了";
		subject.notice();
	}
}
