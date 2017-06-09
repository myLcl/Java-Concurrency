package ch14observe;

public class ConcreteObserver extends Observer{
	private String name;
	private String observerState;
	private ConcreteSubject subject;
	
	public ConcreteObserver(ConcreteSubject subject, String name) {
		this.name = name;
		this.subject = subject;
	}

	@Override
	public void update() {
		observerState = subject.subjectState;
		System.out.println("通知者信息: " +observerState);
		System.out.println("观察者状态: " + name);
	}

	public ConcreteSubject getSubject() {
		return subject;
	}

	public void setSubject(ConcreteSubject subject) {
		this.subject = subject;
	}
		
	
}
