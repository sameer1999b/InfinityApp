package iss.pos.test;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {
	
	public static Test suite() {
		TestSuite suite = new TestSuite("All Tests");
		System.out.println("All Tests");
		//$JUnit-BEGIN$
		suite.addTestSuite(TestPOSProducts.class);
		//$JUnit-END$
		return suite;
	}

}
