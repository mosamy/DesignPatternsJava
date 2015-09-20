import java.util.HashMap;

public class BatmanFactory {
	
	private HashMap<String, Protagonist> batcharachters;

	public Joker createJoker()
	{
		return new Joker();
		
	}
	
	private <T extends Protagonist> T genCreate(String s) {
			@SuppressWarnings("unchecked")
			T b =  (T) batcharachters.get(s);
		
		if (b == null) {
			Class<T> c = null;
			try {
				b = c.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			batcharachters.put(s, b);
			return b;
			}
		return b;
		
	}
	
	public Batman createBatman()
	{
		return  genCreate("batman");
		/*Batman b =  (Batman) batcharachters.get("batman");
		
		if (b == null) {
			b = new Batman();
			batcharachters.put("batman", b);
			return b;
			}
		return b;*/
	}
	
	public Robin createRobin()
	{
		return  genCreate("robin");
	}
	
	
	public Catwoman createCatWoman()
	{
		return  genCreate("catwoman");
	}
	
	public GothamGangster createGothamGangster()
	{
		return  genCreate("gothamgangster");
	}
	
	
	
}
