package Filter_Stats;

import org.json.simple.JSONArray;

import General.JSONFile_Mgmt;

public class Stats_temp extends Filter{
	
	public Stats_temp(JSONArray a) {
		super(a);
		//this.Stats_Array = a;
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
