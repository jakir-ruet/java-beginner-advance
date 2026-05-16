public class Main {
    // Method with 2 parameters
    static void myMethod(int num1, int num2) {
        System.out.println("Sum of 2 numbers: " + (num1 + num2));
    }

    // Method with 3 parameters (overloaded)
    static void myMethod(int num1, int num2, int num3) {
        System.out.println("Sum of 3 numbers: " + (num1 + num2 + num3));
    }

    public static void main(String[] args) {
        myMethod(250, 250);           // Calls 2-parameter version
        myMethod(100, 150, 200);      // Calls 3-parameter version
    }
}
