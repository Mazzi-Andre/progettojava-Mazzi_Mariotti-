package Stats_Filter;

import org.json.simple.JSONArray;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
	}
	
	@Override
	public JSONArray reader(int period) {
		
		Tot_hum_filter tot = new Tot_hum_filter (Stats_Array);
		tot.hum_tot (period);
		return tot.getTot_hum();
		
	}	
	
}
