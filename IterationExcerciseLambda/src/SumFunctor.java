

public class SumFunctor implements IFunctor<Integer>{

	private int sum = 0;
	@Override
	public void compute(Integer element) {
		sum+=element;
		
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		System.out.println("The sum is " + sum + "");
		return sum;
	}

	

}
