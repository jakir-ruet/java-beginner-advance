// Method with Return Value

public class Main {
	static int myMethod(int num1, int num2) {
		return (num1 + num2);
	}
	public static void main(String[] args) {
		int num1 = 250;
		int num2 = 250;
		// int result = num1 + num2;
		int result = myMethod(num1, num2);
		System.out.println("The summation =" + " " + result);
	}
}
