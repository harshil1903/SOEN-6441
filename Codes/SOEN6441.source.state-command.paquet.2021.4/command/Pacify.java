/**
 * Pacify Order - Concrete Command of the Command pattern The Pacify order is
 * used to make a player not able to attack when an Advance order is executed.
 */
public class Pacify implements Order {

	Player target_player;
	Player initiator;

	/**
	 * The constructor receives all the parameters necessary to implement the order.
	 * These are then encapsulated in the order.
	 * 
	 * @param initiator: player that created the order
	 * @param target: player whose state will become "pacific"
	 */
	Pacify(Player initiator, Player target) {
		this.initiator = initiator;
		this.target_player = target;
	}

	/**
	 * Method to be called by the Recipient to execute the order.
	 */
	public void execute() {
		if (valid())
			this.target_player.state = Player.State.pacific;
	}

	public boolean valid() {
		// there are no conditions for this order to be valid
		return true;
	}

	public void printOrder() {
		System.out.println("Pacify order issued by player " + this.initiator.name);
		System.out.println(this.target_player.name + " has been pacified");
	}
}
