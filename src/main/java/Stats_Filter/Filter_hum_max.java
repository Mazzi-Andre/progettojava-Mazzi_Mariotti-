package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_hum_max {
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	
	private int Max;
	private String City;
	private int giorno;
	private int mese;
	private int anno;
	
	public Filter_hum_max() {}
	
	public void hum_max(JSONArray A){
		this.meta = A;
		Appoggio.put("Const", meta.get(meta.size()-1));
		
		Max = (int) Appoggio.get("Temperatura percepita");
		City = (String) Appoggio.get("Citta");
		giorno=(int) Appoggio.get("giorno");
		mese=(int) Appoggio.get("mese");
		anno=(int) Appoggio.get("anno");
		
		for (int i=meta.size()-1; i>0 ;i--) {
			JSONObject o=new JSONObject();
			o.put("Const",meta.get(i));
			if ( Max < (int) o.get("Umidità")) {
				Max = (int)o.get("Umidità");
				City = (String)o.get("Citta");
			}
		}
	
	}
	
	public String getCitta () {
		return City;
	}
	
	public int getMax () {
		return Max;
	}
}