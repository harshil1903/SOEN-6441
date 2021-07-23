import java.util.ArrayList;

public class PairDriver {

	public static void main(String[] args) {
		Pair<String, Integer> p1 = new Pair<String, Integer>("Hello", 1);
		System.out.println(p1);

		ArrayList<Integer> v1 = new ArrayList<Integer>();
		for (int x = 1; x <= 3; x++)
			v1.add(new Integer(x));

		ArrayList<String> v2 = new ArrayList<String>();
		v2.add(new String("un"));
		v2.add(new String("deux"));
		v2.add(new String("trois"));

		ArrayList<Pair<Integer, String>> v3 = new ArrayList<Pair<Integer, String>>();
		for (int x = 0; x <= 2; x++)
			v3.add(new Pair<Integer, String>(v1.get(x), v2.get(x)));

		for (Pair<Integer, String> p : v3)
			System.out.println(p);
	}
}
