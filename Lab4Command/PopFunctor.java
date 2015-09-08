

public class PopFunctor implements IFunctor{

	@Override
	public void execute(VStack v, int val) {
		v.pop();
	}

}
