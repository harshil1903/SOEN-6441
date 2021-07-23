import java.util.Scanner;

public class StateD extends StateC {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        System.out.println("Now in State D. Final State");
        p_DFArunner.state = new StateStop();
    }

}
