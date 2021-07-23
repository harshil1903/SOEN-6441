///////////////////////////////////////////////////////////////
// YOU CANNOT CHANGE THIS CODE OTHER THAN WHERE STATED BELOW //
///////////////////////////////////////////////////////////////
import java.util.LinkedList;

public class ReaderAndWriter {
	StringReader kbd_rdr;

	public LinkedList<String> readStrings() {
		return (kbd_rdr.read_kbd());
	}

	public void writeStrings(LinkedList<String> strings) {
		for (String string : strings) {
			System.out.print(string);
		}
	}

	public void chooseReader() {
		int choice = 0;
		System.out.println("Which reader do you choose?");
		System.out.println("1. String");
		System.out.println("2. Double");
		choice = ReaderDriver.kbd.nextInt();
		switch (choice) {
		case 1:
			kbd_rdr = new StringReader();
			break;
		case 2:
			kbd_rdr = new DoubleToStringReaderAdapter();
			break;
			//kbd_rdr = new DoubleToStringReaderAdapter();
			//////////////////////////////////////////
			// ADD CODE HERE TO CONNECT THE ADAPTER //
			//////////////////////////////////////////
		default: 
			kbd_rdr = new StringReader();
			break;
		}
	}
}
