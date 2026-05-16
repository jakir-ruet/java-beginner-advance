abstract class Payment {
	// abstract method
	abstract void pay();

	//norman method
	void message() {
		System.out.println("Payment Processing...");
	}
}

class CreditCardPayment extends Payment {
	@Override
	void pay() {
		System.out.println("Paid using Credit Card");
	}
}

class PayPalpayment extends Payment {
	@Override
	void pay() {
		System.out.println("Paid using Paypal");
	}
}

public class Main {
	public static void main(String[] args) {
		Payment p1 = new CreditCardPayment();
		Payment p2 = new PayPalpayment();

		p1.message();
		p1.pay();

		System.out.println("-----------");

		p2.message();
		p2.pay();
	}
}
