import java.util.ArrayList;

public class ShoppingCart {
	public static void main(String[] args) {
		// create an arraylist to hold the items in the shopping cart
		ArrayList<String> shoppingCart = new ArrayList<>();

		// add items to the shopping cart
		shoppingCart.add("Apple");
		shoppingCart.add("Banana");
		shoppingCart.add("Orange");

		// print the items in the shopping cart
		System.out.println("Items in the shopping cart:" + shoppingCart);

		// Checking size of the shopping cart
		System.out.println("Number of items in the shopping cart: " + shoppingCart.size());

		// Accessing an item in the shopping cart
		System.out.println("First item in the shopping cart: " + shoppingCart.get(0));

		System.out.println("Second item in the shopping cart: " + shoppingCart.get(1));

		// Removing an item from the shopping cart
		shoppingCart.remove("Banana");
		System.out.println("Items in the shopping cart after removing Banana: " + shoppingCart);

		// Checking if an item is in the shopping cart
		System.out.println("Is Orange in the shopping cart? " + shoppingCart.contains("Orange"));
		System.out.println("Is Apple in the shopping cart? " + shoppingCart.contains("Apple"));

		// Final checking the shopping cart
		for (String item : shoppingCart) {
			System.out.println("Item: " + item);
		}
	}
}
