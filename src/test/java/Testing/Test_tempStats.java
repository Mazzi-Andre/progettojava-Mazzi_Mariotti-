package Testing;

import General.JSONFile_Mgmt;
import Stats_Filter.Temp_Stats;
import Stats_Filter.Tot_Filter_temp;
import junit.framework.*;

public class Test_tempStats extends TestCase {
	
	private Temp_Stats s;
	
	public Test_tempStats (String name ) {
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
		s= new Temp_Stats(stats.getArray());
	}
	
	public void tearDown () {}
	
	public void testReader () {	
		JSONFile_Mgmt stats =new JSONFile_Mgmt();
		stats.JsonFile_reader();
		Tot_Filter_temp tot = new Tot_Filter_temp (stats.getArray());
		tot.tot_temp(2);
		assertEquals( s.reader(2) , tot.getTot_temp());
	}
	
}
