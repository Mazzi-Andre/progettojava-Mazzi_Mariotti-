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
		API_allCities save = new API_allCities();
		save.Download_allCities();
		try {
			ObjectOutputStream file_output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("File.json",true))) {
				protected void writeStreamHeader() throws IOException {
				
					reset();
				}
			};
			file_output.writeObject(save.getValori());
			file_output.close();			
			} catch (IOException e) {
			e.printStackTrace();
		}
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
