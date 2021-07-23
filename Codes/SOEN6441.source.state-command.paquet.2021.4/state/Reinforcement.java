/**
 *	
 */
public class Reinforcement extends MainPlay {

	Reinforcement(GameEngine p_ge) {
		super(p_ge);
	}

	public void reinforce() {
		System.out.println("reinforcement done");
		ge.setPhase(new Attack(ge));
	}

	public void attack() {
		printInvalidCommandMessage(); 
	}

	public void fortify() {
		printInvalidCommandMessage(); 
	}

	public void next() {
		ge.setPhase(new Attack(ge));
	}
}
