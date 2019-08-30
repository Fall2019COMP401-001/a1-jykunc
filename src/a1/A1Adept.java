package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Determine how many items to consider
		int numberOfItems = scan.nextInt();
		
		// Create an array storing the store item prices as doubles
		double storeItems[] = new double[numberOfItems];
		
		// Create an array storing the store item names
		String itemNames[] = new String[numberOfItems];
		
		// Adds items into array based on numberOfItems
		for (int c = 0; c < numberOfItems; c++) {
			itemNames[c] = scan.next();
			storeItems[c] = scan.nextDouble();
		}
		
		// Initialize the variables for considering the max and min customers
		String maxFirstName = "None";
		String minFirstName = "None";
		String maxLastName = "Available";
		String minLastName = "Available";
		double currentMaxPrice = 0.0;
		double currentMinPrice = 0.0;
		
		// Determine total number of customers
		int numberCustomers = scan.nextInt();
		
		// Initialize variable for the expenditures of all customers for avg calculation
		double customerTotals = 0;
		
		// For loop run once per customer
		for (int e = 0; e < numberCustomers; e++) {
			// Assign customer name
			String firstName = scan.next();
			String lastName = scan.next();
			
			// Determine number of items per customer
			int itemsBought = scan.nextInt();
			
			// Initialize variable for the total price for an individual customer
			double totalPrice = 0.0;
			
			// For loop run for each item by a customer
			for (int f = itemsBought; f > 0; f--) {
				// Determine the number of items and the item name
				int numItemsBought = scan.nextInt();
				String productName = scan.next();
				
				// Use the returnPrice method to return the price of the item named
				double price = returnPrice(productName, storeItems, itemNames);
				
				// Add the cost (item cost and how many were purchased) to the customer's total price
				totalPrice += numItemsBought * price;
			}
			
			// Add the customer's total price to the total expenditures of all customers
			customerTotals += totalPrice;
			
			// Set the first iteration of a customer to be the minimum price so that it's not 0
			if (e == 0) {
				currentMinPrice = totalPrice;
				minFirstName = firstName;
				minLastName = lastName;
			}
			
			// Set customer as max if that's true
			if (totalPrice > currentMaxPrice) {
				currentMaxPrice = totalPrice;
				maxFirstName = firstName;
				maxLastName = lastName;
			} 
			
			// Set customer as min if that's true
			if (totalPrice < currentMinPrice) {
				currentMinPrice = totalPrice;
				minFirstName = firstName;
				minLastName = lastName;
			}
		}
		
		// Find the average cost per customer
		double average = customerTotals / numberCustomers;
		
		// Spit everything out
		System.out.println("Biggest: " + maxFirstName + " " + maxLastName + " (" + String.format("%.2f", currentMaxPrice) + ")");
		System.out.println("Smallest: " + minFirstName + " " + minLastName + " (" + String.format("%.2f", currentMinPrice) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		scan.close();
	}
	
	// Takes in a string item and returns the stored price
	public static double returnPrice(String productName, double[] storeItems, String[] itemNames) {
		int index;
		
		// Searches through arrays and, if there's a match, returns the array index of the item prices
		for (int k = 0; k < itemNames.length; k++) {
			if (productName.equals(itemNames[k])) {
				index = k;
				return storeItems[index];
			}
		}
		return 0.0;
	}
}