
/**
 * The main class for SumOfInteger.
 */
public class SumOfInteger {
   /**
    * The main method.
    *
    * @param args ignored
    */
   public static void main(String[] args) {
      // exit if the user didn't give us a single arg
      if (args.length != 1) {
         System.out.println("Invalid input");
         System.exit(0);
      }
      // save our number for ease of use
      String numToFindSumOf = args[0];
      // check if our string isn't a number
      try {
         Integer.parseInt(numToFindSumOf);
      } catch (Exception e) {
         System.out.println("Invalid input");
         System.exit(0);
      }

      int numSum = 0;

      // loop over the number we got
      for (int i = 0; i < numToFindSumOf.length(); i++) {
         int digit = Character.getNumericValue(numToFindSumOf.charAt(i));
         numSum += digit;
      }

      // print the sum of the number
      System.out.println(numSum);

   }
}
