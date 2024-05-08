//! PlaceHolder

/**
 * The main class for FindWordsContaining.
 */
public class FindWordsContaining {
   /** The main method.
    *
    * @param args ignored
    */
   public static void main(String[] args) {
      if (args.length <= 1) {
         System.out.println("Invalid input");
         System.exit(0);
      }
      System.out.println(args[0].charAt(0));
   }
}
