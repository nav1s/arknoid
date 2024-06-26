/**
 * nand table:.
 * not: A NAND A
 * and: ( A NAND B ) NAND ( A NAND B )
 * or: ( A NAND A ) NAND ( B NAND B )
 * nand: A NAND B
 * nor:  [ ( A NAND A ) NAND ( B NAND B ) ] NAND [ ( A NAND A ) NAND ( B NAND B ) ]
 * xor: [ A NAND ( A NAND B ) ] NAND [ B NAND ( A NAND B ) ]
 * xnor: [ ( A NAND A ) NAND ( B NAND B ) ] NAND ( A NAND B )
 */

class NandifyTest {
    private static final Var A = new Var("A"), B = new Var("B");

    void not() {
        Expression expected = new Nand(A, A);
        Expression actual = new Not(A).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void and() {
        Expression expected = new Nand(new Nand(A, B), new Nand(A, B));
        Expression actual = new And(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void or() {
        Expression expected = new Nand(new Nand(A, A), new Nand(B, B));
        Expression actual = new Or(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void nand() {
        Expression expected = new Nand(A, B);
        Expression actual = new Nand(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void nor() {
        Expression expected = new Nand(new Nand(new Nand(A, A), new Nand(B, B)),
                new Nand(new Nand(A, A), new Nand(B, B)));
        Expression actual = new Nor(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void xor() {
        Expression expected = new Nand(new Nand(A, new Nand(A, B)), new Nand(B, new Nand(A, B)));
        Expression actual = new Xor(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    void xnor() {
        Expression expected = new Nand(new Nand(new Nand(A, A), new Nand(B, B)), new Nand(A, B));
        Expression actual = new Xnor(A, B).nandify();
        assert expected.toString().equals(actual.toString());
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        NandifyTest nandifyTest = new NandifyTest();
        nandifyTest.not();
        nandifyTest.and();
        nandifyTest.or();
        nandifyTest.nand();
        nandifyTest.nor();
        nandifyTest.xor();
        nandifyTest.xnor();
        System.out.println("Passed nandify tests");

    }
}
