
public class Thing<T> implements IThing {

	private T name;
	public Thing(T s)
	{
		name = s;
	}
	public void compute()
	{
		System.out.println(name.toString());
	}
}
