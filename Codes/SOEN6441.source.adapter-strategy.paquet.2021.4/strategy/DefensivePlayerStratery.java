import java.util.List;
import java.util.Random;

/**
 *	ConcreteStrategy of the Strategy pattern. 
 */
public class DefensivePlayerStratery extends PlayerStrategy {

	public DefensivePlayerStratery(Player p_player, List<Territory> p_map) {
		super(p_player, p_map);
	}

	/**
	 *	Determines the country to attack to. 
	 *	The Defensive player does not attack, so this returns null.
	 *	@return null
	 */
	protected Territory toAttack() {
		return null;
	}

	/**
	 *	Determines which territory should be defended. 
	 *	The Defensive player decides to defend its country with the most armies. 
	 *	@return the player's country with the most armies
	 */
	protected Territory toDefend() {
		Territory mymaxarmies = d_player.owned_territories.get(0);
		for(Territory terr : d_map) {
			if (mymaxarmies.numArmies < terr.numArmies & d_player.owned_territories.contains(terr))
				mymaxarmies = terr; 
		}
		return mymaxarmies;
	}

	/**
	 *	Determines where to launch an attack from. The Defensive player does not attack, so it returns null
	 *@	return null
	 */
	protected Territory toAttackFrom() {
		return null;
	}

	/**
	 * 	Determine where armies are moved to. The Defensive player does not move, so it reutrns null
	 *  @return null
	 */
	protected Territory toMoveFrom() {
		return null;
	}

	/**
	 *  Create an order. the Defensive player can only use Deploy orders
	 *	@return created order
	 */
	public Order createOrder() {
		Random rand = new Random();
		if (rand.nextInt(5) != 0) {
			return new Deploy(d_player, toDefend(), rand.nextInt(20));
		}
		return null;
	}
}
