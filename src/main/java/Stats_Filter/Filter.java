package Stats_Filter;

import org.json.simple.JSONArray;

	/**
	 * Superclasse astratta per la gestione dei filtri.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public abstract class Filter {
	
	protected JSONArray Stats_Array = new JSONArray();
	
	public Filter(JSONArray a) {
		Stats_Array = a;
	}
	
	/**
	 * Metodo astratto per la lettura delle informazioni meteoreologiche in un rateo di tempo.
	 * @param period
	 */
	
	public abstract JSONArray reader(int period);
	
	
}
