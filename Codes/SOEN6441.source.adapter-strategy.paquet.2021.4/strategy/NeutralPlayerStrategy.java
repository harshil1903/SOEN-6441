import java.util.List;
/**
 *	ConcreteStrategy of the Strategy pattern
 */
public class NeutralPlayerStrategy extends PlayerStrategy {

	public NeutralPlayerStrategy(Player p_player, List<Territory> p_map) {
		super(p_player, p_map); 
	}

	/**
	 *	Determines the territory to attack. 
	 *	The Neutral player does not attack, so this returns null
	 *	@return null
	 */
	protected Territory toAttack() {	
		return null;
	}

	/**
	 *	Determines the territory to attack. 
	 *	The Neutral player does not attack, so this returns null
	 *	@return null
	 */
	protected Territory toDefend() {
		return null;
	}

	/**
	 *	Determines the territory to attack from. 
	 *	The Neutral player does not attack, so this returns null
	 *	@return null
	 */
	protected Territory toAttackFrom() {
		return null;
	}

	/**
	 *	Determines the territory to move from 
	 *	The Neutral player does not move, so this returns null
	 *	@return null
	 */
	protected Territory toMoveFrom() {
		return null;
	}

	/**
	 *	Creates an order. 
	 *	The Neutral player does not issue orders, so this returns null.
	 *	@return null
	 */
	public Order createOrder() {
		return null;
	}
}
