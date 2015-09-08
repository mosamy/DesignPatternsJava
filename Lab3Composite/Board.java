import java.util.*;

public class Board implements IContainer {
  private Bus bus;
  private Vector<IComponent> list = new Vector();
  public void setBus (Bus b){
    bus=b;
  }
  public void addCard(Card d){
    //cardlist.addElement(d);
	  this.AddComponent(d);
  }
  public double netPrice()      {return 26.00;}
  public double discountPrice() {return  6.00;}
  
  public double computePrice(){
    double tmp=discountPrice();
    if (bus!= null)
       tmp+=bus.computePrice();
   
    for (IComponent comp : list)
       // Card card = (Card)cardlist.elementAt(x);
        tmp+=comp.computePrice();
    return tmp;
  }
@Override
public void AddComponent(IComponent c) {
	list.addElement(c);
	
}



}
