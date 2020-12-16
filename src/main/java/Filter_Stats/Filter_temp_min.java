package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Filter_temp_min {
	JSONArray meta = new JSONArray();
	JSONObject Appoggio = new JSONObject();
	JSONObject Final = new JSONObject();
	
	private double Min;
	private String City;
	
	public Filter_temp_min(JSONArray A) {
		this.meta = A;
		Appoggio.put("Const", meta.get(meta.size()-1));
	}
	
	public JSONObject temp_min(){
		
		Min = (double) Appoggio.get("Temperatura percepita");
		City = (String) Appoggio.get("Citta");
		
		for (int i=meta.size()-1; i>0 ;i--) {
			JSONObject o=new JSONObject();
			o.put("Const",meta.get(i));
			if ( Min > (double) o.get("Temperatura percepita")) {
				Min = (double)o.get("Temperatura percepita");
				City = (String)o.get("Citta");
			}
		}
		
		Appoggio.remove("Const");
		Appoggio.put("Citta", City);
		Appoggio.put("Temperatura", Min);
		
		Final.put("Temperatura minima",Appoggio);
		
		return Final;
	}

}
