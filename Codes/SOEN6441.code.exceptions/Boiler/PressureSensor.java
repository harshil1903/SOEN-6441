import java.util.Random;

public class PressureSensor {
	public PressureSensor() {
		randomGenerator = new Random();
	}

	int getPressure() throws NegativePressureException,
			OverloadPressureException {
		System.out.println("in PressureSensor::getPressure()");
		int pressure = randomGenerator.nextInt(105) - 1;
		if (pressure < 0) {
			System.out.println("about to throw NegativePressureException");
			throw new NegativePressureException(pressure);
		}
		if (pressure > 100) {
			System.out.println("about to throw OverloadPressureException");
			throw new OverloadPressureException(pressure);
		}
		return pressure;
	}

	private Random randomGenerator;
};
