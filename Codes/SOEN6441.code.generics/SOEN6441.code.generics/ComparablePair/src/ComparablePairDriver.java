import java.util.ArrayList;

public class ComparablePairDriver {

	public static void main(String[] args) {
	
		ArrayList<ComparablePair<Integer, String>> alcp = new ArrayList<ComparablePair<Integer, String>>();
		alcp.add(new ComparablePair<Integer, String>(3,"trois"));
		alcp.add(new ComparablePair<Integer, String>(4,"quatre"));
		alcp.add(new ComparablePair<Integer, String>(1,"un"));
		alcp.add(new ComparablePair<Integer, String>(1,"one"));
		alcp.add(new ComparablePair<Integer, String>(1,"one"));

	    ComparablePair<Integer, String> previousalcp = null; 
		for (ComparablePair<Integer, String> p : alcp) {
			System.out.println(p);
		    if (previousalcp != null) System.out.println(p.compareTo(previousalcp));
		    previousalcp = new ComparablePair<Integer, String>(p); 
		}
	}
}
