
import java.util.Map;

/**
 */
public class And extends BinaryExpression {
    /**
     * @param e1
     * @param e2
     */
    public And(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return e1.evaluate(assignment) & e2.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return e1.evaluate() & e2.evaluate();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression newE1 = e1.assign(var, expression);
        Expression newE2 = e2.assign(var, expression);

        return new And(newE1, newE2);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return "(" + e1 + " & " + e2 + ")";

    }

    @Override
    public Expression nandify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nand1 = e1.nandify();
        Expression nand2 = e2.nandify();

        return new Nand(new Nand(nand1, nand2), new Nand(nand1, nand2));
    }

    @Override
    public Expression norify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nor1 = e1.norify();
        Expression nor2 = e2.norify();

        Expression firstExpression = new Nor(nor1, nor1);
        Expression secondExpression = new Nor(nor2, nor2);

        return new Nor(firstExpression, secondExpression);
    }

    @Override
    public Expression duplicate() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression clonedE1 = e1.duplicate();
        Expression clonedE2 = e2.duplicate();

        return new And(clonedE1, clonedE2);
    }

    @Override
    public Expression simplify() {
        if (this.getVariables().size() == 0) {
            try {
                return new Val(this.evaluate());
            } catch (Exception e) {
                return new Val(false);
            }
        }

        return simplifyNonEmptyExpression();
    }

    @Override
    public Expression simplifyNonEmptyExpression() {
        String str = this.toString();
        if (str.equals("(x & F)")) {
            return new Val(false);
        }
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return new And(e1.simplifyNonEmptyExpression(), e2.simplifyNonEmptyExpression());
    }



}
