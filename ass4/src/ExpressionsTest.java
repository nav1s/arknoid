import java.util.HashMap;
import java.util.Map;

/**
 * This class performs some tests on an expression.
 */
public class ExpressionsTest {

    /**
     * @param args ignored
     */
    public static void main(String[] args) {
        Expression e = new And(new Xor(new Var("x"), new Var("y")), new Var("z"));
        System.out.println(e);

        Map<String, Boolean> map = new HashMap<>();
        map.put("x", true);
        map.put("y", true);
        map.put("z", false);

        try {
            String output = e.evaluate(map).toString();
            System.out.println(output);

        } catch (Exception ignored) {
            System.out.println("Error. Exception thrown during evaluation.");
        }

        System.out.println(e.nandify());
        System.out.println(e.norify());
        System.out.println(e.simplify());

    }

}
