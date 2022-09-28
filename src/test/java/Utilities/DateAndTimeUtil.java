package Utilities;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

/**
 * @author jxavier
 * general utility to get/format data and time
 */
public class DateAndTimeUtil {

	private static Logger log = Logger.getLogger(DateAndTimeUtil.class);

	/**
	 * @param timeValue
	 * @param timeFormat
	 * @return checks that the time value is in specified format
	 */
	public boolean isValidTimeFormat(String timeValue, String timeFormat) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(timeFormat);
			formatter.parse(timeValue);
			return true;
		} catch (DateTimeParseException e) {
			log.error("Invalid Time format error. ", e);
			return false;
		}
	}

	/**
	 * @param timeValue
	 * @param timeFormat
	 * @return converts the time into specified format
	 */
	public static String convertToTimeFormat(String timeValue, String timeFormat) {
		try {
			Long value = Long.valueOf(timeValue);
			timeFormat = timeFormat.toUpperCase();
			String hh = Long.toString(TimeUnit.SECONDS.toHours(value));
			String mm = Long.toString((TimeUnit.SECONDS.toMinutes(value)) % 60);
			String ss = Long.toString((TimeUnit.SECONDS.toSeconds(value)) % 360);
			hh = String.format("%02d", Integer.parseInt(hh));
			mm = String.format("%02d", Integer.parseInt(mm));
			ss = String.format("%02d", Integer.parseInt(ss));

			switch (timeFormat) {
			case "HHMM":
				log.info("time value in " + timeFormat + " - " + hh + mm);
				return hh + mm;
			case "MMSS":
				log.info("time value in " + timeFormat + " - " + mm + ss);
				return mm + ss;
			case "HHMMSS":
				log.info("time value in " + timeFormat + " - " + hh + mm + ss);
				return hh + mm + ss;
			case "HH:MM":
				log.info("time value in " + timeFormat + " - " + hh + ":" + mm);
				return hh + ":" + mm;
			default:
				log.info("time value in " + timeFormat + " - " + hh + mm);
				return hh + mm;
			}
		} catch (Exception e) {
			log.error("Unable to convert time value - " + timeValue + " in " + timeFormat + " format. ", e);
			return null;
		}
	}

}
