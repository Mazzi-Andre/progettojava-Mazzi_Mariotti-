package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_min {
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	
	private int Min;
	private String City;
	private int date[];
	
	public Filter_hum_min() {}
	
	public void hum_min(JSONArray A){
		try {
		this.meta = (JSONArray) A;
		
		Appoggio= (JSONObject)meta.get(meta.size()-1);
		System.out.println(Appoggio);
		Min = (int) Appoggio.get("Temperatura percepita");
		City = (String) Appoggio.get("Citta");
		date[0] = (int) Appoggio.get("giorno");
		date[1] = (int) Appoggio.get("mese");
		date[2] = (int) Appoggio.get("anno");
		
		for (int i=meta.size()-2; i>0 ;i--) {
			JSONObject o=new JSONObject();
			o.put("Const",meta.get(i));
			if ( Min > (int) o.get("Umidità")) {
				Min = (int)o.get("Umidità");
				City = (String) o.get("Citta");
				
				}
		}
	}
	catch (Exception e) {
	System.out.println(e);
	}
		
	}
	
	public String getCitta () {
		return City;
	}
	
	public int getMin () {
		return Min;
	}
	
	public int[] getDate() {
		return date;
	}
}
