

public class PushCommand implements ICommand{


	private int inttoPush =0 ;
	private VStack vstack;
	
	public PushCommand(VStack v, int x) {
		inttoPush = x;
		vstack = v;
		
	}
	@Override
	public void execute() {
		vstack.push(inttoPush);
		
	}

	

	
	

	
}
