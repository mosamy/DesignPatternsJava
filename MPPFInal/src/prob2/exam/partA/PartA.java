package prob2.exam.partA;

import java.util.function.Supplier;



//The lambda:   () -> Math.random()
public class PartA {
	//provide a functional interface type for the lambda
	Supplier<Double> randomDouble ;
	//= () -> Math.random()
	
	//provide a method reference and the type of method reference
	//TYPE: cl::meth
	
	
	// provide an inner class that behaves the same way as the labmda
	class MyClass implements Supplier<Double> 
	{

		@Override
		public Double get() {
			
			return Math.random();
		} 
		
	}
	
	
	public void evaluator() {
		//implement the lambda, the method reference, and the inner class operation
		Supplier<Double> randomDouble = () -> Math.random();
		System.out.println(randomDouble.get());
		Supplier<Double> f = randomDouble::get;
		System.out.println(String.valueOf(f.get()));
		MyClass rdoublecls = new MyClass();
		System.out.println(rdoublecls.get());
	}
	
	public static void main(String[] args) {
		PartA pa = new PartA();
		pa.evaluator();
	}
}
