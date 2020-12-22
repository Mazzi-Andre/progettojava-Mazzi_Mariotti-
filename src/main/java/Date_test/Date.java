package Date_test;

import java.util.GregorianCalendar;
	/**
	 * Classe acquisizione data attuale.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */
public class Date {
	
	private GregorianCalendar Current_date=new GregorianCalendar();
	
	private int Year = Current_date.get(GregorianCalendar.YEAR);
	private int Month = Current_date.get(GregorianCalendar.MONTH) + 1; 
	private int Day = Current_date.get(GregorianCalendar.DATE);
	
	public Date() {
		Year = Current_date.get(GregorianCalendar.YEAR);
		Month = Current_date.get(GregorianCalendar.MONTH) + 1;
		Day = Current_date.get(GregorianCalendar.DATE);
		
	}
	
	/**
	 * @return Anno.
	 */
	
	public int getYear() {
		return Year;
	}
	
	/**
	 * @return Mese
	 */
	
	public int getMonth() {
		return Month;
	}
	
	/**
	 * @return Giorno.
	 */
	
	public int getDay() {
		return Day;
	}

}
