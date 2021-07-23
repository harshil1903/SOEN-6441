import java.util.Scanner;

public class StateA extends StateStart {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        System.out.println("Now in State A : \nAvailable options : [a, b, c]\n Enter Choice");
        char l_input = kbd.next().charAt(0);

        switch (l_input){
            case 'a':
                p_DFArunner.state = new StateA();
                break;
            case 'b':
                p_DFArunner.state = new StateB();
                break;
            case 'c':
                p_DFArunner.state = new StateC();
                break;
            default:
                System.out.println("Invalid Transition");
                break;
        }
    }

}
