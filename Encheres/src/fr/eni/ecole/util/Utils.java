package fr.eni.ecole.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Utils {
	public static Timestamp getTimestamp(LocalDateTime localDateTime) throws ParseException {
		if (localDateTime == null)
			return null;
		Timestamp timestamp = Timestamp.valueOf(localDateTime);
		return timestamp;
	}
	
	public static LocalDateTime parseDateTime(String str)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
		return dateTime;
	}	
}
