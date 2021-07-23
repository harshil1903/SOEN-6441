/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.LinkedList;
import java.util.InputMismatchException;

public class DoubleReader {
	public LinkedList<Double> read_double() {
	    double value = 0;
	    LinkedList<Double> mydoubles = new LinkedList<Double>();
	    System.out.println("Enter floating point numbers separated by <enter>."); 
	    System.out.println("Enter \"0\" to stop."); 
	    do {
	    	try{
	    		value = ReaderDriver.kbd.nextDouble(); 
	    	}catch(InputMismatchException e) {
	    		throw new MalformedIntegerException(mydoubles); 
	    	}
	    	mydoubles.add(value);
	    } while (value != 0 );
		return mydoubles;
	}
}
