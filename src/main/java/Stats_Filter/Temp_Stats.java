package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import General.JSONFile_Mgmt;

public class Temp_Stats extends Filter{
	
	public Temp_Stats(JSONArray a) { //che sarà metafile
		super(a);
	}
	
	public JSONArray reader(int period) {
		System.out.println(Stats_Array.size());
		Tot_Filter_temp tot = new Tot_Filter_temp (Stats_Array);
		tot.tot_temp(period);
		return tot.getTot_temp();
	
	}
	
}
