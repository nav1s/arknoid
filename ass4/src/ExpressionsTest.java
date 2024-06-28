
/**
 * This class tests a few expressions
 */
public class ExpressionsTest {

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Expression e = new And(new Xor(new Var("x"), new Var("y")), new Var("z"));
        System.out.println(e);

        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());

        
    }
    
}
