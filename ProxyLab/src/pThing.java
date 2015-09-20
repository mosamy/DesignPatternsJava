

public class pThing <T>  {

	private Thing<T> thing;
	private Functor prepost;
	public pThing(Thing<T> t, Functor f)
	{
		thing = t;
		prepost = f;
	}
	
	public void compute()
	{
		pre_action("pre-action");
		thing.compute();
		post_action("post-action");
	}
	
	
	
	private void pre_action(String s)
	{
		prepost.apply(s);
	}
	
	private void post_action(String s)
	{
		
		prepost.apply(s);
		
	}
}
