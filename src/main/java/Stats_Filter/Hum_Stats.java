package Stats_Filter;

import org.json.simple.JSONArray;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
	}
	
	public JSONArray reader(int period) {
		
		Filter_hum_total tot = new Filter_hum_total ();
		//System.out.println(Stats_Array);
		tot.hum(Stats_Array, period);
		return tot.getTot_hum();
	}
}
