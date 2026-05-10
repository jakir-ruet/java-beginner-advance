public class Main {
	static int add(int a, int b) {
		return (a + b);
	}

	static void printSum(int sum) {
		System.err.println("The summation =" + " " + sum);
	}

	public static void main(String[] args) {
		int num1 = 250;
		int num2 = 250;
		printSum(add(num1, num2));
	}
}
