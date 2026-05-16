public class Main {
    static void explainRecursion(int n) {
        // Base Case - stops recursion
        if (n == 0) {
            System.out.println("Base case reached! Stopping...");
            return;
        }

        // Recursive Case - calls itself
        System.out.println("Calling recursion with: " + (n - 1));
        explainRecursion(n - 1);
        System.out.println("Returning from: " + n);
    }

    public static void main(String[] args) {
        explainRecursion(3);
    }
}
