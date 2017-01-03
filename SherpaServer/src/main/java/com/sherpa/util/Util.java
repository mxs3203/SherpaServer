package com.sherpa.util;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Util {

	/*
	 * private final static DateTimeFormatter dtfDate =
	 * DateTimeFormat.forPattern(Constants.TIME_FORMAT_WITHOUT_TIME);
	 */

	private final static DateTimeFormatter dtfTime = DateTimeFormat.forPattern(Constants.TIME_FORMAT_WITH_TIME);

	public Util() {

	}

	public static String getDateString(DateTime date) {
		String dateString = dtfTime.print(date);
		return dateString;
	}

	public static DateTime getDateJoda(String dateString) {
		DateTime date = dtfTime.parseDateTime(dateString);
		return date;
	}

}
