import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class IterationExcerciseMain {
	
	
	
	public static void main (String [] args)
	{
		MyVector numbers = new MyVector();
		
		int sum = 0;
		int count = 0;
		double average= 0.0;
		Predicate<Integer> selectGreaterthan2 = x -> x >2 ;
		//selectPredicate x >2, x > 6 , x <8
		Predicate<Integer> selectGreaterthan6 = x -> x >6 ;
		Predicate<Integer> selectLessthan8 = x -> x <8 ;
		Iterator<Integer> javaIT;
		for (int x = 1; x <10; x++)
		{
			numbers.addElement(x);
		}	
		
		
		
		
		
		//External sum/Average complete
		 javaIT = numbers.iterator();
		sum =0;
		count = 0;
		while (javaIT.hasNext()) {
			count++;
			sum += javaIT.next();
			
		}
		
		
		 average = sum/count;
		 System.out.println("external iterable complete");
		System.out.println("The average is " + average + "");
		System.out.println("The sum is " + sum + "");
		
		SumFunctor sumFunctor = new SumFunctor();
		//print sum  complete internal
		System.out.println("Sum complete internal");
		numbers.doAll(sumFunctor);
		
		System.out.println("Average complete internal");
		AverageFunctor averageFunctor = new AverageFunctor();
		//Print average complete  internal
		numbers.doAll(averageFunctor);
		
		// External sum and average SelectiveselectPredicate
		//return an iterator
		System.out.println("external selective x > 2");
		Iterator<Integer> selectiveiterator = numbers.getSelectiveIterator(selectGreaterthan2);
		sum =0;
		count = 0;
		while (selectiveiterator.hasNext())
		{
			count++;
			sum += selectiveiterator.next();
		}
		 	average = sum/count;
			System.out.println("The average is " + average + "");
			System.out.println("The sum is " + sum + "");
		
			
		//internal selective
			//selectPredicate x >2, x > 6 , x <8
			System.out.println("x > 2 ");
			averageFunctor = new AverageFunctor();
			sumFunctor = new SumFunctor();
		numbers.doAll(averageFunctor, selectGreaterthan2);
		numbers.doAll(sumFunctor, selectGreaterthan2);
		System.out.println("x > 6 ");
		averageFunctor = new AverageFunctor();
		sumFunctor = new SumFunctor();
		numbers.doAll(averageFunctor, selectGreaterthan6);
		numbers.doAll(sumFunctor, selectGreaterthan6);
		System.out.println("x < 8 ");
		averageFunctor = new AverageFunctor();
		sumFunctor = new SumFunctor();
		numbers.doAll(averageFunctor, selectLessthan8);
		numbers.doAll(sumFunctor, selectLessthan8);
		
		
	/*	// External selective / iterable
		
		A
		Iterable<Integer> extIterable = numbers.getIterable(selectGreaterthan2); // will probably return a collection
		javaIT = extIterable.iterator();
		sum =0;
		count = 0;
		while (javaIT.hasNext()) {
			count++;
			sum += javaIT.next();
			
		}
		
		 average = sum/count;
		System.out.println("The average is " + average + "");
		System.out.println("The sum is " + sum + "");*/
		
		
		List<Integer> numbersgreaterthan2 = numbers.stream().filter(x -> x >2).collect(Collectors.toList());
		
		//iterate external
		Iterator<Integer> extIT = numbersgreaterthan2.iterator();
		sum =0;
		count = 0;
		while (extIT.hasNext()) {
			count++;
			sum += extIT.next();
			
		}
		
		 average = sum/count;
		System.out.println("x > 2");
		System.out.println("The average is " + average + "");
		System.out.println("The sum is " + sum + "");

		List<Integer> numbersgreaterthan6 = numbers.stream().filter(x -> x >2).collect(Collectors.toList());
		
		//iterate external
		Iterator<Integer> extIT1 = numbersgreaterthan6.iterator();
		sum =0;
		count = 0;
		while (extIT1.hasNext()) {
			count++;
			sum += extIT1.next();
			
		}
		
		 average = sum/count;
		System.out.println("x > 6");
		System.out.println("The average is " + average + "");
		System.out.println("The sum is " + sum + "");
		
		
		List<Integer> numberslessthan8 = numbers.stream().filter(x -> x <8).collect(Collectors.toList());
		//iterate external
				Iterator<Integer> extIT3 = numberslessthan8.iterator();
				sum =0;
				count = 0;
				while (extIT3.hasNext()) {
					count++;
					sum += extIT3.next();
					
				}
				
				 average = sum/count;
				System.out.println("x < 8");
				System.out.println("The average is " + average + "");
				System.out.println("The sum is " + sum + "");
		
	}

}
