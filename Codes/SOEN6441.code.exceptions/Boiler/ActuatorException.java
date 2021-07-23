@SuppressWarnings("serial")
public class ActuatorException extends HardwareException {
	public ActuatorException(HardwareState new_s) {
		super();
		System.out.println("in ActuatorException constructor");
		hw_state = new_s;
	}

	public String toString() {
		return this.exc_time + " : " + this.getClass() + " : "
				+ this.hw_state.name();
	}

	HardwareState hw_state;
}
