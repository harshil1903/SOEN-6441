import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DummyProcessor {
	private Dummy pd;

	public DummyProcessor(Dummy d) {
		pd = d;
	}

	public void write() throws IOException {
		System.out.println("Entering Function write");
		// if askUser() fails below, localBDummy would be released 
		// for the garbage collector to process
		Dummy localBDummy = new Dummy("Local write() Dummy");
		BufferedWriter file = new BufferedWriter(new FileWriter(
				"DummyOutput.txt"));
		file.write(pd.dummyName + ", " + pd.age);
		// never closed if write throws an exception!
		// solution is to catch here, or else a resource is leaked
		file.close();
		System.out.println("Exiting Function write");
	}

	public void askUser() throws IOException {
		System.out.println("Entering Function askUser");
		// if askUser() fails below, localCDummy would be released 
		// for the garbage collector to process
		Dummy localCDummy = new Dummy("Local changeName() Dummy");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the age of the Dummy: ");
		pd.age = keyboard.nextInt();
		this.write();
		// Scanner is never closed if write throws an exception!
		// solution is to catch here, or else a resource is leaked
		keyboard.close();
		System.out.println("Exiting Function askUser");
	}

	public void changeName() throws IOException {
		System.out.println("Entering Function changeName");
		// if askUser() fails below, localCDummy would be released 
		// for the garbage collector to process
		Dummy localCDummy = new Dummy("Local read() Dummy");
		BufferedReader file = new BufferedReader(new FileReader("DummyInput.txt"));
		System.out.println("File opened");
		pd.dummyName = pd.dummyName + " " + file.readLine();
		this.askUser();
		// BufferedReader and FileReader are never closed if write throws an exception!
		// solution is to catch here, or else a resource is leaked
		file.close();
		System.out.println("Exiting Function changeName");
	}
}
