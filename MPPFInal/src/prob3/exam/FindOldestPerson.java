package prob3.exam;

import java.util.List;

//DO NOT MODIFY METHOD SIGNATURE OR STATIC QUALIFIER
public class FindOldestPerson {
	public static Person findOldestPerson(List<Person> persons) {
		
		//Function<Person, Person>
	   //Person  old = persons.stream().max((x,y) -> x.getAge()).get();
		// this one works
		//int Age =persons.stream().map(p -> p.getAge()).reduce((a,b) ->(Integer.max(a, b))).get();
		
		// this one works by returning an object, 
		//but the fail result is an empty cbject and cannpt be null
		return persons.stream().reduce(new Person("", 0), (x,y) ->  (x.getAge() > y.getAge()) ? x : y );
		//return persons.stream().filter(x -> x.getAge() == Age).findFirst().get();
			
		
				                        
	}
	
	
}
