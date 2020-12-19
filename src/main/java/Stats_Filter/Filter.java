package Stats_Filter;

import org.json.simple.JSONArray;

public abstract class Filter {
	
	protected JSONArray Stats_Array = new JSONArray();
	protected double max;
	protected double min;
	protected String max_city;
	protected String min_city;
	
	public Filter(JSONArray a) {
		Stats_Array = a;
		max=0;
		min=0;
		max_city=null;
		min_city=null;
	}
	
	public abstract JSONArray reader(int period);
	
	
}
