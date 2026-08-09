public class Main {
   static int imperative() {
      int sum = 0;

      for (int i = 1; i <= 5; i++) {
         sum = sum + i;
      }
      return sum;
   }

   public static void main(String[] var0) {
      int result = imperative();
      System.out.println("The summation " + result);
   }
}
