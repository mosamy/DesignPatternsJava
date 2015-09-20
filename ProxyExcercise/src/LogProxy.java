
public class LogProxy implements Thing{

	private Thing pThing;
	public LogProxy(Thing t) {
		pThing  = t;
	}

	@Override
	public void compute(String s) {
		LogBefore();
		pThing.compute(s); //delegation
		LogAfter();
	}
	
	private void LogBefore()
	{
		System.out.println("Before");
	}
	
	private void LogAfter()
	{
		System.out.println("After");
	}

}
