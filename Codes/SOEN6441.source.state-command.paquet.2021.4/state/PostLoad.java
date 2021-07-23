public class PostLoad extends Edit {

	PostLoad(GameEngine p_ge) {
		super(p_ge);
	}
	
	public void showMap() {
		System.out.println("edited map is displayed");
	}

	public void loadMap() {
		System.out.println("map has been loaded");
	}

	public void editCountry() {
		System.out.println("country has been edited");
	}

	public void saveMap() {
		System.out.println("map has been saved");
		ge.setPhase(new PlaySetup(ge));
	}

	public void next() {
		System.out.println("must save map");
	}
}
