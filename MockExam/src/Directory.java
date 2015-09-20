import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Directory extends FileSystemElement {

	private ArrayList<FileSystemElement> contains;
	
	public Directory( String name, String size, String date)
	{
		this.setDate(date);
		this.setName(name);
		this.setType("dir");
		this.setSize(size);
		
	}
	
    public void Add(FileSystemElement fse)
    {
    	contains.add(fse);
    }
    
    public void Delete(FileSystemElement fse)
    {
    	int index = contains.indexOf(fse);
    	if (index != -1)
    	{
    		contains.remove(index);
    	}
    	
    	
    	
    }

    public Boolean find(String name)
    {
    	return contains.stream().anyMatch(c -> c.getName() == name);
    }
    
    
	public  ArrayList<FileSystemElement> find(Predicate<FileSystemElement> f)
    {
    	return (ArrayList<FileSystemElement>) contains.stream().filter(f).collect(Collectors.toList());
    }
}
