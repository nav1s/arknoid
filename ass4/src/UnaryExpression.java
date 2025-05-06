import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an unary expression.
 */
public abstract class UnaryExpression extends BaseExpression {
    private Expression e1;

    /**
     * @param e1 the first expression
     */
    public UnaryExpression(Expression e1) {
        this.e1 = e1;
    }

    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());

        return lst;
    }

    /**
     * @return the first expression
     */
    public Expression getE1() {
        return e1;
    }

    /**
     * @param e1 the new expression we want to set
     */
    public void setE1(Expression e1) {
        this.e1 = e1;
    }

}
