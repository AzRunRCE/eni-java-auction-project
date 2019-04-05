package fr.eni.ecole.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	public static Timestamp getTimestamp(String dateString) throws ParseException {
		if (dateString == null)
			return null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'THH:mm");
		Date dateTime = format.parse(dateString);
		return new java.sql.Timestamp(dateTime.getTime());
	}
}
