package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import General.JSONFile_Mgmt;

public class Temp_Stats extends Filter{
	
	public Temp_Stats(JSONArray a) {
		super(a);
	}
	
	public void reader(int period) {
	
	}
	
	public double get_max() {
		return max;
	}
	
	public double get_min() {
		return min;
	}
	

	
}
