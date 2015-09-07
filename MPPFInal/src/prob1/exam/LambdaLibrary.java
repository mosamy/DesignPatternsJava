package prob1.exam;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LambdaLibrary {
	//Query A (for Problem 1A) given a member's checkout record, determine whether some
		//bookcopy in the record is overdue (a bookcopy is overdue if it is not available
		//and its due date is before now.
		public static final  Function<CheckoutRecord, Boolean> isOverDue =
				(c) -> c.getCheckoutEntries().stream()
				.filter(ce -> ce.getDueDate().isAfter(LocalDate.now()) ).count() > 0;
	
	
		
		//Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
		//return true if mem has ever checked out this copy
		//
		public static final BiFunction<BookCopy, LibraryMember, Boolean> hasEverCheckedOut =
				(bc,lm) -> lm.getRecord().getCheckoutEntries().stream().filter(ce -> ce.getCopy().getCopyNumber() == bc.getCopyNumber()).count() >0;
	
	
	
		
		//Query C (for Problem 1C) given a list of all library members, return a list, in
		//reverse sorted order (by first name), of the
		//full names (first name + <space> + last name) of those library members 
	     //who have never checked out a book
		
}
