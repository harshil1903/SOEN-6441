import java.util.Scanner;

public class CalculatorModel extends Observable{

    private double y;
    private double solution;
    private double x;

    public CalculatorModel() {
        solution = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setSolution(double p_s) {
        solution = p_s;
        notifyObservers(this);
    }

    public double getSolution() {
        return solution;
    }

    public void addition(double x, double y) {
        setSolution(x + y);
    }

    public void subtraction(double x, double y) {
        setSolution(x - y);
    }

    public void multiplication(double x, double y) {
        setSolution(x * y);
    }

    public void division(double x, double y) {
        setSolution(x / y);
    }
}
