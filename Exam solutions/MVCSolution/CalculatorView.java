public class CalculatorView implements Observer{

    public CalculatorView(CalculatorModel calculatorModel)
    {
        calculatorModel.attach(this);
    }

    public void update(Observable observable) {

        double solution = ((CalculatorModel) observable).getSolution();
        System.out.println("Solution : " + solution);
    };
}
