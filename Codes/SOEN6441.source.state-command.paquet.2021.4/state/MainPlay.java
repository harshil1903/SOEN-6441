/**
 *	ConcreteState of the State pattern. In this example, defines behavior 
 *  for commands that are valid in this state, and for the others signifies  
 *  that the command is invalid. 
 *  
 *  This state represents a group of states, and defines the behavior 
 *  that is common to all the states in its group. All the states in its 
 *  group need to extend this class. 
 *  
 */
public abstract class MainPlay extends Play {

	MainPlay(GameEngine p_ge) {
		super(p_ge);
	}

	public void loadMap() {
		this.printInvalidCommandMessage();
	}

	public void setPlayers() {
		this.printInvalidCommandMessage();	
	}

	public void assignCountries() {
		this.printInvalidCommandMessage();
	}
}
