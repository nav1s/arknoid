import java.util.Map;
import java.util.TreeMap;

public class Part1 {
    public static void main() {

        Expression e = new Not(
                new Xor(
                        new And(
                                new Val(true),
                                new Or(
                                        new Var("x"),
                                        new Var("y"))),
                        new Var("x")));
        System.out.println(e);
        System.out.println("Should print:" + "∼ ((T ∧ (x ∨ y)) ⊕ x)");

        Expression e2 = new Xor(new And(new Var("x"), new Var("y")), new Val(true));

        String s = e2.toString();
        System.out.println("\n" + s);
        System.out.println("Should print (x ∧ y) ⊕ T\n");

        List<String> vars = e2.getVariables();
        for (String v : vars) {
            System.out.println(v);
        }

        System.out.println("Should print:\nx\ny");

        Expression e3 = e2.assign("y", e2);
        System.out.println(e3);
        System.out.println("Should print: ((x ^ ((x ^ y)⊕ T))⊕ T)");

        e3 = e3.assign("x", new Val(false));
        System.out.println(e3);
        System.out.println("Should print: ((F ^ ((F ^ y)⊕ T))⊕ T)");

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", true);
        assignment.put("y", false);
        Boolean value = false;
        try {
            value = e2.evaluate(assignment);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        System.out.println("The result is: " + value);
        System.out.println("Should print `The result is: true`");

    }
}
