package iss.pos.ui;

import iss.pos.POSProducts;
import iss.pos.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;


public class PosInterface {

	private static final int SELECT_PRODUCT_CATALOG = 1;
	private static final int SELECT_SEARCH_PRODUCT = 2;

	public static void main(String args[]) {
		do{
		System.out
				.println("Select Your Menu:\n 1-Product catalog\n 2-Search product");
		System.out.print("Enter your choice: ");

			Scanner sc = new Scanner(System.in);
			final int choice = sc.nextInt();
			switch (choice) {
			case SELECT_PRODUCT_CATALOG:
				displayProductCatalog();
				break;
			case SELECT_SEARCH_PRODUCT:
				searchProduct();
				break;
			}
			System.out.println("\n");
		}while(true);

	}

	private static void searchProduct() {
		displaySeperator();
		System.out.println("Please enter the product brand");
		Scanner sc = new Scanner(System.in);
		final String brandName = sc.next();
		
		POSProducts posProducts = new POSProducts();

		HashMap<String, Product> productCatalog = posProducts
				.getListOfProducts();
		Product retrievedProduct = productCatalog.get(brandName);
		if (retrievedProduct != null) {
			displaySeperator();
			System.out.println("Product sku\tProduct Name\tPrice");
			displaySeperator();
			System.out.println(retrievedProduct.toString());

		} else {
			System.out.println("Invalid product sku. Please try again");

		}
		displaySeperator();

	}

	private static void displayProductCatalog() {
		displaySeperator();
		System.out.println("Product sku\t\tProduct Name\t\tPrice");
		displaySeperator();
		POSProducts posProducts = new POSProducts();

		HashMap<String, Product> productCatalog = posProducts
				.getListOfProducts();

		for (String key : productCatalog.keySet()) {
			System.out.println(productCatalog.get(key));

		}

	}

	private static void displaySeperator() {
		System.out.println(new String(new char[80]).replace("\0", "="));
	}

}
