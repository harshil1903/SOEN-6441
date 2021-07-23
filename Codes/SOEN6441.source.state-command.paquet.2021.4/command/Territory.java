public class Territory {

	String name; 
	int numArmies; 
	Player owner; 

	public Territory(String name, Player p, int init_armies) {
		this.name = name; 
		this.owner = p;
		this.numArmies = init_armies; 
		p.owned_territories.add(this);
	}
	
	public void print() {
		System.out.println("Territory " + name + " has " + numArmies + " armies and is owned by " + owner.name); 
	}

}
