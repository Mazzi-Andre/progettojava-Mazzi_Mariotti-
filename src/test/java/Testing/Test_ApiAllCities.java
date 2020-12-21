package Testing;

import General.API_allCities;
import junit.framework.*;
import net.minidev.json.JSONObject;


public class Test_ApiAllCities extends TestCase {
	
	private API_allCities a;
	
	public Test_ApiAllCities ( String name) {
		super (name);
	}
	
	public static Test suite () {
		TestSuite suite = new TestSuite();
		suite.addTest(new Test_ApiAllCities ("testgetValori"));
		return suite;
	}
	
	public void setUp () {
		a = new API_allCities ();
		a.Download_allCities();
	}
	
	public void tearDown () {}
	
	public void testgetValori () {
		assertNotNull ( "testgetValori", a.getValori());
	}
	
}
