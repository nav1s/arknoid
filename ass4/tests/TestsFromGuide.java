import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 */
public class TestsFromGuide {
    /**
     * @param args
     */
    public static void main(String[] args) {

        Expression e = new Not(
                new Xor(
                        new And(
                                new Val(true),
                                new Or(
                                        new Var("x"),
                                        new Var("y"))),
                        new Var("x")));
        String expectedOutput = "~(((T & (x | y)) ^ x))";
        assert expectedOutput.equals(e.toString());

        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));

        expectedOutput = "((x & y) ^ T)";
        assert expectedOutput.equals(e2.toString());

        List<String> strings = List.of("x", "y");
        List<String> vars = e2.getVariables();
        assert vars.equals(strings);

        Expression e3 = e2.assign("y", e2);
        expectedOutput = "((x & ((x & y) ^ T)) ^ T)";
        assert expectedOutput.equals(e3.toString());

        e3 = e3.assign("x", new Val(false));
        expectedOutput = "((F & ((F & y) ^ T)) ^ T)";
        assert expectedOutput.equals(e3.toString());

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

        e = new Xor(new And(new Var("x"), new Val(false)),
                new Or(new Var("y"), new Val(false)));

        String output = e.toString();
        expectedOutput = "((x & F) ^ (y | F))";
        assert expectedOutput.equals(output);

        e = new Xor(new And(new Var("x"), new Val(false)), new Or(new Var("y"), new Val(false)));

        output = e.toString();
        expectedOutput = "((x & F) ^ (y | F))";
        assert expectedOutput.equals(output);

        // simplify tests
        output = e.simplify().toString();
        expectedOutput = "y";
        assert expectedOutput.equals(output);

        // "((T & T) | F) ^ T
        e = new Xor(new Or(new And(new Val(true), new Val(true)), new Val(false)), new Val(true));

        output = e.simplify().toString();
        expectedOutput = "F";
        assert expectedOutput.equals(output);


        // and basic simplify tests
        e = new And(new Var("x"), new Val(true));
        output = e.toString();
        expectedOutput = "(x & T)";
        assert expectedOutput.equals(output);

        output = e.simplify().toString();
        expectedOutput = "x";
        assert expectedOutput.equals(output);

        e = new And(new Var("x"), new Val(false));
        output = e.toString();
        expectedOutput = "(x & F)";
        assert expectedOutput.equals(output);

        output = e.simplify().toString();
        expectedOutput = "F";
        assert expectedOutput.equals(output);

        e = new And(new Var("x"), new Var("x"));
        output = e.toString();
        expectedOutput = "(x & x)";
        assert expectedOutput.equals(output);

        output = e.simplify().toString();
        expectedOutput = "x";
        assert expectedOutput.equals(output);

        // extra tests
        e = new Xor(new And(new Var("x"), new Val(false)), new Or(new Var("y"), new Val(false)));

        output = e.toString();
        expectedOutput = "((x & F) ^ (y | F))";
        assert expectedOutput.equals(output);

        e = new Not(new Not(new Val(false)));
        output = e.toString();
        expectedOutput = "~(~(F))";
        assert expectedOutput.equals(output);

        output = e.simplify().toString();
        expectedOutput = "F";
        assert expectedOutput.equals(output);

        System.out.println("passed all tests from the guide");
        System.exit(0);

    }
}
