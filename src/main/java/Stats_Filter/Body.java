package Stats_Filter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Body {
	
	private int period;
	private boolean hum;
	private boolean temp;
	private JSONArray a = new JSONArray();
	private JSONObject obj = new JSONObject();
	
	public Body(boolean voce1,boolean voce2, int period) {
		this.hum= voce1;
		this.temp= voce2;
		this.period= period;
		
		obj.put("default", "nessun valore inserito, oppure filtro sbagliato");
		a.add(obj);
		
	}

	public JSONArray getA() {
		return a;
	}

	public int getPeriod() {
		return period;
	}

	public boolean isHum() {
		return hum;
	}

	public boolean isTemp() {
		return temp;
	}

}
