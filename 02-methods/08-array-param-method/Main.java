// Method with Array Parameter

public class Main{
	static void myMethod(int[] numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		System.out.println("The summation =" + " " + sum);
	}

	public static void main(String[] args) {
		int[] myArray = { 250, 250 };
		myMethod(myArray);
	}
}
