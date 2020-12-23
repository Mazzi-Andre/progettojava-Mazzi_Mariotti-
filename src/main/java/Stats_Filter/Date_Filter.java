package Stats_Filter;

	/**
	 * Classe per il confronto di date di un JSONArray.
	 * @author Manuel Mariotti
	 * @author Andrè Mazzi
	 */


public class Date_Filter {
	
	public Date_Filter () {}
	
	/**
	 * Metodo che resituisce un boolean a seguito del confronto.
	 * @param o1
	 * @param o
	 * @return true se dal confronto le date sono diverse; false altrimenti.
	 */
	
	public boolean check (int o1[], int o []) {   
			
		if (o1[0]==o[0] && o1[1]==o[1] && o1[2]==o[2]) return false;		
		else return true;
	}
}
