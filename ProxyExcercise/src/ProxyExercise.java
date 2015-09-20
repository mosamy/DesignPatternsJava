
public class ProxyExercise {
	
	public static void main (String[] args)
	{
		Thing t = new aThing("A");
		t.compute("Hello");
		
		
		t = new LogProxy(t);
		t.compute("Hello");
		
		
		
		
	}

}
