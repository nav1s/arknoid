
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 */
public class Not implements Expression {
    private Expression e1;

    /**
     * @param e1
     */
    public Not(Expression e1) {
        this.e1 = e1;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return !(e1.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return !(e1.evaluate());
    }


    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());

        return lst;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression newExpression = e1.assign(var, expression);

        return new Not(newExpression);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        return "~(" + this.e1 + ")";
    }

    @Override
    public Expression nandify() {
        Expression nand1 = e1.nandify();

        return new Nand(nand1, nand1);

    }

    @Override
    public Expression norify() {
        Expression nor1 = e1.nandify();

        return new Nor(nor1, nor1);

    }

    @Override
    public Expression duplicate() {
        Expression clonedE1 = this.e1.duplicate();

        return new Not(clonedE1);
    }


}
