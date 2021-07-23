import java.util.Scanner;
public class DFArunner {
	public static Scanner kbd = new Scanner(System.in);
	DFAstate state = new StateStart();
	
	public char getInput() {
		char value = kbd.next().charAt(0);
		return value; 
	}
	
	public void run() {
		while(state.getClass().getName() != "StateStop") {
			state.transition(this);
		}
	}
}
