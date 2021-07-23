@SuppressWarnings("serial")
public class StuckValveException extends ActuatorException {
	public StuckValveException(HardwareState new_s) {
		super(new_s);
		System.out.println("in StuckValveException constructor");
	}
}