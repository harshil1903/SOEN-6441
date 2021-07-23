public class PlaySetup extends Play {

	PlaySetup(GameEngine p_ge) {
		super(p_ge);
	}

	public void loadMap() {
		System.out.println("map has been loaded");
	}

	public void setPlayers() {
		System.out.println("players have been set");
	}

	public void assignCountries() {
		System.out.println("countries have been assigned");
	}

	public void reinforce() {
		printInvalidCommandMessage(); 
	}

	public void attack() {
		printInvalidCommandMessage(); 
	}

	public void fortify() {
		printInvalidCommandMessage(); 
	}

	public void endGame() {
		printInvalidCommandMessage(); 
	}

	public void next() {
		ge.setPhase(new Reinforcement(ge));
	}
}
