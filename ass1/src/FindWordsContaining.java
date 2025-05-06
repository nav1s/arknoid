/**
 * The main class for FindWordsContaining.
 */
public class FindWordsContaining {
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
      String wildChar = args[args.length - 1];

      // exit if our string is not 1
      if (wildChar.length() != 1) {
         System.out.println("Invalid input");
         System.exit(0);
      }

      // loop over all the arguments except for the last one
      for (int i = 0; i < args.length - 1; i++) {
         // print the argument if it contains our char
         if (args[i].contains(wildChar)) {
            System.out.println(args[i]);
         }
      }

   }
}
