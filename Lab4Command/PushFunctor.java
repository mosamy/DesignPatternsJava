

public class PushFunctor implements IFunctor{

	

	@Override
	public void execute(VStack v, int val) {
		v.push(val);
		
	}

	

	
}
