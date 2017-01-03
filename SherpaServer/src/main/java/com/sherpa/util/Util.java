package com.sherpa.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}

}
