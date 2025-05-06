 * nor table:.
 * not: A NOR A
 * and: ( A NOR A ) NOR ( B NOR B )
 * or: ( A NOR B ) NOR ( A NOR B )
 * nand: [ ( A NOR A ) NOR ( B NOR B ) ] NOR [ ( A NOR A ) NOR ( B NOR B ) ]
 * nor: A NOR B
 * xor:[ ( A NOR A ) NOR ( B NOR B ) ] NOR ( A NOR B )
 * xnor: [ A NOR ( A NOR B ) ] NOR [ B NOR ( A NOR B ) ]
 */

class NorifyTest {
    private static final Var A = new Var("A"), B = new Var("B");

    void not() {
        Expression expected = new Nor(A, A);
        Expression actual = new Not(A).norify();
        assert expected.toString().equals(actual.toString());
    }

    void and() {
        Expression expected = new Nor(new Nor(A, A), new Nor(B, B));
        Expression actual = new And(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    void or() {
        Expression expected = new Nor(new Nor(A, B), new Nor(A, B));
        Expression actual = new Or(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    void nand() {
        Expression expected = new Nor(new Nor(new Nor(A, A), new Nor(B, B)),
                new Nor(new Nor(A, A), new Nor(B, B)));
        Expression actual = new Nand(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    void nor() {
        Expression expected = new Nor(A, B);
        Expression actual = new Nor(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    void xor() {
        Expression expected = new Nor(new Nor(new Nor(A, A), new Nor(B, B)), new Nor(A, B));
        Expression actual = new Xor(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    void xnor() {
        Expression expected = new Nor(new Nor(A, new Nor(A, B)), new Nor(B, new Nor(A, B)));
        Expression actual = new Xnor(A, B).norify();
        assert expected.toString().equals(actual.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        NorifyTest norifyTest = new NorifyTest();
        norifyTest.not();
        norifyTest.and();
        norifyTest.or();
        norifyTest.nand();
        norifyTest.nor();
        norifyTest.xor();
        norifyTest.xnor();
        System.out.println("Passed norify tests");

    }
}
