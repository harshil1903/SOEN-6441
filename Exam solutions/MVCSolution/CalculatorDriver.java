public class CalculatorDriver {

    CalculatorModel calculatorModel;
    CalculatorView calculatorView;
    CalculatorController calculatorController;

    public CalculatorDriver()
    {
        calculatorModel = new CalculatorModel();
        calculatorView = new CalculatorView(calculatorModel);
        calculatorController = new CalculatorController(calculatorView, calculatorModel);
    }

    public void runCalculator()
    {
        calculatorController.calculate();
    }

    public static void main(String[] args) {
        CalculatorDriver calculatorDriver = new CalculatorDriver();

        System.out.println("CALCULATOR");
        calculatorDriver.runCalculator();

        System.out.println("CALCULATOR Exited");

    }
}
