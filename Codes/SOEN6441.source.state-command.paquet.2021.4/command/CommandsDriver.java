import java.util.ArrayList;
import java.util.List;

/**
 * Client of the Command pattern
 */
public class CommandsDriver {

	public static void main(String args[]) {
		GameEngine ge = new GameEngine();
		ge.start();
	}
}