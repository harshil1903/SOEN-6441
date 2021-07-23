import java.util.Scanner;

public class StateB extends StateA {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        System.out.println("Now in State B : \nAvailable options : [a]\n Enter Choice");
        char l_input = kbd.next().charAt(0);

        if (l_input == 'a')
        {
            p_DFArunner.state = new StateA();
        }
        else
        {
            System.out.println("Invalid Transition");
        }
    }
}
