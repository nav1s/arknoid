
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'evaluate'");
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

        return lst;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        Expression newE1 = e1.assign(var, expression);

        return new Not(newE1);
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nandify'");
    }

    @Override
    public Expression norify() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'norify'");
    }

    @Override
    public Expression duplicate() {
        Expression clonedE1 = this.e1.duplicate();

        return new Not(clonedE1);
    }


}
