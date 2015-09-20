
public class FileSystemMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Directory root = new Directory("root", "100", "100");
		root.Add(new File("syllabus", "doc", "123", "101"));
		root.Add(new File("resume", "doc", "345", "124"));
		root.Add(new File("reading", "txt", "234", "202"));
		root.Add(new Directory("cs525", "2", "234"));
	}

}
