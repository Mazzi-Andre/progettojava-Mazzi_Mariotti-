package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Min_Filter_temp {
	
	private JSONArray meta = new JSONArray();
	private JSONObject Appoggio = new JSONObject();
	private int date[];
	
	private double Min;
	private String City;
	
	public Min_Filter_temp(JSONArray A) {
		this.meta = A;
		Appoggio.put("Const", meta.get(meta.size()-1));
	}
	
	public void temp_min(){
		
		Min = (double) Appoggio.get("Temperatura percepita");
		City = (String) Appoggio.get("Citta");
		date[0] = (int) Appoggio.get("giorno");
		date[1] = (int) Appoggio.get("mese");
		date[2] = (int) Appoggio.get("anno");
		
		for (int i=meta.size()-1; i>0 ;i--) {
			JSONObject o=new JSONObject();
			o.put("Const",meta.get(i));
			if ( Min > (double) o.get("Temperatura percepita")) {
				Min = (double)o.get("Temperatura percepita");
				City = (String)o.get("Citta");
			}
		}
	}
	
	public String getCitta () {
		return City;
	}
	
	public double getMin () {
		return Min;
	}
	
	public int [] getDate () {
		return date;
	}

}
