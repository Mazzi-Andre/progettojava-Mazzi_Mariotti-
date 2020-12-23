package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import General.JSONFile_Mgmt;

	/**
	 * Sottoclasse che estende Filter per la gestione della statstica relativa alla temperatura percepita.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Temp_Stats extends Filter{
		
	
	public Temp_Stats(JSONArray a) {
		super(a);
	}
	
	/**
	 * Overriding del metodo reader della superclasse Filter.
	 */
	
	@Override
	public JSONArray reader (int period) {
		
		Tot_Filter_temp tot = new Tot_Filter_temp (Stats_Array);
		tot.tot_temp(period);
		return tot.getTot_temp();
	
	}
	
}
