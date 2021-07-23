import java.util.Random;

public class PressureReleaseValve {
	public PressureReleaseValve(HardwareState new_s) {
		System.out.println("in PressureReleaseValve constructor");
		hw_state = new_s;
		act_state = ActuatorState.closed;
		randomGenerator = new Random();
	}

	void close() throws StuckValveException {
		System.out.println("in PressureReleaseValve::close()");
		if (randomGenerator.nextInt(100) <= 2) {
			hw_state = HardwareState.stuck;
		}
		if (hw_state == HardwareState.stuck
				&& act_state == ActuatorState.opened) {
			System.out.println("about to throw StuckValveException");
			throw new StuckValveException(hw_state);
		}
	}

	void open() throws StuckValveException {
		System.out.println("in PressureReleaseValve::open()");
		if (randomGenerator.nextInt(100) <= 2) {
			hw_state = HardwareState.stuck;
		}
		if (hw_state == HardwareState.stuck
				&& act_state == ActuatorState.closed) {
			System.out.println("about to throw StuckValveException");
			throw new StuckValveException(hw_state);
		}
	}

	private ActuatorState act_state;
	HardwareState hw_state;
	Random randomGenerator;
}
