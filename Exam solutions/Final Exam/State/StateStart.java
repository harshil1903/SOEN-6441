import java.util.Scanner;

public class StateStart extends DFAstate {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        p_DFArunner.state = new StateA();
    }

}
