public class PressureReleaseValveConnector {
	private PressureReleaseValve prv;
	Boiler b;

	public PressureReleaseValveConnector(PressureReleaseValve new_prv,
			Boiler new_b) {
		System.out.println("in PressureReleaseValveConnector constructor");
		prv = new_prv;
		b = new_b;
	}

	void close() {
		System.out.println("in PressureReleaseValveConnector::close()");
		try {
			prv.close();
		} catch (StuckValveException e) {
			System.out
					.println("catching StuckValveException in PressureReleaseValveConnector::close()");
			b.emergencyFile.write(e.toString());
		}
	}

	void open() {
		System.out.println("in PressureReleaseValveConnector::open()");
		try {
			prv.open();
		} catch (StuckValveException e) {
			System.out
					.println("catching StuckValveException in PressureReleaseValveConnector::open()");
			System.out.println("\nEvacuation!!\n");
			b.boilerState = BoilerState.critical;
			b.emergencyFile.write(e.toString() + "\r\n");
			b.emergencyFile.write("Evacuation!!\r\n");
		}
	}
}
