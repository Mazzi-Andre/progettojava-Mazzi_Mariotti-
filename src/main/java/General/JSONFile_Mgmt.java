package General;
import org.json.simple.JSONObject;

	/**
	 * Classe di gestione lettura e scrittura file json.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class JSONFile_Mgmt {
	private JSONObject Stats_data = new JSONObject ();
	
	public JSONFile_Mgmt () {}
	
	/**
	 * Metodo per la scrittura della temperatura percepita e umidità di tutte le città su un unico file .json
	 */
	public void JsonFile_save () {
		//questa la richiamo quando scaricato con 
		//API_allCities e quindi avro JSONObject protected da usare qua per stampare!
	}
	
	/**
	 * Metodo per la lettura personalizzata in base alla statistica, del file .json  
	 */
	
	public void JsonFile_reader () {
		//lettura massimo
		//ci sarà oggetto di tipo Stats 
		//per dire queli "campi" del file
		
	}
	
	/**
	 * @return oggetto della statistica.
	 */
	
	public JSONObject getStatistica () {
		return Stats_data;
	}
	
}
