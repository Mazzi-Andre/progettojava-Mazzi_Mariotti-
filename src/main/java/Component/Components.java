package Component;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import General.*;

@Component
public class Components {
	
	
	
	/*@Autowired
	JSONFile_Mgmt Json_file;*/
	
	@Autowired
	API_allCities Json_file;
	
	@Scheduled(fixedDelay = 6000, initialDelay = 10000)
	public void avvioConIntervalloFissoTraEsecuzioni() {
		API_allCities j= new API_allCities();
	    j.Download_allCities();
	    System.out.println(j.getValori());
	    System.out.println("pausa finita");
	    
	}
	
	

}
