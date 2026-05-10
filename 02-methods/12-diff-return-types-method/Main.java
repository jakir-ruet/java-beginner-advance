public class Main {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static String add(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        int intResult = add(250, 250);
        double doubleResult = add(10.5, 20.7);
        String stringResult = add("Hello", " World");

        System.out.println("Int sum: " + intResult);
        System.out.println("Double sum: " + doubleResult);
        System.out.println("String concatenation: " + stringResult);
    }
}
