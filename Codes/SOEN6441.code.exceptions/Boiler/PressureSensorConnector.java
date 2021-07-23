import java.text.*;
import java.util.Date;

public class PressureSensorConnector {
	private PressureSensor ps;
	Boiler b;

	public PressureSensorConnector(PressureSensor new_ps, Boiler new_b) {
		System.out.println("in PressureSensorConnector constructor");
		ps = new_ps;
		b = new_b;
	}

	int getPressure() {
		System.out.println("in PressureSensorConnector::getPressure()");
		int pressure = 999;
		try {
			pressure = ps.getPressure();
			b.pressureReportFile.write(pressure + " @ " + getTime() + "\r\n");
		} catch (SensorException e) {
			System.out
					.println("catching SensorException in PressureSensorConnector::getPressure()");
			b.emergencyFile.write(e.toString() + "\r\n");
			b.boilerState = BoilerState.unsafe;
			b.shutdown();
		}
		return pressure;
	}

	String getTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
}
