//! PlaceHolder

/**
 * The main class for CountPairs.
 */
public class CountPairs {
   /**
    * The main method.
    *
    * @param args ignored
    */
   public static void main(String[] args) {
      // exit if the number of arguments is 1 or less
      if (args.length <= 1) {
         System.out.println("Invalid input");
         System.exit(0);
      }
      int targetNumber = Integer.parseInt(args[args.length - 1]);
      System.out.println(targetNumber);

      int pairsCounter = 0;
      // loop over all the arguments except for the last one
      for (int i = 0; i <= args.length - 2; i++) {
         for (int j = i + 1; j <= args.length - 2; j++) {
            int num1 = Integer.parseInt(args[i]);
            int num2 = Integer.parseInt(args[j]);

            if (num1 + num2 < targetNumber) {
               System.out.println("num1 is: " + num1);
               System.out.println("num2 is: " + num2);
               pairsCounter += 1;
            }
         }
      }
      System.out.println(pairsCounter);

   }

}