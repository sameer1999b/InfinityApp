package iss.pos.test;
import junit.framework.TestCase;

import org.junit.Test;
import iss.pos.Product;
import iss.pos.POSProducts;


public class TestPOSProducts extends TestCase {
   
    @Test
  	public void testApplePrice() {
    	POSProducts myPOSProducts = new POSProducts();
    	Product apple = myPOSProducts.getListOfProducts().get("apple");
  		
  		assertEquals(10.0, apple.getPrice(), 0);
  	}
    
    @Test
  	public void testApplePenPrice() {
    	POSProducts myPOSProducts = new POSProducts();
    	Product applepen = myPOSProducts.getListOfProducts().get("applepen");
  		
  		assertEquals(15.0, applepen.getPrice(), 0);
  	}
    
    @Test
  	public void testPPAPPrice() {
    	POSProducts myPOSProducts = new POSProducts();
    	Product ppap = myPOSProducts.getListOfProducts().get("ppap");
  		
  		assertEquals(40.0, ppap.getPrice(), 0);
  	}

}
