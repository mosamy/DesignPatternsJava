

public class TransmissionState implements ITransmissionState {

	private int myspeed = 0;
	
	public TransmissionState(int speed) {
		myspeed = speed;
	}
	@Override
	public int changegear(int speed) {
		myspeed = speed;
		return gear();
	}
	
	private  boolean isBetween(int x, int lower, int upper) {
		  return lower <= x && x < upper;
	}
	@Override
	public int gear() {
		
		
	if  (isBetween(myspeed, 0, 10)){ 
		return 1;}
	
   
	if  (isBetween(myspeed, 10, 20)){  
		return 2;}
	
	if  (isBetween(myspeed, 20, 30))
	{
		return 3;}
	

    
	if  (isBetween(myspeed, 30, 40)){  
		return 4;}
	
   
    
	if  (isBetween(myspeed, 40, 50)){  
		return 5;}
	
	if  (isBetween(myspeed, 50, 70)){  
		return 6;}
		
	return 0;
	
	}

}
