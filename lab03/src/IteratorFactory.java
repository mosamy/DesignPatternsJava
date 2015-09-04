import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.util.function.Predicate;

public class IteratorFactory {

	private class ReverseIterator implements Iterator<Swimmer>
	{
		private Vector<Swimmer> slist;
		private int currentcounter = 0;
		private ReverseIterator(Vector<Swimmer> list)
		{
			this.slist = list;
			
			this.currentcounter = this.slist.size();
		}

		@Override
		public boolean hasNext() {
			if (currentcounter >=0)
			{
				
			return true;
			}
			return false;
		}

		@Override
		public Swimmer next() {
			currentcounter --;
			if (hasNext())
			{
				return slist.elementAt(currentcounter);
			}
			return null;
		}
		
		
	}
	
	
	private class Above12Iterator implements Iterator<Swimmer>
	{

		private Vector<Swimmer> slist;
		private int currentcounter = 0;
		private Above12Iterator(Vector<Swimmer> list)
		{
			
			this.slist = list;
			this.slist.removeIf(a -> a.getAge() <12);
			//this.currentcounter = this.slist.size();
		}

		@Override
		public boolean hasNext() {
			if (currentcounter < slist.size())
			{
				
			return true;
			}
			return false;
		}

		@Override
		public Swimmer next() {
			currentcounter ++;
			if (hasNext() )
			{
				return slist.elementAt(currentcounter);
			}
			
			return null;
		}
		
	}
	
	
	private class FunctorIterator implements Iterator<Swimmer>
	{
		private Vector<Swimmer> list;
		private int currentcounter = 0;
		private FunctorIterator(Vector<Swimmer> slist, Predicate<Swimmer> p)
		{
			this.list = slist;
			this.list.removeIf(p);
		}
		@Override
		public boolean hasNext() {
			if (currentcounter < list.size())
			{
				
			return true;
			}
			return false;
		}

		@Override
		public Swimmer next() {
			currentcounter ++;
			if (hasNext() )
			{
				return list.elementAt(currentcounter);
			}
			
			return null;
		}
		
	}
	public   Iterator<Swimmer> getIterator (Vector<Swimmer> slist, StyleType st)
	{
		if ( st == StyleType.Reverse)
		{
			return new ReverseIterator(slist);
		}
		
		if ( st == StyleType.Above12)
		{
			return new Above12Iterator(slist);
		}
		
		
		return null;
	}
	
	public Iterator<Swimmer> getIterator(Vector<Swimmer> slist, StyleType st, Predicate<Swimmer> p)
	{
		if ( st == StyleType.FunctorAbove12)
		{
			return new FunctorIterator(slist,p);
		}
	return null;	
		
	}
}
