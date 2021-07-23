import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Player - Client in the Command pattern
 */
public class Player {

	enum State {
		pacific, normal
	}

	public String name;
	public State state;
	public ArrayList<Territory> owned_territories;
	public ArrayList<Order> orders_list;

	public Player(String name) {
		this.name = name;
		state = State.normal;
		this.owned_territories = new ArrayList<Territory>();
		this.orders_list = new ArrayList<Order>();
	}

	public boolean createOrder(List<Territory> map, List<Player> players) {
		Random rand = new Random();
		int rndOrder = rand.nextInt(3);
		int rnd_target_territory;
		int rnd_source_territory;
		int rnd_num_of_armies;
		int rnd_player;

		if (rand.nextInt(5) != 0) {
			switch (rndOrder) {
			case (0):
				// Deploy Order
				rnd_target_territory = rand.nextInt(this.owned_territories.size() - 1);
				rnd_num_of_armies = rand.nextInt(20);
				this.orders_list
						.add(new Deploy(this, this.owned_territories.get(rnd_target_territory), rnd_num_of_armies));
				break;
			case (1):
				// Advance Order
				rnd_source_territory = rand.nextInt(this.owned_territories.size() - 1);
				rnd_target_territory = rand.nextInt(map.size() - 1);
				rnd_num_of_armies = rand.nextInt(this.owned_territories.get(rnd_source_territory).numArmies + 5);
				this.orders_list.add(new Advance(this, this.owned_territories.get(rnd_source_territory),
						map.get(rnd_target_territory), rnd_num_of_armies));
				break;
			case (2):
				// Pacify Order
				rnd_player = rand.nextInt(players.size() - 1);
				this.orders_list.add(new Pacify(this, players.get(rnd_player)));
				break;
			}
			return true;
		} else {
			return false;
		}
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
