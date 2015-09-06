
public class AverageFunctor implements IFunctor<Integer>
{

	//private int average =0; 
	private int count= 0;
	private int sum =0;
	
	@Override
	public void compute(Integer element) {
		count++;
		sum+=element;
	}

	@Override
	public Integer getValue() {
		// TODO Auto-generated method stub
		double average = sum/count;
		System.out.println("Average is " + average + "" );
		return sum/count;
	}
	
}
