package ch06decorator;

/**
 * @author lcl
 */
public class Hat extends Finery {

  @Override
  public void show(){
    System.out.println(" red hat ");
    super.show();
  }
}
