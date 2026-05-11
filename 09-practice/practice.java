import java.util.Arrays;

public class practice {
	static void myMethod() {
		int[] myNumbers = { 1, 3, 2, 5, 4 };
		Arrays.sort(myNumbers);
		Arrays.sort(myNumbers, 0, 3);
		System.out.println(myNumbers[0]);
		System.out.println(myNumbers[1]);
		System.out.println(Arrays.toString(myNumbers));
		}
	public static void main(String[] args) {
		myMethod();
	}
}
