/**
 * Advance Order - ConcreteCommand of the the Command pattern.
 * 
 * The Advance order is used to move armies from one Territory to another.
 */
public class Advance implements Order {

	Territory source;
	Territory target;
	Player initiator;
	int num_to_advance;

	/**
	 * The constructor receives all the parameters necessary to implement the order.
	 * These are then encapsulated in the order.
	 * 
	 * @param initiator: the player that created to order
	 * @param source:    territory from which the armies are moved from
	 * @param target:    territory to which the armeis are moved to
	 * @param num:       number of armies to advance
	 */
	Advance(Player initiator, Territory source, Territory target, int num) {
		this.initiator = initiator;
		this.source = source;
		this.target = target;
		this.num_to_advance = num;
	}

	/**
	 * Method to be called by the Recipient to execute the order.
	 */
	public void execute() {
		if (valid()) {
			if (target.owner.equals(initiator)) {
				// if the source and the target belong to the same player
				// then just move the armies.
				target.numArmies += this.num_to_advance;
				source.numArmies -= this.num_to_advance;
			} else {
				// if the target belong to another player
				// and the initiator's state is not pacific
				// then implement a simplified battle
				source.numArmies -= num_to_advance;
				target.numArmies -= num_to_advance;
				if (target.numArmies < 0) {
					// if the battle results in all defending armies to be eliminated
					// then transfer surviving attacking armies to the target
					// and transfer ownership of the target to the initiating player
					target.numArmies = Math.abs(target.numArmies);
					target.owner = this.initiator;
				}
			}
		}
	}

	public boolean valid() {
		if (source.owner.equals(initiator) && this.num_to_advance <= source.numArmies )
			return true;
		else {
			System.out.println("invalid order");
			return false;
		}
	}

	public void printOrder() {
		System.out.println("Advance order issued by player " + this.initiator.name);
		System.out.println("Advance " + this.num_to_advance + " from " + source.name + " to " + target.name);
	}
}
