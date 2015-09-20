
public class Block<T extends ImageComponent> implements ImageComponent {

	private  T B1;
	private T B2;
	private T B3;
	private T B4;
	
	
	public Block(T b1, T b2, T b3, T b4)
	{
		setB1(b1);
	}
	
	@Override
	public int getColour() {
		int totalcolor = B1.getColour() + B2.getColour() + B3.getColour() + B4.getColour();
		return totalcolor/4;
	}

	@Override
	public void setColour(int colour) {
		
		
	}

	@Override
	public int getSize() {
		int totalsize = B1.getSize() + B2.getSize() + B3.getSize() + B4.getSize();
		return totalsize;
	}

	@Override
	public void setSize(int size) {
		// TODO Auto-generated method stub
		
	}

	public T getB1() {
		return B1;
	}

	public void setB1(T b1) {
		B1 = b1;
	}

	public T getB2() {
		return B2;
	}

	public void setB2(T b2) {
		B2 = b2;
	}

	public T getB3() {
		return B3;
	}

	public void setB3(T b3) {
		B3 = b3;
	}

	public T getB4() {
		return B4;
	}

	public void setB4(T b4) {
		B4 = b4;
	}
	
	public void Print()
	{
		System.out.println(B1.getColour());
	}
	
	

}
