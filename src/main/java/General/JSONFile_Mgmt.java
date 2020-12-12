package General;
import org.json.simple.JSONObject;

public class JSONFile_Mgmt {
	private JSONObject Stats_data = new JSONObject ();
	
	public JSONFile_Mgmt () {}
	
	public void JsonFile_save () {
		//questa la richiamo quando scaricato con 
		//API_allCities e quindi avro JSONObject protected da usare qua per stampare!
	}
	
	public JSONObject JsonFile_reader () {
		//lettura massimo
		//ci sarà oggetto di tipo Stats 
		//per dire queli "campi" del file
		return Stats_data;
	}
	
}
