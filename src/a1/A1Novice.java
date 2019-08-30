package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Determines the number of customers
		int numberCustomers = scan.nextInt();
		
		// For loop for each customer
		for (int c = 0; c < numberCustomers; c++) {
				
			// Begin collecting parsed integers into variables
			char firstInitial = scan.next().charAt(0);
			String lastName = scan.next();
			int totalItems = scan.nextInt();
			
			// Initialize variable for price per customer
			double totalPrice = 0.0;
			
			// For loop for each item
			for (int d = totalItems; d > 0; d--) {
				
				// Determine the number of items bought
				int numberOfItems = scan.nextInt();
				
				// Unused variable
				String itemName = scan.next();
				
				// Takes the itemPrice and adds it to the customer's total price
				double itemPrice = scan.nextDouble();
				totalPrice += numberOfItems * itemPrice;
			}
			
			// Prints out per each customer (still within for loop)
			System.out.println(firstInitial + ". " + lastName + ": " + String.format("%.2f", totalPrice));
		}
		
		scan.close();
	}
}