/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.LinkedList;

public class StringReader {

	public LinkedList<String> read_kbd() {
	    String string = new String();
	    LinkedList<String> mystrings = new LinkedList<String>();
	    System.out.println("Enter strings separated by <enter>."); 
	    System.out.println("Enter \"quit\" to stop."); 
	    do {
	    	string = ReaderDriver.kbd.next(); 
	    	mystrings.add(string);
	    } while (!string.equals("quit"));
		return mystrings;
	}
	
}
