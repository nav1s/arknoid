
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 */
public class Xor implements Expression {
    private Expression e1;
    private Expression e2;

    /**
     * @param e1
     * @param e2
     */
    public Xor(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return e1.evaluate(assignment) ^ e2.evaluate(assignment);
    }

    @Override
    public Boolean evaluate() throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
    }

    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());
        lst.addAll(e2.getVariables());

        return lst;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression newE1 = e1.assign(var, expression);
        Expression newE2 = e2.assign(var, expression);

        return new Xor(newE1, newE2);
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        return "(" + e1 + "⊕ " + e2 + ")";
    }

    @Override
    public Expression nandify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nandify'");
    }

    @Override
    public Expression norify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'norify'");
    }

}
