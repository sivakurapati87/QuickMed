package com.intuiture.qm.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Example {
	public static void main(String[] args) {
//		long min = getTimeInMilliSeconds("9:00");
//		long max = getTimeInMilliSeconds("21:15");
//		System.out.println("Min : " + min + "\n" + "Max : " + max);
		Double d=12321432432.32432432d;
		System.out.println(d.longValue());
	}

	public static long getTimeInMilliSeconds(final String timestamp) {
		long milliseconds = 0;

		final DateFormat dt = new SimpleDateFormat("HH:mm");
		dt.setLenient(false);
		if (timestamp != null) {
			try {
				final long timezoneOffset = dt.parse("00:00").getTime();
				milliseconds += (dt.parse(timestamp).getTime() - timezoneOffset);
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
		return milliseconds;
	}
}
