import java.io.IOException;

public class StackUnwindingDemo {

	public static void main(String[] args) {
		System.out.println("Entering main");
		Dummy d = null;
		DummyProcessor dp = null;
		try {
			d = new Dummy("Buster");
			dp = new DummyProcessor(d);
			dp.changeName();
		} catch (Exception e) {
			System.out.println("Caught an exception");
		    e.printStackTrace(System.out);
		}
		System.out.println("Changed name of the dummy : " + d.dummyName);
		System.out.println("Exiting main.");
	}
}
