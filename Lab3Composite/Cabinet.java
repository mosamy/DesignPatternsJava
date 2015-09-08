import java.util.*;

public class Cabinet implements IContainer  {
  private Board board;
  private Vector<IComponent> list = new Vector();
  public void setBoard (Board b){
    board=b;
  }
  public void addDrive (Drive d){
   // drivelist.addElement(d);
	  this.AddComponent(d);
	  
  }
  public double netPrice()      {return 6.00;}
  public double discountPrice() {return 3.00;}
  
  public double computePrice(){
    double tmp=netPrice();
    if (board!= null)
       tmp+=board.computePrice();
    for (IComponent drive  : list)
        tmp+=drive.computePrice();
    return tmp;  
  }
@Override
public void AddComponent(IComponent c) {
	// TODO Auto-generated method stub
	
}
}
