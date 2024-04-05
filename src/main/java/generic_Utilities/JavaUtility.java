package generic_Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaUtility {
	public String getDate() {
		Date d = new Date();
		SimpleDateFormat s = new SimpleDateFormat("dd-MM-YYYY hh-mm-ss");
		String date = s.format(d);
		return date;
	}

}
