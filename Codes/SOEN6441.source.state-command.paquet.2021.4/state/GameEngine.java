import java.util.Scanner;

/**
 *  Context of the State pattern. 
 *  It contains a State object (in this example the State class is the class Phase). 
 */
public class GameEngine {

	/**
	 * State object of the GameEngine 
	 */
	private Phase gamePhase;
	
	int mystart;
	int mycommand;

	/**
	 * Method that allows the GameEngine object to change its state.  
	 * @param p_phase new state to be set for the GameEngine object.
	 */
	public void setPhase(Phase p_phase) {
		gamePhase = p_phase;
		System.out.println("new phase: " + p_phase.getClass().getSimpleName());
	}
	
	/**
	 * This method will ask the user: 
	 * 1. What part of the game they want to start with (edit map or play game). 
	 *      Depending on the choice, the state will be set to a different object, 
	 *      which will set different behavior. 
	 * 2. What command they want to execute from the game. 
	 *      Depending on the state of the GameEngine, each command will potentially 
	 *      have a different behavior. 
	 */
	public void start() {
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("1. Edit Map");
			System.out.println("2. Play Game");
			System.out.println("3. Quit");
			System.out.println("Where do you want to start?: ");
			mystart = keyboard.nextInt();
			switch (mystart) {
			case 1:
				// Set the state to Preload
				setPhase(new Preload(this));
				break;
			case 2:
				// Set the state to PlaySetup
				setPhase(new PlaySetup(this));
				break;
			case 3:
				System.out.println("Bye!");
				return;
			}
			do {
				System.out.println(" =================================================");
				System.out.println("| #   PHASE                   : command           |"); 
				System.out.println(" =================================================");
				System.out.println("| 1.  Any except MainPlay     : load map          |");
				System.out.println("| 2.  Any                     : show map          |");
				System.out.println("| 3.  Edit:PostLoad           : edit country      |");
				System.out.println("| 4.  Edit:Postload           : save map and play |");
				System.out.println("| 5.  Play:PlaySetup          : set players       |");
				System.out.println("| 6.  Play:PlaySetup          : assign countries  |");
				System.out.println("| 7.  Play:MainPlay:Reinforce : reinforce         |");
				System.out.println("| 8.  Play:MainPlay:Attack    : attack            |");
				System.out.println("| 9.  Play:MainPlay:Fortify   : fortify           |");
				System.out.println("| 10. Play                    : end game          |");
				System.out.println("| 0.  Any                     : next phase        |");
				System.out.println(" =================================================");
				System.out.println("enter a " + gamePhase.getClass().getSimpleName() + " phase command: ");
				mycommand = keyboard.nextInt();
				System.out.println(" =================================================");
				//
				// Calls the method corresponding to the action that the user has selected. 
				// Depending on what it the current state object, these method calls will  
				// have a different implementation. 
				//
				switch (mycommand) {
				case 1:
					gamePhase.loadMap();
					break;
				case 2:
					gamePhase.showMap();
					break;
				case 3:
					gamePhase.editCountry();
					break;
				case 4:
					gamePhase.saveMap();
					break;
				case 5:
					gamePhase.setPlayers();
					break;
				case 6:
					gamePhase.assignCountries();
					break;
				case 7:
					gamePhase.reinforce();
					break;
				case 8:
					gamePhase.attack();
					break;
				case 9:
					gamePhase.fortify();
					break;
				case 10:
					gamePhase.endGame();
					break;
				case 0:
					gamePhase.next();
					break;
				default: 
					System.out.println("this command does not exist");
				}
			} while (!(gamePhase instanceof End));
		} while (mycommand != 3);
		keyboard.close();
	}
}
