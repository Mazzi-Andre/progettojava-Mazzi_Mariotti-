package Filter_Stats;

import org.json.simple.JSONArray;

public abstract class Filter {
	
	protected JSONArray Stats_Array = new JSONArray();
	protected double max;
	protected double min;
	
	public Filter(JSONArray a) {
		Stats_Array = a;
		max=0;
		min=0;
	}
	
	public abstract void reader(int period);
	public abstract double get_min();
	public abstract double get_max();
	
	
}
