package iss.pos;

import java.util.HashMap;

public class POSProducts{
	HashMap<String,Product> products = new HashMap<String, Product>();
	
	public POSProducts(){
		products.put("apple", new Product("0001", "Apple", 10.0));
		products.put("pen", new Product("0002", "Pen", 5.0));
		products.put("applepen", new Product("0003", "Apple Pen", 15.0));
		products.put("pineapple", new Product("0004", "Pineapple", 20.0));
		products.put("pineapplepen", new Product("0005", "Pineapple Pen", 25.0));
		products.put("ppap", new Product("0006", "Pen Pineapple Apple Pen", 40.0));
	}
	
	public HashMap<String,Product> getListOfProducts() {
		return products;
	}
	
}
