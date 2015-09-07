package prob1.exam;
import java.util.ArrayList;
import java.util.List;
public class Main { //Do 2 out of 3

	
	//Query A (for Problem 1A) given a member's checkout record, determine whether some
	//bookcopy in the record is overdue (a bookcopy is overdue if it is not available
	//and its due date is before now.
	public static boolean someBookOverdue(CheckoutRecord record) {
          
		return LambdaLibrary.isOverDue.apply(record); //implement
	
	}
	
	//Query B (for Problem 1B) Given a BookCopy copy and a LibraryMember mem,
	//return true if mem has ever checked out this copy
	//
	public static boolean everCheckedOutBy(LibraryMember mem, BookCopy copy) {
		//LambdaLibrary.hasEverCheckedOut()
		return LambdaLibrary.hasEverCheckedOut.apply(copy, mem); //implement
          
	}
	
	//Query C (for Problem 1C) given a list of all library members, return a list, in
	//reverse sorted order (by first name), of the
	//full names of those library members who have never checked out a book
	public static List<String> nonActiveMembers(List<LibraryMember> list) {
		return new ArrayList<String>();
	}
	
	
	

}
