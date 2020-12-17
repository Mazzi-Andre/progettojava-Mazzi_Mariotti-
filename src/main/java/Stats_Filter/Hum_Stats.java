package Stats_Filter;

import org.json.simple.JSONArray;

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
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
