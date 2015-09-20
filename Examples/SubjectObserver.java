/*
 *  Typed (Generic) Obesrver...
 */
package myObserver;

import java.util.*;

/* Scala is a newish programming language from Martic Odersky, 
 *  who also wrote Pizza -> GJ -> Java 5. In the paper Odersky
 *  wrote about Scala, http://scala.epfl.ch/docu/files/ScalaOverview.pdf, 
 *  he gives a couple of examples of this same construct and how two type
 *  extensions in Scala generics help.
 *   
 *   http://www.artima.com/forums/flat.jsp?forum=106&thread=135896
 *   
 *   ---------------
 *  The second example given in the paper and coded in Java is: (below)
 *   This is a nice variation on the same theme
 *    where mutually recursive generic definitions are used.
 */

// -------------------------------------------------------------
abstract class Subject< S extends Subject<  S, O >,
                        O extends Observer< S, O > > {
	private final List< O > observers = new ArrayList< O >();
	void subscribe( O obs ) { observers.add( obs ); }
	void publish() {
		for ( final O obs : observers )
			// Type safety: Unchecked cast from Subject<S,O> to S ??
			obs.notify( (S)this );
	}
}
//-------------------------------------------------------------
abstract class Observer< S extends Subject<  S, O >,
                         O extends Observer< S, O > > {
	abstract void notify( S sub );
}
//-------------------------------------------------------------
class Sensor extends Subject< Sensor, Display > {
	double value = 0.0;
	String name  = "";
	Sensor(String nm) { name = nm; }
	
	void changeValue( final double v ) {
		value = v;
		publish();
	}
	public String toString() { return "Sensor:" + name; }
}

class Display extends Observer< Sensor, Display > {
	void notify( Sensor sub ) {  // Note typed argument!
		System.out.println( sub  + " has value " + sub.value );
	}
}
//-------------------------------------------------------------
public class SubjectObserver {
	public static void main( final String[] notUsed ) {
		final Display o = new Display();
		final Sensor  s = new Sensor("Temperature");
		s.subscribe( o );
		s.changeValue( 1 );
	}
}
