package com.sherpa.util;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Util {

	/*
	 * private final static DateTimeFormatter dtfDate =
	 * DateTimeFormat.forPattern(Constants.TIME_FORMAT_WITHOUT_TIME);
	 */

	private final static DateTimeFormatter dtfTime = DateTimeFormat.forPattern(Constants.TIME_FORMAT_WITH_TIME);

	public static String getDateString(DateTime date) {
		String dateString = dtfTime.print(date);
		return dateString;
	}

	public static DateTime getDateJoda(String dateString) {
		DateTime date = dtfTime.parseDateTime(dateString);
		return date;
	}

	/**
	 * Cast Hibernate Query Results From List (ArrayList) To Set (HashSet)
	 */
	public static <T> Set<T> castSet(Class<? extends T> clazz, Collection<?> collection) {
		Set<T> resultSet = new HashSet<T>(collection.size());
		for (Object object : collection)
			resultSet.add(clazz.cast(object));
		return resultSet;
	}

}
