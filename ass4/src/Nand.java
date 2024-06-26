
import java.util.Map;

/**
 */
public class Nand extends BinaryExpression {
    /**
     * @param e1
     * @param e2
     */
    public Nand(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return !(e1.evaluate(assignment) & e2.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return !(e1.evaluate() & e2.evaluate());
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression newE1 = e1.assign(var, expression);
        Expression newE2 = e2.assign(var, expression);

        return new Nand(newE1, newE2);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return "(" + e1 + " A " + e2 + ")";

    }

    @Override
    public Expression nandify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nand1 = e1.nandify();
        Expression nand2 = e2.nandify();

        return new Nand(nand1, nand2);
    }

    @Override
    public Expression norify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nor1 = e1.norify();
        Expression nor2 = e2.norify();

        Expression newExpression = new Nor(new Nor(nor1, nor1), new Nor(nor2, nor2));

        return new Nor(newExpression, newExpression);
    }

    @Override
    public Expression duplicate() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression clonedE1 = e1.duplicate();
        Expression clonedE2 = e2.duplicate();

        return new Nand(clonedE1, clonedE2);
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

        return new Val(false);
    }

    @Override
    public Expression simplifyNonEmptyExpression() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'simplifyNonEmptyExpression'");
    }


}
