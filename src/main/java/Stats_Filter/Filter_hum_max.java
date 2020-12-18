package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_max {
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	
	private long Max;
	private String City;
	
	public Filter_hum_max() {}
	
	public void hum_max(JSONArray A){
		try {
		this.meta = (JSONArray) A;
			
		Appoggio= (JSONObject)meta.get(meta.size()-1);
		
		Max = (long) Appoggio.get("Umidita");
		City = (String) Appoggio.get("Citta");

		
		for (int i=meta.size()-2; i>0 ; i--) {
			JSONObject o=new JSONObject();
			o = (JSONObject)meta.get(i);
			if ( Max <= (long) o.get("Umidita")) {
				Max = (long)o.get("Umidita");
				City = (String)o.get("Citta");
			}
		}
		System.out.println(Max);
		System.out.println(City);
		
	}
	catch (NullPointerException e) {
			System.out.println(e);
			System.out.println("errore null pointer Filter_hum_max");
		}
	catch (ClassCastException e) {
			System.out.println(e);
			System.out.println("errore class cast Filter_hum_max");
		}
	catch (Exception e) {
		System.out.println(e);
		System.out.println("errore generale Filter_hum_max");
	}
	
	}
	
	public String getCitta () {
		return City;
	}
	
	public long getMax () {
		return Max;
	}
}