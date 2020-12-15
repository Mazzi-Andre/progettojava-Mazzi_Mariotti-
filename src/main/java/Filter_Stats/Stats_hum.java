package Filter_Stats;

import General.JSONFile_Mgmt;

public class Stats_hum extends Filter {
	
	public Stats_hum(JSONArray a) {
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
