import java.util.Scanner;

public class StateStop extends StateD {

    static Scanner kbd = new Scanner(System.in);

    public void transition(DFArunner p_DFArunner)
    {
        System.out.println("Unreachable");
    }

}
