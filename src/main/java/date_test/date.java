package date_test;

import java.util.GregorianCalendar;

public class date {
	
	private GregorianCalendar dataAttuale=new GregorianCalendar();
	
	protected int anno = dataAttuale.get(GregorianCalendar.YEAR);
	protected int mese = dataAttuale.get(GregorianCalendar.MONTH) + 1; //i mesi partono da 0
	protected int giorno = dataAttuale.get(GregorianCalendar.DATE);
	protected int ore = dataAttuale.get(GregorianCalendar.HOUR);
	protected int minuti = dataAttuale.get(GregorianCalendar.MINUTE);
	protected int secondi = dataAttuale.get(GregorianCalendar.SECOND);
	
	public date() {
		anno = dataAttuale.get(GregorianCalendar.YEAR);
		mese = dataAttuale.get(GregorianCalendar.MONTH) + 1;
		giorno = dataAttuale.get(GregorianCalendar.DATE);
		
	}
	
	public int getanno() {
		return anno;
	}
	
	public int getmese() {
		return mese;
	}
	
	public int getgiorno() {
		return giorno;
	}

}
