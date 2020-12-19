package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_min {
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	
	private long Min;
	private String City;
	private int date[]= {0,0,0};
	
	public Filter_hum_min() {}
	
	public void hum_min(JSONArray A){
		try {
		this.meta = (JSONArray) A;
		System.out.println("auto");
		System.out.println(A);
		
		Appoggio= (JSONObject)meta.get(meta.size()-1);
		Min = (long) Appoggio.get("Umidita");
		City = (String) Appoggio.get("Citta");
		
		
		date[0] = (int) Appoggio.get("giorno");
		date[1] = (int) Appoggio.get("mese");
		date[2] = (int) Appoggio.get("anno"); 
		
		for (int i=(meta.size()-2); i>0 ;i--) {
			JSONObject o=new JSONObject();
			o = (JSONObject)meta.get(i);
			if ( Min >= (long) o.get("Umidita")) {
				Min = (long)o.get("Umidita");
				City = (String) o.get("Citta");
				
				}
		}
		System.out.println(Min);
		System.out.println(City);
	}
	catch (NullPointerException e) {
			System.out.println(e);
			System.out.println("errore null pointer Filter_hum_min");
		}
	catch (ClassCastException e) {
			System.out.println(e);
			System.out.println("errore class cast Filter_hum_min");
		}
	catch (Exception e) {
		System.out.println(e);
		System.out.println("errore generale Filter_hum_min");
	}
		
	}
	
	public String getCitta () {
		return City;
	}
	
	public long getMin () {
		return Min;
	}
	
	public int[] getDate() {
		return date;
	}
}
