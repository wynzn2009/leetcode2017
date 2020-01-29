/**
 * 
 */
package com.prisbox.one;

/**
 * @author LO
 *
 */
public class DayoftheWeek1185 {
	public static String dayOfTheWeek(int day, int month, int year) {
		int s = 4;
		String[] nam = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		int[] m = { 0, 31, 31 + 28, 31 + 28 + 31, 31 + 28 + 31 + 30, 31 + 28 + 31 + 30 + 31,
				31 + 28 + 31 + 30 + 31 + 30, 31 + 28 + 31 + 30 + 31 + 30 + 31,
				31 + 28 + 31 + 30 + 31 + 30 + 31 + 31, 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30,
				31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31,
				31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30,
				31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + 31 };
		int sum = day + m[month - 1] + 365 * (year - 1970) + (year - 1968) / 4
				+ (year % 4 == 0 && (month <= 2) ? -1 : 0);
		return nam[(sum + 7 - s) % 7];

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DayoftheWeek1185.dayOfTheWeek(1, 2, 2014);
	}

}
