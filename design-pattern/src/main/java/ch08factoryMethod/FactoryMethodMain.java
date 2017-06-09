package ch08factoryMethod;

public class FactoryMethodMain {

  public static void main(String[] args) {
    Factory factory = new GraduateFactory();
    Graduate student = (Graduate) factory.createLeiFeng();
    student.sweep();
    
    Factory VFactory = new VolunteerFactory();
    Volunteer volunteer = (Volunteer) VFactory.createLeiFeng();
    volunteer.sweep();
    
  }

}
