
import java.util.List;
import java.util.Map;

/**
 * This class represents an or logic gate.
 */
public class Or extends BinaryExpression {

    /**
     * @param e1 the first expression
     * @param e2 the second expression
     */
    public Or(Expression e1, Expression e2) {
        super(e1, e2);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return e1.evaluate(assignment) | e2.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return e1.evaluate() | e2.evaluate();
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

        return "(" + e1 + " | " + e2 + ")";
    }

    @Override
    public Expression nandify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nand1 = e1.nandify();
        Expression nand2 = e2.nandify();

        return new Nand(new Nand(nand1, nand1), new Nand(nand2, nand2));
    }

    @Override
    public Expression norify() {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        Expression nor1 = e1.norify();
        Expression nor2 = e2.norify();

        Expression firstExpression = new Nor(nor1, nor2);

        return new Nor(firstExpression, firstExpression);
    }

    @Override
    public Expression simplify() {
        Expression e1 = this.getE1().simplify();
        Expression e2 = this.getE2().simplify();

        Expression newExpression = new Or(e1, e2);

        String str = newExpression.toString();
        List<String> variables = newExpression.getVariables();

        if (variables.size() == 0) {
            try {
                return new Val(this.evaluate());
            } catch (Exception e) {
            }
        }

        for (String var : variables) {
            String trueExpression1 = "(" + var + " | T)";
            String trueExpression2 = "(T | " + var + ")";
            if (str.equals(trueExpression1) || str.equals(trueExpression2)) {
                return new Val(true);
            }

            String sameVar1 = "(" + var + " | F)";
            String sameVar2 = "(F | " + var + ")";
            String sameVar3 = "(" + var + " | " + var + ")";
            if (str.equals(sameVar1) || str.equals(sameVar2) || str.equals(sameVar3)) {
                return new Var(var);
            }

        }
        return newExpression;
    }




}
