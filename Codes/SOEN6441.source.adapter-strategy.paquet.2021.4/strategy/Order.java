public interface Order {
	/**
	 * 	Method that will be called by the Receiver to execute the Order
	 */
	public void execute();
	public boolean valid();
	public void printOrder();
}
