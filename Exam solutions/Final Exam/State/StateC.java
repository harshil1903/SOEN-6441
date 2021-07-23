import java.util.Scanner;

public class StateC extends StateA {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        System.out.println("Now in State C : \nAvailable options : [d]\n Enter Choice");
        char l_input = kbd.next().charAt(0);

        if (l_input == 'd')
        {
            p_DFArunner.state = new StateD();
        } else
        {
            System.out.println("Invalid Transition");
        }
    }

}
