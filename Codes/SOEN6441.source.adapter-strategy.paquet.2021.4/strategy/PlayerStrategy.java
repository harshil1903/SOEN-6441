import java.util.List;

/**
 *	Strategy of the Strategy pattern
 */
public abstract class PlayerStrategy {
	
	/**
	 *	THe Strategy needs to have access to the map to determine target territories for the orders.   
	 */
	List<Territory> d_map;
	/**
	 * 
	 */
	Player d_player; 
	
	protected abstract Territory toAttack(); 
	protected abstract Territory toAttackFrom(); 
	protected abstract Territory toMoveFrom(); 
	protected abstract Territory toDefend();
	public abstract Order createOrder();	
	
	PlayerStrategy(Player p_player, List<Territory> p_map){
		d_player = p_player; 
		d_map = p_map; 
	}
}
