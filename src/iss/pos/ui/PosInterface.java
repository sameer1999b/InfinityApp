package iss.pos.ui;

import iss.pos.POSProducts;
import iss.pos.Product;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class PosInterface {
	private static final POSProducts posProducts = new POSProducts();

	public static void main(String args[]) {
		do {
			System.out
					.println("Select Your Menu:\n 1-Product catalog\n 2-Search product\n 3-Add product");
			System.out.print("Enter your choice: ");

			Scanner sc = new Scanner(System.in);
			final String choice = sc.next();
			if (choice.length() == 1) {
				switch (choice.toCharArray()[0]) {
				case '1':
					displayProductCatalog();
					break;
				case '2':
					searchProduct();

					break;
				case '3':
					addProduct();
					break;
				default:
					System.out.println("choice not found");
					break;
				}
			} else {
				System.out.println("Enter invalid choice!\n");
			}
		} while (true);

	}

	private static void searchProduct() {
		displaySeperator();
		System.out.println("Please enter the product brand");
		Scanner sc = new Scanner(System.in);
		final String brandName = sc.next();

		HashMap<String, Product> productCatalog = posProducts
				.getListOfProducts();
		Product retrievedProduct = productCatalog.get(brandName);
		if (retrievedProduct != null) {
			displaySeperator();
			System.out.println("Product sku\tProduct Name\tPrice");
			displaySeperator();
			System.out.println(retrievedProduct.toString());

		} else {
			System.out
					.println("No products available for this brand. Please try again");

		}
		displaySeperator();

	}

	private static void displayProductCatalog() {
		displaySeperator();
		System.out.println("Product sku\t\tProduct Name\t\tPrice");
		displaySeperator();

		HashMap<String, Product> productCatalog = posProducts
				.getListOfProducts();

		for (String key : productCatalog.keySet()) {
			System.out.println(productCatalog.get(key));

		}

	}

	private static void addProduct2() {
		System.out.println("Enter product details");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter brand name:");
		final String brandName = sc.next();
		System.out.println("Enter product sku");

		final String sku = sc.next();
		System.out.println("Enter product name");
		final String name = sc.next();
		boolean isPriceValid = false;
		double price = 0;
		do {
			try {
				System.out.println("Enter product price");
				price = sc.nextDouble();
				isPriceValid = true;
			} catch (Exception e) {
				isPriceValid = false;
			}
		} while (!isPriceValid);
		Product product = new Product(sku, name, price);
		posProducts.addProduct(brandName, product);
	}
	
	private static void addProduct(){
		boolean retry = false;
		do{
			try{
				System.out.println("Enter product details");
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter brand name:");
				final String brandName = sc.next();
				
				System.out.println("Enter product sku");
				final String sku = sc.next();
				
				System.out.println("Enter product name");
				final String name = sc.next();
				
				double price = 0;
				System.out.println("Enter product price");
				price = sc.nextDouble();
				
				Product product = new Product(sku, name, price);
				posProducts.addProduct(brandName, product);
				System.out.println("Product is added.\n");
			}catch(Exception ex){
				System.out.println("Invalid input, please retry");
				retry = true;
			}
		}while(retry);
	}
	

	private static void displaySeperator() {
		System.out.println(new String(new char[80]).replace("\0", "="));
	}

}
