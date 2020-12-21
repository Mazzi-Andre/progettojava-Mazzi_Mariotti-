package Stats_Filter;

import org.json.simple.JSONArray;

public abstract class Filter {
	
	protected JSONArray Stats_Array = new JSONArray();
	
	public Filter(JSONArray a) {
		Stats_Array = a;
	}
	
	public abstract JSONArray reader(int period);
	
	
}
