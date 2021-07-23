import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@SuppressWarnings("serial")
public class HardwareException extends Exception {
	public HardwareException() {
		System.out.println("in HardwareException constructor");
		exc_time = getTime();
	}

	String getTime() {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}

	String exc_time;
}
