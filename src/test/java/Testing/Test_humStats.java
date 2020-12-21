package Testing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import General.JSONFile_Mgmt;
import Stats_Filter.Filter_hum_total;
import Stats_Filter.Hum_Stats;
import Stats_Filter.Temp_Stats;
import Stats_Filter.Tot_Filter_temp;
import junit.framework.*;

public class Test_humStats extends TestCase {
	
	private Hum_Stats s;	
	
	public Test_humStats (String name) {
		super (name);
	}
	
	public static Test suite () {
		TestSuite suite = new TestSuite();
		suite.addTest(new Test_tempStats ("testReader"));
		return suite;
	}
	
	public void setUp () {
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		stats.JsonFile_reader();
		s= new Hum_Stats(stats.getArray());
		Filter_hum_total tot = new Filter_hum_total (stats.getArray());
		tot.hum_tot(2);
	}
	
	public void tearDown () {}
	
	public void testReader () {	
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		stats.JsonFile_reader();
		s= new Hum_Stats(stats.getArray());
		Filter_hum_total tot = new Filter_hum_total (stats.getArray());
		tot.hum_tot(2);
		assertEquals( s.reader(2) , tot.getTot_hum());
	}
}
