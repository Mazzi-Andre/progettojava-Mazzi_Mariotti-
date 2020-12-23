package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


	/**
	 * Classe per la gestione del body utilizzata per le richieste POST.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class Body {
	
	private int period;
	private boolean hum;
	private boolean temp;
	private JSONArray a = new JSONArray();
	
	public Body(boolean voce1,boolean voce2, int period) {
		
		this.hum= voce1;
		this.temp= voce2;
		this.period= period;
		
		JSONObject obj = new JSONObject();
		obj.put("Default", "Nessuna statistica richiesta");
		a.add(obj);
		
	}
	
	/**
	 * @return JSOArray di default.
	 */

	public JSONArray getA() {
		return a;
	}
	
	/**
	 * @return rateo selezionato.
	 */

	public int getPeriod() {
		return period;
	}
	
	/**
	 * @return boolean azione richiesta umidità.
	 */

	public boolean isHum() {
		return hum;
	}
	
	/**
	 * @return boolean azione richiesta temperatura percepita.
	 */

	public boolean isTemp() {
		return temp;
	}

}
