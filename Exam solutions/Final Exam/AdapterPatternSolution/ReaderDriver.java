/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.LinkedList;
import java.util.Scanner;

public class ReaderDriver {
	public static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {

		ReaderAndWriter rdr = new ReaderAndWriter();
		LinkedList<String> strings = new LinkedList<String>();
		rdr.chooseReader();
		strings = rdr.readStrings(); 
		rdr.writeStrings(strings);
	}
	
}
