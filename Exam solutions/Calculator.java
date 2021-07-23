import java.util.Scanner;

/**
 * This is the Calculator Implementation.
 * It performs following operations:
 * <ul>
 *     <li>Add</li>
 *     <li>Subtract</li>
 *     <li>Multiply</li>
 *     <li>Divide</li>
 * </ul>
 *
 * @author Harshil
 */
public class Calculator {

	/**
	 * The Operation enumerator is to check which operation is to be performed
	 */
	public enum operation {
		/**
		 * Add operation.
		 */
		add,
		/**
		 * Sub operation.
		 */
		sub,
		/**
		 * Mult operation.
		 */
		mult,
		/**
		 * Div operation.
		 */
		div
	};


	/**
	 * The data member to store first operand
	 */
	private double x;
	/**
	 * The data member to store second operand
	 */
	private double y;
	/**
	 * The data member to store Scanner
	 */
	static Scanner keyboard;
	/**
	 * The data member to store solution
	 */
	private double solution;


	/**
	 * Gets value of x.
	 *
	 * @return the value of x that is the first operand
	 */
	public double getX() {
		return x;
	}

	/**
	 * Sets value of x.
	 *
	 * @param x The value to be set to variable x
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Gets value of y.
	 *
	 * @return the value of y that is the second operand
	 */
	public double getY() {
		return y;
	}

	/**
	 * Sets value of y.
	 *
	 * @param y The value to be set to variable y
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Sets solution.
	 *
	 * @param p_s the p s
	 */
	public void setSolution(double p_s) {
		solution = p_s; 
	}

	/**
	 * Gets solution.
	 *
	 * @return the solution
	 */
	public double getSolution() {
		return solution; 
	}

	/**
	 * Instantiates a new Calculator
	 */
	public Calculator() {
		solution = 0;
		keyboard = new Scanner(System.in);
	}

	/**
	 * Addition Operation
	 *
	 * @param x the x operand
	 * @param y the y operand
	 */
	public void addition(double x, double y) {
		setSolution(x + y);
	}

	/**
	 * Subtraction Operation
	 *
	 * @param x the x operand
	 * @param y the y operand
	 */
	public void subtraction(double x, double y) {
		setSolution(x - y);
	}

	/**
	 * Multiplication Operation
	 *
	 * @param x the x operand
	 * @param y the y operand
	 */
	public void multiplication(double x, double y) {
		setSolution(x * y);
	}

	/**
	 * Division Operation
	 *
	 * @param x the x operand
	 * @param y the y operand
	 */
	public void division(double x, double y) {
		setSolution(x / y);
	}

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments from command line
	 */
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		char another = 'n';
		System.out.println("initial value: ");
		calc.setX(Integer.parseInt(keyboard.next()));
		do {
			System.out.println("What operation? ('add', 'sub', 'mult', 'div')");
			operation ttt = operation.valueOf(keyboard.next());
			System.out.println("operand: ");
			calc.setY(keyboard.nextDouble());
			switch (ttt) {
			case add:
				calc.addition(calc.getX(), calc.getY());
				break;
			case sub:
				calc.subtraction(calc.getX(), calc.getY());
				break;
			case mult:
				calc.multiplication(calc.getX(), calc.getY());
				break;
			case div:
				calc.division(calc.getX(), calc.getY());
				break;
			}
			System.out.println("solution =" + calc.solution);
			calc.setX(calc.solution);
			System.out.print("continue (y/n)?");
			another = keyboard.next().charAt(0);
		} while (another == 'y');
	}
}