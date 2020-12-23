 package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

	/**
	 * Classe per la restituzione dei valori massimo e minimo della temperatura percepita nell'arco del periodo selezionato.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Tot_Filter_temp {
	
	private JSONArray meta = new JSONArray();
	private JSONArray tot_temp = new JSONArray();
	
	
	public Tot_Filter_temp ( JSONArray a ) {
		meta = a;
	}
	
	/**
	 * Metodo per la ricerca dei valori.
	 * @param period
	 */
	
	public void tot_temp (int period) {
		
		Max_Filter_temp M;
		Min_Filter_temp m;
		
		int time[] = new int [3];
		
		Date_Filter D = new Date_Filter ();
		
		JSONObject obj= new JSONObject();
		obj = (JSONObject) meta.get(meta.size()-1);
		M = new Max_Filter_temp ( (JSONArray) obj.get("citta"));
		m= new Min_Filter_temp ((JSONArray) obj.get("citta"));
		double max = M.getMax();
		String citta_max = M.getCitta();
		double min = m.getMin();
		String citta_min = m.getCitta();
		
		time[0] = m.getDate()[0];
		time[1] = m.getDate()[1];
		time[2] = m.getDate()[2];
		
		int i = meta.size()-2;
		int comp = 1;
		
		do {
			
			obj = (JSONObject) meta.get(i);
			m = new Min_Filter_temp ((JSONArray) obj.get("citta"));
			M = new Max_Filter_temp ((JSONArray) obj.get("citta"));
			
			if ( D.check(time, m.getDate()) ) {   
				if (max < M.getMax()) {
					max = M.getMax();
					citta_max = M.getCitta();
				}
				if (min > m.getMin()) {
					min = m.getMin();
					citta_min = m.getCitta();
				}
				
				comp++;
				
				time[0] = m.getDate()[0];
				time[1] = m.getDate()[1];
				time[2] = m.getDate()[2];
			}
			i--;			
			
		} while ( comp < period-1  || i<0 );
	
		JSONObject ar = new JSONObject();
		JSONObject ar2 = new JSONObject();
		ar.put("Citta", citta_max);
		ar.put("Temperatura massima", max);
		ar2.put("Citta", citta_min);
		ar2.put("Temperatura minima", min);
		tot_temp.add(ar);
		tot_temp.add(ar2);
		
	}
	
	/**
	 * @return JSONArray contenente i valori.
	 */
	
	public JSONArray getTot_temp () {
		return tot_temp;
	}	
	
}
