@SuppressWarnings("serial")
public class SensorException extends HardwareException {
	public String toString() {
		return this.exc_time + " : " + this.getClass() + " : " + valueRead;
	}

	SensorException(int new_v) {
		super();
		System.out.println("in SensorException constructor");
		valueRead = new_v;
	}

	int valueRead;
}
