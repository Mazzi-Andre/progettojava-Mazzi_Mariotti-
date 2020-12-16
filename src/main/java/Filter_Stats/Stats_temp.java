package Filter_Stats;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import General.JSONFile_Mgmt;

public class Stats_temp extends Filter{
	
	public Stats_temp(JSONArray a) {
		super(a);
	}
	
	public void reader(int period) {
	JSONObject support_data = new JSONObject();
	support_data.put("re",Stats_Array.get(Stats_Array.size()-1));
	max=(double)support_data.get("Temperatura percepita");
	min=(double)support_data.get("Temperatura percepita");
	
		for (int i=Stats_Array.size()-2; i>Stats_Array.size()-period; i--) {
			JSONObject o=new JSONObject();
			o.put("re",Stats_Array.get(i));
			if (support_data.get("giorno") == o.get("giorno")) {
				if (support_data.get("mese") == o.get("mese")) {
					if (support_data.get("anno") == o.get("anno")) {
						continue; //A Manu gli puzza
					}
				}
			}
			if ((double) o.get("Temperatura percepita") > max) max=(double) o.get("Temperatura percepita");
			else if ((double) o.get("Temperatura percepita") < min) min= (double) o.get("Temperatura percepita");			
		}
	}
	
	public double get_max() {
		return max;
	}
	
	public double get_min() {
		return min;
	}
	

	
}
