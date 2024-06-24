
import java.util.HashMap;

/**
 * Class with main to test the Expression classes.
 */
public class ExpressionTest {

    /**
     * Main which runs code.
     * @param args relevant
     */
    public static void main(String[] args) throws Exception{
        Expression x = new Var("x");
        Expression y = new Var("y");
        Expression z = new Var("z");
        Expression ex = new Xnor(new Nand(x, new Val(false)),
                new Not(new And(new Or(x, y),
                        new Xor(new Val(true), z))));

        System.out.println(ex.toString().equals("((x A F) # ~(((x | y) & (T ^ z))))"));

        HashMap<String, Boolean> map = new HashMap<>();
        map.put("x", true);
        map.put("y", false);
        map.put("z", false);

        try {
            System.out.println(ex.evaluate(map) == false);
        } catch (Exception ignored) {
        }

        System.out.println(ex.nandify().toString().equals("((((x A F) A (x A F)) A ((((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z))))) A ((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))))) A (((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z))))) A ((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))))))) A ((x A F) A (((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z))))) A ((((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z)))) A (((x A x) A (y A y)) A ((T A (T A z)) A (z A (T A z))))))))"));
        System.out.println(ex.norify().toString().equals("(((((x V x) V (F V F)) V ((x V x) V (F V F))) V ((((x V x) V (F V F)) V ((x V x) V (F V F))) V (((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z)))) V ((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z))))))) V ((((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z)))) V ((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z))))) V ((((x V x) V (F V F)) V ((x V x) V (F V F))) V (((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z)))) V ((((x V y) V (x V y)) V ((x V y) V (x V y))) V ((((T V T) V (z V z)) V (T V z)) V (((T V T) V (z V z)) V (T V z))))))))"));
        // System.out.println(ex.simplify().toString().equals("(T # ~(((x | y) & ~(z))))"));
    }
}
