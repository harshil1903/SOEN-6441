import java.util.Scanner;

public class CalculatorController {

    CalculatorModel calculatorModel;
    CalculatorView calculatorView;
    public enum operation {
        add, sub, mult, div
    };

    public CalculatorController(CalculatorView calculatorView, CalculatorModel calculatorModel)
    {
        this.calculatorView = calculatorView;
        this.calculatorModel = calculatorModel;
    }

    public void calculate()
    {
        char another = 'n';
        double operand1, operand2;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Initial Value: ");
        operand1 = keyboard.nextDouble();
        calculatorModel.setX(operand1);
        do{
            System.out.println("What operation? ('add', 'sub', 'mult', 'div')");
            operation opr = operation.valueOf(keyboard.next());

            System.out.println("operand: ");
            operand2 = keyboard.nextDouble();
            calculatorModel.setY(operand2);

            switch (opr){
                case add:
                    calculatorModel.addition(calculatorModel.getX(), calculatorModel.getY());
                    break;
                case sub:
                    calculatorModel.subtraction(calculatorModel.getX(), calculatorModel.getY());
                    break;
                case mult:
                    calculatorModel.multiplication(calculatorModel.getX(), calculatorModel.getY());
                    break;
                case div:
                    calculatorModel.division(calculatorModel.getX(), calculatorModel.getY());
                    break;
            }

            System.out.print("continue (y/n)?");
            another = keyboard.next().charAt(0);
        }while(another == 'y');
    }
}
