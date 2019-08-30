package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Creating appropriate arrays
		int numOfItems = scan.nextInt();
		
		// Item names
		String items[];
		items = new String[numOfItems];
		
		// Number of items sold
		int buyCount[];
		buyCount = new int[numOfItems];
		
		// Number of customers bought
		int custCount[];
		custCount = new int[numOfItems];
		
		// Parsing store inventory
		
		for (int i = numOfItems; i > 0; i--) {
			String itemName = scan.next();
			inventory(itemName, items);
			double itemPrice = scan.nextDouble();
		}
		
		// Parsing customer data
		int numCustomers = scan.nextInt();
		
		for (int i = numCustomers; i > 0; i--) {
			// Parsing per customer data
			String firstName = scan.next();
			String lastName = scan.next();
			int customerItems = scan.nextInt();
			
			/* Creating an array initialized for each customer
			to see if if's a unique item or already accounted
			for */
			String[] uniqueItem;
			uniqueItem = new String[customerItems];
			for (int c = customerItems; c > 0; c--) {
				int numItems = scan.nextInt();
				String customerItem = scan.next();
				
				// Adding to arrays - uses the isUnique method to decide which method of adding to use
				if (isUnique(customerItem, uniqueItem) == true) {
					inventory(customerItem, uniqueItem);
					addUnique(numItems, customerItem, buyCount, items, custCount);
					
				} else {
					addSame(numItems, customerItem, buyCount, items);
				}
				
			}
		}
		// Printing out result
		for (int f = 0; f < items.length; f++) {
			if (buyCount[f] == 0) {
				System.out.println("No customers bought " + items[f]);
			} else {
				System.out.println(custCount[f] + " customers bought " + buyCount[f] + " " + items[f]);
			}
		}
		scan.close();
		
	}
	
	// Method for adding items to an array in order
	public static void inventory(String name, String[] array1) {
		
		// Adds input to the next available spot in the specified array
		for (int i = 0; i < array1.length; i++) {
			if (array1[i] == null) {
				array1[i] = name;
				break;
			}
		}
	}
	
	// Method for accounting number of items bought if item is not unique to customer
	public static void addSame(int num, String name, int[] array1, String[] array2) {
		
		// Adds count to the appropriate array index
		for (int i = 0; i < array1.length; i++) {
			if (name.equals(array2[i])) {
				array1[i] = array1[i] + num;
			}
		}
	}
	
	// Method for accounting number of items bought if item is unique to customer
	public static void addUnique(int num, String name, int[] array1, String[] array2, int[] array3) {
		
		// Adds count to the appropriate array index
		for (int i = 0; i < array1.length; i++) {
			if (name.equals(array2[i])) {
				array1[i] = array1[i] + num;
				array3[i] = array3[i] + 1;
			}
		}
	}
	
	// Method to see if item is unique from a customer
	public static boolean isUnique(String name, String[] array1) {
		
		// Searches through the store item arrays and see if it's the same
		for (int i = 0; i < array1.length; i++) {
			if (name.equals(array1[i])) {
				return false;
			}
		}
		return true;
	}
}
