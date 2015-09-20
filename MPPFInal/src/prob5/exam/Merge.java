package prob5.exam;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class Merge {

	/* For testing your implementation */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(2, 4, 6);
		List<Integer> list2 = Arrays.asList(3, 5, 6, 7);
		List<String> list3 = Arrays.asList("Alice", "Tom");
		List<String> list4 = Arrays.asList("Bob", "Richard");
		List<Double> list5 = Arrays.asList(2.3, 4.5);
		List<Number> list6 = Arrays.asList(2, 5);
		List<String> list7 = Arrays.asList("A", "XYZ", "AXTU");
		Merge m = new Merge();
		
		List<Number> listprint = m.MergeListGeneric(list6, list6);
		//ist<Number> listprint2 = m.MergeListGeneric(list6, list5);
	}
	
	public List<Integer> MergeList(List<Integer> L1, List<Integer> L2)
	{
		@SuppressWarnings("rawtypes")
		Stream merge = Stream.concat(L1.stream(), L2.stream()) ;
		Function<Integer, Integer> sortByValue = x -> x.intValue();
		Stream<Integer> mergedstream = merge.sorted(Comparator.comparing(sortByValue));
		return mergedstream.collect(Collectors.toList());
	}
	
	public  <T extends Number> List<T> MergeListGeneric(List<T> L1, List<T> L2)
	{
		@SuppressWarnings("rawtypes")
		Stream<T> merge = Stream.concat(L1.stream(), L2.stream()) ;
		//Function<?, ?> sortByValue = x -> x.hashCode();
		//Stream<Object> mergedstream = merge.sorted(Comparator.comparing(sortByValue));
		return merge.collect(Collectors.toList());
		//return merge.collect(Collectors.toList());
	}

}
