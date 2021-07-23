public class Boiler {
	public Boiler() {
		System.out.println("in Boiler constructor");
		emergencyFile = new FileWriterWrapper("EmergencyFile.txt");
		emergencyFile.write("STARTING BOILER CONTROLLER\r\n");
		pressureReportFile = new FileWriterWrapper("pressureReportFile.txt");
		pressureReportFile.write("STARTING BOILER CONTROLLER\r\n");
		ps = new PressureSensorConnector(new PressureSensor(), this);
		prv = new PressureReleaseValveConnector(new PressureReleaseValve(
				HardwareState.stuck), this);
		boilerState = BoilerState.safe;
	}

	void shutdown() {
		System.out.println("in Boiler::shutdown");
		emergencyFile.write("Engaging shutdown procedure.\r\n");
		prv.open();
		System.out.println("Boiler::shutdown() closing files");
		emergencyFile.write("BOILER CONTROLLER SHUT DOWN\r\n");
		emergencyFile.close();
		pressureReportFile.write("BOILER CONTROLLER SHUT DOWN\r\n");
		pressureReportFile.close();
	}

	void start() {
		System.out.println("in Boiler::start()");
		while (boilerState == BoilerState.safe) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			System.out.println(ps.getPressure());
		}
	}

	PressureSensorConnector ps;
	PressureReleaseValveConnector prv;
	BoilerState boilerState;
	FileWriterWrapper emergencyFile;
	FileWriterWrapper pressureReportFile;
}
