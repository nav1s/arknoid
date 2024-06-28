
import java.util.List;
import java.util.Map;

/**
 * This class represents a nor logic gate.
 */
public class Nor extends BinaryExpression {

    /**
     * @param e1 the first expression
     * @param e2 the second expression
     */
    public Nor(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return !(e1.evaluate(assignment) | e2.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return !(e1.evaluate() | e2.evaluate());
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression newE1 = e1.assign(var, expression);
        Expression newE2 = e2.assign(var, expression);

        return new Or(newE1, newE2);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return "(" + e1 + " V " + e2 + ")";
    }

    @Override
    public Expression nandify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nand1 = e1.nandify();
        Expression nand2 = e2.nandify();

        return new Nand(new Nand(new Nand(nand1, nand1), new Nand(nand2, nand2)),
                new Nand(new Nand(nand1, nand1), new Nand(nand2, nand2)));
    }

    @Override
    public Expression norify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nor1 = e1.norify();
        Expression nor2 = e2.norify();

        return new Nor(nor1, nor2);
    }

    @Override
    public Expression duplicate() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression clonedE1 = e1.duplicate();
        Expression clonedE2 = e2.duplicate();

        return new Nor(clonedE1, clonedE2);
    }

    @Override
    public Expression simplifyNonEmptyExpression() {
        Expression e1 = this.getE1().simplifyNonEmptyExpression();
        Expression e2 = this.getE2().simplifyNonEmptyExpression();

        Expression newExpression = new Xor(e1, e2);

        String str = newExpression.toString();
        List<String> variables = newExpression.getVariables();

        for (String var : variables) {
            String falseExpression1 = "(" + var + " V T)";
            String falseExpression2 = "(T V " + var + ")";
            if (str.equals(falseExpression1) || str.equals(falseExpression2)) {
                return new Val(false);
            }

            String notVar1 = "(" + var + " V F)";
            String notVar2 = "(F V " + var + ")";
            if (str.equals(notVar1) || str.equals(notVar2)) {
                return new Not(new Var(var));
            }

            String notVar3 = "(" + var + " V " + var + ")";
            if (str.equals(notVar3)) {
                return new Not(new Var(var));
            }

        }
        return newExpression;
    }
}
