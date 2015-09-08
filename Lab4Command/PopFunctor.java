

public class PopFunctor implements ICommand{

	private VStack vstack;
	public  PopFunctor(VStack v) {
		
	}
	@Override
	public void execute() {
		vstack.pop();
	}

}
