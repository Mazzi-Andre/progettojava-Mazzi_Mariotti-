package Stats_Filter;

import org.json.simple.JSONArray;

import Stats_Filter.hum.Filter_hum_total;
import Stats_Filter.temp.Tot_Filter_temp;

//import Filter_hum.Filter_hum_total;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
	}
	
	@Override
	public JSONArray reader(int period) {
		
		Filter_hum_total tot = new Filter_hum_total (Stats_Array);
		//System.out.println(Stats_Array);
		tot.hum_tot (period);
		return tot.getTot_hum();
	}
	
	
}
