// Parent class
class Payment {
	void pay() {
		System.out.println("Processing payment");
	}
}

// Child class
class CreditCardPayment extends Payment {
	@Override
	void pay() {
		System.out.println("Paid using Credit Card");
	}
}

// Child class
class PayPalPayment extends Payment{
	@Override
	void pay() {
		System.out.println("Paid using Paypal");
	}
}

// Main class
public class Main {
	public static void main(String[] args) {
		Payment p1 = new CreditCardPayment();
		Payment p2 = new PayPalPayment();

		p1.pay();
		p2.pay();
	}
}
