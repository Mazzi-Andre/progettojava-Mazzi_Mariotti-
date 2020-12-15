package General;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

	/**
	 * Classe di gestione lettura e scrittura file json.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */

public class JSONFile_Mgmt {
	private JSONObject Stats_data = new JSONObject ();
	private JSONArray meta_file = new JSONArray();
	
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
		
		try { 
		    ObjectInputStream file_input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("File.json")));

		    while(true) {
		    	meta_file.add((JSONObject) file_input.readObject());
		        
		     }
		    
		} catch(EOFException e) {
		       System.out.println("File finito");
		} catch (IOException e) {
		        e.printStackTrace();
		} catch (ClassNotFoundException e) {
		        e.printStackTrace();
		}
		
	}
	
	/**
	 * @return oggetto della statistica.
	 */
	
	/*public JSONObject getStatistica () {
		return Stats_data;
	}*/
	
	public JSONArray getArray () {
		return meta_file;
	}
	
}
