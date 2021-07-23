import java.util.Scanner;

public class StateStart extends DFAstate {

    public void transition(DFArunner p_DFArunner)
    {
        p_DFArunner.state = new StateA();
    }

}
