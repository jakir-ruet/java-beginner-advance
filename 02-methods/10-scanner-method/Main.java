
import java.util.Scanner;

public class Main {
	static void myMethod(int num1, int num2) {
		System.out.println("The summation =" + " " + (num1 + num2));
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter first number ");
		int num1 = scanner.nextInt();

		System.out.print("Enter second nubmer ");
		int num2 = scanner.nextInt();

		myMethod(num1, num2);
		scanner.close();
	}
}
