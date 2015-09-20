
public class Pixel implements ImageComponent  {

	private int colour = 0;
	private int size =1;
	
	public  Pixel(int newcolour) {
		colour = newcolour;
	}
	@Override
	public int getColour() {
		// TODO Auto-generated method stub
		return colour;
	}

	@Override
	public void setColour(int newcolour) {
		colour = newcolour;
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void setSize(int newsize) {
		size = newsize;
		
	}
	
	public void Print()
	{
		System.out.println(colour);
	}

}
