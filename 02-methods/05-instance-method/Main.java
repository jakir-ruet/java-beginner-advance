// Instance Method (Non-Static)

public class Main {
	int num1 = 250;
	int num2 = 250;
	int sum = num1 + num2;
	
	void myMethod() {
		 System.out.println("The summation =" + " " + sum);
	}
	public static void main(String[] args) {
		Main myObject = new Main();
		myObject.myMethod();
	}
}
