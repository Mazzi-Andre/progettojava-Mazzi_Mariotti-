package date_test;

import java.util.GregorianCalendar;

public class Date {
	
	private GregorianCalendar Current_date=new GregorianCalendar();
	
	private int Year = Current_date.get(GregorianCalendar.YEAR);
	private int Month = Current_date.get(GregorianCalendar.MONTH) + 1; //i mesi partono da 0
	private int Day = Current_date.get(GregorianCalendar.DATE);
	
	public Date() {
		Year = Current_date.get(GregorianCalendar.YEAR);
		Month = Current_date.get(GregorianCalendar.MONTH) + 1;
		Day = Current_date.get(GregorianCalendar.DATE);
		
	}
	
	public int getYear() {
		return Year;
	}
	
	public int getMonth() {
		return Month;
	}
	
	public int getDay() {
		return Day;
	}

}
