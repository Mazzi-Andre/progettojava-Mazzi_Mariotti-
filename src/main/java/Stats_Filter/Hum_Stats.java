package Stats_Filter;

import org.json.simple.JSONArray;

import Stats_Filter.hum.Filter_hum_total;

//import Filter_hum.Filter_hum_total;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
	}
	/*
	public JSONArray reader(int period) {
		
		Filter_hum_total tot = new Filter_hum_total (Stats_Array);
		//System.out.println(Stats_Array);
		tot.hum_tot (period);
		return tot.getTot_hum();
	}*/
	
	@Override
	public JSONArray reader_temp(int period) {
		
		Tot_Filter_temp tot = new Tot_Filter_temp (Stats_Array);
		tot.tot_temp(period);
		return tot.getTot_temp();
	
	}
	
	@Override
	public JSONArray reader_hum(int period) {
		
		Tot_Filter_temp tot = new Tot_Filter_temp (Stats_Array);
		tot.tot_temp(period);
		return tot.getTot_temp();
	
	}
}
