

/**
 * 
 */

/**
 * @author mohamed
 *
 */
public interface ISubject 
{
	public void publish();
	public void attach (IObserver jf);

	public void detach (IObserver jf);
	
	
}
