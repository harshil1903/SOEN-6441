@SuppressWarnings("serial")
public class OverloadPressureException extends SensorException {
	public OverloadPressureException(int new_v) {
		super(new_v);
		System.out.println("in OverloadPressureException constructor");
	}
}