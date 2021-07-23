import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Context in the Strategy pattern
 */
public class Player {

	public String name;
	public ArrayList<Territory> owned_territories;
	public ArrayList<Order> orders_list;
	PlayerStrategy strategy;

	public Player(String name) {
		this.name = name;
		this.owned_territories = new ArrayList<Territory>();
		this.orders_list = new ArrayList<Order>();
	}
	
	public void setStrategy(PlayerStrategy p_strat) {
		strategy = p_strat; 
	}; 

	public boolean issueOrder() {
		Order order;
		order = strategy.createOrder();
		if (order != null) {
			orders_list.add(order);
			return true;
		}
		return false;
	}

	public Order getNextOrder() {
		Order to_return = null;
		if (!this.orders_list.isEmpty()) {
			to_return = this.orders_list.get(0);
			this.orders_list.remove(0);
			return to_return;
		} else
			return null;
	}
}
