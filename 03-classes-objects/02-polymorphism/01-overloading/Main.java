// Compile-Time Polymorphism (Method Overloading)

class Calculator {
	int add(int a, int b) {
		return a + b;
	}

	int add(int a, int b, int c) {
		return a + b + c;
	}
}

public class Main {
	public static void main(String[] args) {
		Calculator c = new Calculator();
		System.out.println("Result: " + c.add(25, 35));
		System.out.println("Result: " + c.add(25, 35, 45));
	}
}
