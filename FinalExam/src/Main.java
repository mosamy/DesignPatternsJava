
public class Main {

	public static void main(String[] args) {
		Block<Pixel> B1 = new Block<Pixel>(new Pixel(255), new Pixel(255), new Pixel(255), new Pixel(255));
		Block<Pixel> B2 = new Block<Pixel>(new Pixel(255), new Pixel(255), new Pixel(255), new Pixel(0));
		Block<Pixel> B3 = new Block<Pixel>(new Pixel(255), new Pixel(0), new Pixel(0), new Pixel(0));
		Block<Pixel> B4 = new Block<Pixel>(new Pixel(0), new Pixel(0), new Pixel(0), new Pixel(0));
		
		Block<Block> Qtree = new Block<Block>(B1, B2, B3, B4);
		//Block QTree = new Block<Block>(new Block<Block>(n, b2, b3, b4), b2, b3, b4)
		
		Qtree.Print();
	}

}
