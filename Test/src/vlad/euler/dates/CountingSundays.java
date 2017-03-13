package vlad.euler.dates;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CountingSundays {

	/**
	 * You are given the following information, but you may prefer to do some research for yourself.

1 Jan 1900 was a Monday.
Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.
A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

1 Jan 1901 was a Tuesday - 365 days % 7 = 1
2 Wed
3 Thu
4 Fri
5 Sat
6 Jan 1901 was the first Sunday

	 * @param args
	 */
	
	public static void main(String[] args) {
		
		int countSundays = 0;
		
		GregorianCalendar cal = new GregorianCalendar(1901, 1, 1);
		GregorianCalendar end_date = new GregorianCalendar(2000, 12, 31);
		while(cal.before(end_date)) {
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				countSundays++;
			}
			cal.add(Calendar.MONTH, 1);
		}
		
		System.out.println(countSundays);
		
	}

	public static int[] days_in_month = {/*Jan*/31,/*Feb*/28,/*Mar*/31,/*Apr*/30,/*May*/31,/*Jun*/30,
			/*Jul*/31,/*Aug*/31,/*Sep*/30,/*Oct*/31,/*Nov*/30,/*Dec*/31};
	
}
