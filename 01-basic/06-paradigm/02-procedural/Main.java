public class Main {

	static int add(int a, int b) {
		return a + b;
	}

	static int multiply(int a, int b) {
		return a * b;
	}

	public static void main(String[] args) {

		int result_add = add(20, 30);
		int result_multiply = multiply(20, 30);

		System.out.println("The summation " + result_add);
		System.out.println("The multiply " + result_multiply);
	}
}
