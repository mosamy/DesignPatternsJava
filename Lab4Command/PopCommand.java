

public class PopCommand implements ICommand{

	private String strPopped = ""; 
	private VStack vstack;
	public  PopCommand(VStack v) {
		vstack = v;
	}
	@Override
	public void execute() {
		strPopped = (String) vstack.pop();
	}

	@Override
	public void undo()
	{
		vstack.push(strPopped);
	}
	@Override
	public void redo() {
		execute();
		
	}
}
