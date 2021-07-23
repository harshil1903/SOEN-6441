/////////////////////////////////
// YOU CANNOT CHANGE THIS CODE //
/////////////////////////////////
import java.util.LinkedList;
import java.util.InputMismatchException;

public class MalformedIntegerException extends InputMismatchException{
	private static final long serialVersionUID = 1423093016149647500L;
	LinkedList<Double> a; 
	MalformedIntegerException(LinkedList<Double> a){
		this.a = a;
	}
	public LinkedList<Double> getIntegers(){
		return a; 
	}
}
