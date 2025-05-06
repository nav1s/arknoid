import java.util.List;
import java.util.Map;

/**
 * This class represents a not logic gate.
 */
public class Not extends UnaryExpression {

    /**
     * @param e1 the first expression
     */
    public Not(Expression e1) {
        super(e1);
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();

        return !(e1.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        Expression e1 = this.getE1();

        return !(e1.evaluate());
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression e1 = this.getE1();

        Expression newExpression = e1.assign(var, expression);

        return new Not(newExpression);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        Expression e1 = this.getE1();

        return "~(" + e1 + ")";
    }

    @Override
    public Expression nandify() {
        Expression e1 = this.getE1();

        Expression nand1 = e1.nandify();

        return new Nand(nand1, nand1);

    }

    @Override
    public Expression norify() {
        Expression e1 = this.getE1();

        Expression nor1 = e1.norify();

        return new Nor(nor1, nor1);
    }

    @Override
    public Expression simplify() {
        Expression e1 = this.getE1().simplify();
        Expression newExpression = new Not(e1);

        List<String> variables = newExpression.getVariables();

        if (variables.size() == 0) {
            try {
                return new Val(this.evaluate());
            } catch (Exception e) {
            }
        }

        return newExpression;
    }
}
