import java.util.Scanner;

public class ConstructorExceptionsDriver {
	public static void main(String[] args) {
		char classToThrow = 'Z';
		A a = null;		
		Scanner keyboard = new Scanner(System.in);
		while (classToThrow != 'X') {
			System.out.println("Enter the class name to throw an exception (A,B,C,D or N for None or X for eXit): ");
			classToThrow = keyboard.next().charAt(0);
			try {
				A.classToThrow = classToThrow;
				a = new A();
			} catch (Exception e) {
				System.out.println("catching Exception");
                // even though the constructors to the parts of a were called and resolved
				// none is accessible since a is a null pointer if constructor A does not resolve
				// if that is the case, the references to a's parts will be garbage collected, 
				// as they are no longer accessible through a.
				
				// Any of the following would thus fail if constructor A does not resolve. 

				// System.out.println("a.mD.state: " + a.mD.state);
				// System.out.println("a.mC.state: " + a.mC.state);
				// System.out.println("a.stateB: " + a.stateB);
				// System.out.println("a.stateA: " + a.stateA);
			} 
		}


		keyboard.close();
	}
}
