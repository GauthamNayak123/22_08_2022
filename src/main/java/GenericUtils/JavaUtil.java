package GenericUtils;

import java.time.LocalDateTime;
import java.util.Random;

public class JavaUtil {
	
	public int getRandomNumber() {
		Random ran=new Random();
		return ran.nextInt(1000);
	}
	
	public String getDate() {
		String dt=LocalDateTime.now().toString();
		dt=dt.replace(':', '-');
		return dt;
	}
	
	
	
}
