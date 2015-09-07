import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;


public class MyVector  extends Vector<Integer>
{

	
	public void doAll( IFunctor<Integer> Functor) {
		
		for (int x = 0; x < this.elementCount; x++)
		{
			Functor.compute(this.elementAt(x));
		}
		
		Functor.getValue();
	}

	public Iterator<Integer> getSelectiveIterator(Predicate<Integer> selectPredicate) {
		// TODO Auto-generated method stub
		Vector<Integer> v = new Vector<Integer>();
		for (int x = 0; x < this.size(); x++)
		{
			if (selectPredicate.test(this.elementAt(x)))
			{
				v.addElement(this.elementAt(x));
			}
		}
		
		return v.iterator();
	}

	public void doAll(IFunctor<Integer> Functor, Predicate<Integer> selectPredicate) {
		for (int x = 0; x < this.elementCount; x++)
		{
			if (selectPredicate.test(this.elementAt(x)))
			{
				Functor.compute(this.elementAt(x));
			}
		}
		
		Functor.getValue();
		
	}

	public Iterable<Integer> getIterable(Predicate<Integer> selectGreaterthan2) {
		// TODO Auto-generated method stub
		return null;
	}

}
