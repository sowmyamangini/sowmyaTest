package support;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class DateFormatter {

	public static String ParseDate(String requestedDate) {

		if (requestedDate.toLowerCase().contains("today+")) {
			String[] requestedDates = requestedDate.split("\\+");
			int additionDays = Integer.parseInt(requestedDates[1].trim().replaceAll("days", ""));

			return daystobeMovedBy(additionDays);

		}

		else {
			return daystobeMovedBy(0);
		}

	}

	public static String daystobeMovedBy(int days) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		Calendar cal = Calendar.getInstance();
		// Adding 1 Day to the current date
		cal.add(Calendar.DAY_OF_MONTH, days);
		// Date after adding one day to the current date
		return sdf.format(cal.getTime());

	}
	
	
	
	public static String ParseTime(String requestedTime) {

		if (requestedTime.toLowerCase().contains("currenttime+")) {
			String[] requestedDates = requestedTime.split("\\+");
			int additionHours= Integer.parseInt(requestedDates[1].trim().replaceAll("hr", ""));

			return addHoursToCurrentTime(additionHours);

		}

		else {
			return addHoursToCurrentTime(0);
		}

	}
	
	public static String addHoursToCurrentTime(int hours) {

		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		Calendar cal = Calendar.getInstance();
		// Adding hours to the current date
		cal.add(Calendar.HOUR_OF_DAY, hours);
		// Date after adding one day to the current date
		return sdf.format(cal.getTime());

	}
	
}
