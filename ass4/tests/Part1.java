import java.util.Map;
import java.util.TreeMap;

/**
 */
public class Part1 {
    /**
     * @param args
     */
    @SuppressWarnings("unlikely-arg-type")
    public static void main(String[] args) {

        Expression e = new Not(
                new Xor(
                        new And(
                                new Val(true),
                                new Or(
                                        new Var("x"),
                                        new Var("y"))),
                        new Var("x")));
        assert e.equals("∼((T & (x | y)) ^ x)");
        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));

        assert e2.toString().equals("(x & y) ^ T)");
        List<String> strings = List.of("x", "y");
        List<String> vars = e2.getVariables();
        assert vars.equals(strings);

        Expression e3 = e2.assign("y", e2);
        assert e3.equals("((x & ((x & y) ^ T)) ^ T)");

        e3 = e3.assign("x", new Val(false));
        assert e3.equals("((F & ((F & y) ^ T)) ^ T)");

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        Boolean value = false;
        try {
            value = e2.evaluate(assignment);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        assert value;

        System.out.println(1);
        System.exit(0);


    }
}
