@SuppressWarnings("serial")
public class NegativePressureException extends SensorException {
	public NegativePressureException(int new_v) {
		super(new_v);
		System.out.println("in NegativePressureException constructor");
	}
}
