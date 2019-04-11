package fr.eni.ecole.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
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

	public static boolean  executeDBScripts(String aSQLScriptFilePath, Statement stmt) throws IOException,SQLException {
		boolean isScriptExecuted = false;
		try {
			BufferedReader in = new BufferedReader(new FileReader(aSQLScriptFilePath));
			String str;
			StringBuffer sb = new StringBuffer();
			while ((str = in.readLine()) != null) {
				sb.append(str + "\n ");
			}
			in.close();
			stmt.executeUpdate(sb.toString().replace("DB_ENCHERES", "DB_ENCHERES_UnitTests"));
			isScriptExecuted = true;
		} catch (Exception e) {
			System.err.println("Failed to Execute" + aSQLScriptFilePath +". The error is"+ e.getMessage());
		} 
		return isScriptExecuted;
		}
}
