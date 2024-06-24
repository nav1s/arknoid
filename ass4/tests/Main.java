/**
 */
public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // and norify and nandify
        Expression and = new And(new Var("x"), new Var("y"));
        String expectedOutput = "((x V x) V (y V y))";
        assert expectedOutput.equals(and.norify().toString());

        expectedOutput = "((x A y) A (x A y))";
        assert expectedOutput.equals(and.nandify().toString());

        // nand norify and nandify
        Expression nand = new Nand(new Var("x"), new Var("y"));
        expectedOutput = "(((x V x) V (y V y)) V ((x V x) V (y V y)))";
        String output = nand.norify().toString();
        assert expectedOutput.equals(output);

        output = nand.nandify().toString();
        expectedOutput = "(x A y)";
        assert expectedOutput.equals(output);

        // nor norify and nandify
        Expression nor = new Nor(new Var("x"), new Var("y"));

        output = nor.norify().toString();
        expectedOutput = "(x V y)";
        assert expectedOutput.equals(output);


        output = nor.nandify().toString();
        expectedOutput = "(((x A x) A (y A y)) A ((x A x) A (y A y)))";
        assert expectedOutput.equals(output);

        // not norify and nandify
        Expression not = new Not(new Var("x"));

        output = not.toString();
        expectedOutput = "~(x)";
        assert expectedOutput.equals(output);

        output = not.norify().toString();
        expectedOutput = "(x V x)";
        assert expectedOutput.equals(output);

        output = not.nandify().toString();
        expectedOutput = "(x A x)";
        assert expectedOutput.equals(output);

        System.out.println(1);
        System.exit(0);

        // or norify and nandify
        Expression or = new Or(new Var("x"), new Var("y"));
        System.out.println("or: " + or);
        System.out.println("or nortify: " + or.norify());
        System.out.println("Should print: ((x V y) V (x V y))\n");
        System.out.println("or nandtify: " + or.nandify());
        System.out.println("Should print: ((x A x) A (y A y))\n");

        // xnor norify and nandify
        Expression xnor = new Xnor(new Var("x"), new Var("y"));
        System.out.println("xnor: " + xnor);
        System.out.println("xnor nortify: " + xnor.norify());
        System.out.println("Should print: ((x V (x V y)) V (y V (x V y)))");
        System.out.println("Alternately: ((y V (x V x)) V (x V (y V y)))\n");
        System.out.println("xnor nandtify: " + xnor.nandify());
        System.out.println("Should print: (((x A x) A (y A y)) A (x A y))\n");

        // xor norify and nandify
        Expression xor = new Xor(new Var("x"), new Var("y"));
        System.out.println("xor: " + xor);
        System.out.println("xor nortify: " + xor.norify());
        System.out.println("Should print: (((x V x) V (y V y)) V (x V y))\n");
        System.out.println("xor nandtify: " + xor.nandify());
        System.out.println("Should print: ((x A (x A y)) A (y A (x A y)))");
        System.out.println("Alternately: ((y A (x A x)) A (x A (y A y)))\n");

        // simplify tests
        Expression e = new Xnor(new Nand(new Var("x"), new Val(false)),
                new Not(new And(new Or(new Var("x"), new Var("y")),
                        new Xor(new Val(true), new Var("z")))));
        System.out.println(e);
        System.out.println("Should print: ((x A F) # ~((x v y) ^ (T ⊕ z)))\n");

        // System.out.println("After simplification: " + e.simplify());
        // System.out.println("Should print: (T # ~(((x v y) ^ ~(z))))\n");
        // e = e.assign("y", new Val(false));
        // System.out.println("After assigning y = false: " + e);
        // System.out.println("Should print: ((x A F) # ~((x v F) ^ (T ⊕ z)))\n");
        // System.out.println("After simplification: " + e.simplify());
        // System.out.println("Should print: (T # ~((x ^ ~(z))))\n");
        // Map<String, Boolean> map = new HashMap<>();
        // map.put("x", true);
        // map.put("z", false);
        // try {
        // System.out.println("evaluate using x = true, z = false: " + e.evaluate(map));
        // System.out.println("Should print: false");
        // } catch (Exception ignored) {
        // System.out.println("Error. Exception thrown during evaluation.");
        // }

    }
}
