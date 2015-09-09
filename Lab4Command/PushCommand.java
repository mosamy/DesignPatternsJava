import java.awt.event.ActionEvent;

public class PushCommand implements ICommand, IPushString{


	private String strtoPush = "" ;
	private VStack vstack;
	

	
	public PushCommand(VStack v) {
		
		vstack = v;
		
	}
	@Override
	public void execute() {
		strtoPush="";
		    PushDialog  dialog = new PushDialog(this); //ask the user what to push
		    dialog.setVisible(true);
		    if (!strtoPush.equals("")) // after the dialog is closed, 
			   //stack.push(pushstring);  // pushstring contains the user input
		    {
		    	
		    	vstack.push(strtoPush);
				
		    }
		
	}
	@Override
	public void setPushString(String value) {
		strtoPush = value;
		
	}
	
	public void undo()
	{
		vstack.pop();
	}
	@Override
	public void redo() {
		vstack.push(strtoPush);
		
	}

	
	

	
	

	
}
