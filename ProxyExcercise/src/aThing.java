
public class aThing implements Thing {

	private String name;
	public aThing(String s) {
		name = s;
	}

	public void compute(String h) {
		
		System.out.println(h + " " + name );
	}

}
