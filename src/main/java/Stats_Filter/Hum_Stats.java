package Stats_Filter;

import org.json.simple.JSONArray;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
		
	}
	
	public JSONArray reader(int period) {
		
		Filter_hum_total tot = new Filter_hum_total (Stats_Array);
		tot.tot_temp(period);
		return tot.getTot_temp();
	}
}
