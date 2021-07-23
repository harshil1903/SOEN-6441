/**
 * Deploy Order - Concrete Command of the Command pattern
 * The Deploy order is used to add armies to a Territory. 
 */
public class Deploy implements Order {

	Territory target_territory;
	int to_deploy;
	Player initiator;

	/**
	 * The constructor receives all the parameters necessary to implement the order.
	 * These are then encapsulated in the order.
	 * 
	 * @param initiator: player that created the order
	 * @param target_territory: territory that will receive the new armies
	 * @param to_deploy: number of armies to be added
	 */
	public Deploy(Player initiator, Territory target_territory, int to_deploy) {
		this.target_territory = target_territory;
		this.initiator = initiator;
		this.to_deploy = to_deploy;
	}

	/**
	 *	Method to be called by the Recipient to execute the order. 
	 */
	public void execute() {
		if (valid())
			// add the armies to the target territory
			this.target_territory.numArmies += to_deploy;
	}

	public boolean valid() {
		if (target_territory.owner.equals(initiator))
			// the target territory must belong to the player that created the order
			return true;
		else {
			System.out.println("invalid order");
			return false;
		}
	}

	public void printOrder() {
		System.out.println("Deploy order issued by player " + this.initiator.name);
		System.out.println("Deploy " + this.to_deploy + " to " + this.target_territory.name);
	}
}
