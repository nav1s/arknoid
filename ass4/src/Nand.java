
import java.util.List;
import java.util.Map;

/**
 * This class represents a nand logic gate.
 */
public class Nand extends BinaryExpression {

    /**
     * @param e1 the first expression
     * @param e2 the second expression
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
    public Expression simplifyNonEmptyExpression() {
        Expression e1 = this.getE1().simplifyNonEmptyExpression();
        Expression e2 = this.getE2().simplifyNonEmptyExpression();

        Expression newExpression = new Nand(e1, e2);

        String str = newExpression.toString();
        List<String> variables = newExpression.getVariables();

        for (String var : variables) {
            String notVar1 = "(" + var + " A T)";
            String notVar2 = "(T A " + var + ")";
            if (str.equals(notVar1) || str.equals(notVar2)) {
                return new Not(new Var(var));
            }

            String trueExpression1 = "(" + var + " A F)";
            String trueExpression2 = "(F A " + var + ")";
            if (str.equals(trueExpression1) || str.equals(trueExpression2)) {
                return new Val(true);
            }

            String notVar3 = "(" + var + " A " + var + ")";
            if (str.equals(notVar3)) {
                return new Not(new Var(var));
            }

        }
        return newExpression;
    }

}
