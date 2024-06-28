
import java.util.HashMap;
import java.util.Map;

/**
 * This class tests a few expressions.
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
        // todo fix this
        map.put("k", false);
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
