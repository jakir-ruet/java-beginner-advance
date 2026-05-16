// Constructor Method

public class Main {
	int num1;
	int num2;

	// Constructor
	Main(int num1, int num2) {
		this.num1 = num1;
		this.num1 = num2;
	}

	void myMethod() {
		System.out.println("The summation =" + " " + (num1 + num2));
	}

	public static void main(String[] args) {
		Main myObject = new Main(250, 250);
		myObject.myMethod();
	}
}
