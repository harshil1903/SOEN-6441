public class Dummy {
	public String dummyName;
	public int age;

	Dummy(String s) {
		dummyName = s;
		System.out.println("Created Dummy: " + dummyName);
	}

	Dummy(Dummy other) {
		dummyName = other.dummyName;
		System.out.println("Copy created Dummy: " + dummyName);
	}
}
