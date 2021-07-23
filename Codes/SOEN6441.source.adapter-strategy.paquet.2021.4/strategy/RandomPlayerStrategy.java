import java.util.List;
import java.util.Random;
/**
 *	ConcreteStrategy of the Strategy pattern
 */
public class RandomPlayerStrategy extends PlayerStrategy {

	public RandomPlayerStrategy(Player p_player, List<Territory> p_map) {
		super(p_player, p_map); 
	}

	/**
	 *	Determines the country to attack/move to. 
	 *	The Random player determines this randomly
	 *	@return random territory
	 */
	protected Territory toAttack() {	
		Random rand = new Random();
		int rnd_target_territory;
		rnd_target_territory = rand.nextInt(d_map.size() - 1);	
		return(d_map.get(rnd_target_territory));
	}
	
	/**
	 *	Determines the country to attack to. 
	 *	The Random player determines this randomly. 
	 *	@return random territory owned by the player
	 */
	protected Territory toDefend() {
		Random rand = new Random();
		int rnd_target_territory;
		rnd_target_territory = rand.nextInt(d_player.owned_territories.size() - 1);
		return(d_player.owned_territories.get(rnd_target_territory));
	}

	/**
	 *	Determines the country to attack from. 
	 *	The Random player does not use this, so it returns null.
	 *	@return null
	 */
	protected Territory toAttackFrom() {
		return toDefend();
	}

	/**
	 *	Determines the country to move from. 
	 *	The Random player does not use this, so it returns null.
	 *	@return null
	 */
	protected Territory toMoveFrom() {
		return toDefend();
	}
	
	/**
	 *	Creates and order. 
	 *	The Random player can either deploy or advance, determined randomly. .
	 *	@return null
	 */
	public Order createOrder() {
		Random rand = new Random();
		int rndOrder = rand.nextInt(3);
		int rnd_num_of_armies;
		if (rand.nextInt(5) != 0) {
			switch (rndOrder) {
			case (0):
				// Deploy Order
				rnd_num_of_armies = rand.nextInt(20);
				return new Deploy(d_player, toDefend(), rnd_num_of_armies);
			case (1):
				// Advance Order
				rnd_num_of_armies = rand.nextInt(toMoveFrom().numArmies + 5);
				return new Advance(d_player, toMoveFrom(), toAttack(), rnd_num_of_armies);
			}
		}
		return null;
	}
}
