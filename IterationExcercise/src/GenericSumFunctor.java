

public class GenericSumFunctor<T extends Number>  implements IFunctor<T> {

	double sum;
	@Override
	public void compute(T  element) {
		
		sum  += element.doubleValue();
		
	}

	@Override
	public T getValue() {
		// TODO Auto-generated method stub
		return null;
		//return sum;
	}
	
}




	

