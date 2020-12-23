package Stats_Filter;

import org.json.simple.JSONArray;

	/**
	 * Sottoclasse che estende Filter per la gestione della statstica relativa all'umidità.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Hum_Stats extends Filter {
	
	public Hum_Stats(JSONArray a) {
		super(a);
	}
	
	/**
	 * Overriding del metodo reader della superclasse Filter.
	 */
	
	@Override
	public JSONArray reader(int period) {
		
		Tot_hum_filter tot = new Tot_hum_filter (Stats_Array);
		tot.hum_tot (period);
		return tot.getTot_hum();
		
	}	
	
}
