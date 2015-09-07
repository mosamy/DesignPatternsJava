package prob2.exam.partB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import prob1.exam.LibraryMember;




//The lambda:   (CheckoutRecord record) -> record.getCheckoutEntries()
public class PartB {
	//provide a functional interface type for the lambda
	Function<CheckoutRecord, List<CheckoutRecordEntry>>  getCheckoutEntries;
	
	//provide a method reference and the type of method reference
	//TYPE: Object::InstanceMethod
	  
	
	// provide an inner class that behaves the same way as the lambda
	class MyGetCheckoutEntries implements Function<CheckoutRecord, List<CheckoutRecordEntry>>
	{

		@Override
		public List<CheckoutRecordEntry> apply(CheckoutRecord t) {
			
			return t.getCheckoutEntries();
		} 
		
	}

		
	
	public void evaluator() {
		//test your lambda, your method reference, and your inner class operation
		Function<CheckoutRecord, List<CheckoutRecordEntry>>  getCheckoutEntries =
				(cr -> cr.getCheckoutEntries());
		System.out.println(getCheckoutEntries.apply(record));
		Function<CheckoutRecord, List<CheckoutRecordEntry>> f = getCheckoutEntries::apply;
		System.out.println(f.apply(record));
		MyGetCheckoutEntries myCEE = new MyGetCheckoutEntries();
		System.out.println(myCEE.apply(record));
		
	}
	
	
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		List<Book> allBooks = new ArrayList<Book>() {
			{
				add(new Book("28-12331", "Antartica", 2, 7));
				add(new Book("99-22223", "Thinking Java", 1, 21));
				add(new Book("48-56882", "Jimmy's First Day of School", 1, 7));
				
			}
		};
	
		List<CheckoutRecordEntry> allEntries = new ArrayList<CheckoutRecordEntry>() {
			{
				add(new CheckoutRecordEntry(
					allBooks.get(0).getCopies().get(0), LocalDate.of(2011,12,1), LocalDate.of(2011,12,22)));
				add(new CheckoutRecordEntry(
					allBooks.get(0).getCopies().get(1), LocalDate.of(2014,6,22), LocalDate.of(2014,7,13)));
				add(new CheckoutRecordEntry(
						allBooks.get(1).getCopies().get(0), LocalDate.of(2015,12,2), LocalDate.of(2015,12,23)));
				add(new CheckoutRecordEntry(
						allBooks.get(2).getCopies().get(0), LocalDate.of(2015,6,24), LocalDate.of(2015,7,15)));
			}
		};
		record = new CheckoutRecord();
		record.addEntry(allEntries.get(0));
		record.addEntry(allEntries.get(1));
		record.addEntry(allEntries.get(2));
		
		PartB pa = new PartB();
		pa.evaluator();
	}
	private static CheckoutRecord record;
}