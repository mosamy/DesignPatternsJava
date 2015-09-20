
public class Main {

	public static void main(String[] args) {
		Thing t = new Thing("thing");
		Functor proxyFunctor = new Functor() {
			
		

			@Override
			public void apply(String message) {
				System.out.println(message);
				
			}
		};
		
		pThing p = new pThing(t, proxyFunctor);
		p.compute();
	}
	

}
