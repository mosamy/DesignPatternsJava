
import java.util.ArrayList;


public class Counter implements ISubject // this is the subject
{
  
    private int count;
	private ArrayList<IObserver> list ;

    public Counter (){
       list = new ArrayList<>();
        count = 0;
    }
    
    public void increment(){
        count++;
       publish();
    }
    
    public void decrement(){
        if (count >0){
            count--;
            publish();
        }
        
       
    }

	
    @Override
	public void publish() {
		//notify subscribers by looping
		
    	for (IObserver jFrame : list) {
    		jFrame.update(count);
			
		}
	}

	@Override
	public void attach(IObserver jf) {
		
		list.add(jf);
		
	}

	@Override
	public void detach(IObserver jf) {
		
		list.remove(jf);
		
	}

	

    

}