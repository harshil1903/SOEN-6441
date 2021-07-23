import java.util.ArrayList;
import java.util.List;

/**
 * 	Game Engine - Client in the Strategy pattern
 */
public class GameEngine {

	List<Territory> map;
	List<Player> players;

	GameEngine() {
		map = new ArrayList<Territory>();
		players = new ArrayList<Player>();
	}

	public void start() {
		int numTurns = 5;

		// create the players
		players.add(new Player("player1"));
		players.add(new Player("player2"));
		players.add(new Player("player2"));
		players.get(0).setStrategy(new DefensivePlayerStratery(players.get(0), map)); 
		players.get(1).setStrategy(new RandomPlayerStrategy(players.get(1), map));
		players.get(2).setStrategy(new NeutralPlayerStrategy(players.get(2), map));
		
		// create the map
		map.add(new Territory("territory1", players.get(0), 10));
		map.add(new Territory("territory2", players.get(0), 10));
		map.add(new Territory("territory3", players.get(1), 10));
		map.add(new Territory("territory4", players.get(1), 10));
		printMap();

		// run the game turns
		for (int turn = 1; turn <= numTurns; turn++) {
			boolean an_order = true;
			do {
				for (Player p : players) {
					an_order = p.issueOrder();
					if (!an_order)
						break;
				}
			} while (an_order);
			executeAllOrders();
			printMap();
		}
	}

	public void printMap() {
		System.out.println("===========================MAP============================");
		for (Territory t : map) {
			t.print();
		}
		System.out.println("===========================MAP============================");
	}

	public void executeAllOrders() {
		System.out.println("===============BEGIN EXECUTING ALL ORDERS=================");
		Order order;
		boolean still_more_orders = false;
		do {
			still_more_orders = false;
			for (Player p : players) {
				order = p.getNextOrder();
				if (order != null) {
					still_more_orders = true;
					order.printOrder();
					order.execute();
				}
			}
		} while (still_more_orders);
		System.out.println("===============END EXECUTING ALL ORDERS===================");
	}
}


