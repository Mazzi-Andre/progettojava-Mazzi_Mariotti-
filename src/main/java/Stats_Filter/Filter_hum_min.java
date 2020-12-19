package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_min {
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	
	private long Min;
	private String City;
	private int date[];
	
	public Filter_hum_min() {
		Min=0;
		City=null;
	}
	
	public void hum_min(JSONArray A){
		
		this.meta = (JSONArray) A;
		
		Appoggio.put("Const", meta.get(meta.size()-1));
		
		JSONObject o = new JSONObject();
		o= (JSONObject) this.meta.get(0);
		Min= (long) o.get("Temperatura percepita");
		City= (String) o.get("Citta");
		
		System.out.println(Appoggio);
		Min = (int) Appoggio.get("Temperatura percepita");
		City = (String) Appoggio.get("Citta");
		date[0] = (int) Appoggio.get("giorno");
		date[1] = (int) Appoggio.get("mese");
		date[2] = (int) Appoggio.get("anno");
		
		for (int i=1; i<this.meta.size() ; i++) {
			o = (JSONObject) this.meta.get(i);
			if ( Min > (long) o.get("Umidità")) {
				Min = (long)o.get("Umidità");
				City = (String) o.get("Citta");
				
			}
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
