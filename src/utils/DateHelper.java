package utils;

import java.util.HashMap;

public class DateHelper {
	private static HashMap<Month, Integer> getDaysPerMonth(boolean isBiscest) {
		HashMap<Month, Integer> daysPerMonth = new HashMap<>();
		
		int feb = 28;
		if (isBiscest) feb++;
		
		daysPerMonth.put(Month.January, 31);
		daysPerMonth.put(Month.February, feb);
		daysPerMonth.put(Month.March, 31);
		daysPerMonth.put(Month.April, 30);
		daysPerMonth.put(Month.May, 31);
		daysPerMonth.put(Month.June, 30);
		daysPerMonth.put(Month.July, 31);
		daysPerMonth.put(Month.August, 31);
		daysPerMonth.put(Month.September, 30);
		daysPerMonth.put(Month.Octuber, 31);
		daysPerMonth.put(Month.November, 30);
		daysPerMonth.put(Month.December, 31);
		
		return daysPerMonth;
	}
	
	public static boolean isBiscest(int year) {
		boolean result = year % 4 == 0;
		
		if (year % 100 == 0 && result) {
			result = year % 400 == 0;
		}
		
		return result;
	}
	
	public static int getDaysFor(Month m, boolean isBiscest) {
		return getDaysPerMonth(isBiscest).get(m);
	}
	
	public static int getDaysFor(Month m) {
		return getDaysPerMonth(false).get(m);
	}
	
	public static int getDaysFor(Month m, int year) {
		return getDaysPerMonth(isBiscest(year)).get(m);
	}
}
