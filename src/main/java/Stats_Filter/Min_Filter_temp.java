package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Min_Filter_temp {
	
	private JSONArray meta = new JSONArray();
	private int date[]= new int [3];
	
	private double Min;
	private String City;
	
	public Min_Filter_temp( JSONArray A ) {
		this.meta=A;
		JSONObject o = new JSONObject();
		o= (JSONObject) this.meta.get(0);
		Min= (double) o.get("Temperatura percepita");
		City= (String) o.get("Citta");
		date[0]= (int) o.get("anno");
		date[1]= (int) o.get("mese");
		date[2]= (int) o.get("giorno");
		for (int i=1; i<this.meta.size(); i++) {
			o=(JSONObject) this.meta.get(i);
			if (Min > (double) o.get("Temperatura percepita")) {
				Min=(double) o.get("Temperatura percepita");
				City= (String) o.get("Citta");
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
