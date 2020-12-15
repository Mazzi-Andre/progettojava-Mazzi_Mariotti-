package Filter_Stats;

import org.json.simple.JSONArray;

import General.JSONFile_Mgmt;

public class Stats_temp extends Filter{
	
	public Stats_temp(JSONArray a) {
		super(a);
	}
	
	public void reader(int period) {
		int k =0;
		for(int i=period; i>0 ; i-- ) {
			Stats_Array.get((Stats_Array.size()-1)-k);
			
			k++;
		}
	}
	
	public double get_max() {
		return max;
	}
	
	public double get_min() {
		return min;
	}
	

	
}
