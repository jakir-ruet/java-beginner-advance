interface Payment {
	void pay();
}

class CreditCardPayment implements Payment {
	@Override
	public void pay() {
		System.out.println("Paying with credit card");
	}
}

class PayPalPayment implements Payment {
	@Override
	public void pay() {
		System.out.println("Paying with PayPal");
	}
}
public class Main {
	public static void main(String[] args) {
		Payment payment1 = new CreditCardPayment();
		payment1.pay();

		System.out.println("-------------");

		Payment payment2 = new PayPalPayment();
		payment2.pay();
	}
}

// What changed conceptually?
// Before (Abstract Class)
// Shared method inside parent class
// Tight relationship (is-a base class)
// Now (Interface)
// Only defines behavior
// No shared logic inside contract
// More flexible design
