package Filter_Stats;

import org.json.simple.JSONArray;

import General.JSONFile_Mgmt;

public class Stats_temp extends Filter{
	
	public Stats_temp(JSONArray a) {
		super(a);
	}
	
	public void reader(int period) {
	JSONArray support_data = new JSONArray();
		
		for (int i=Stats_Array.size()-1; i>Stats_Array.size()-period; i--) {
			
		}
	}
	
	public double get_max() {
		return max;
	}
	
	public double get_min() {
		return min;
	}
	

	
}
