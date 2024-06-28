
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a binary expression.
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression e1;
    private Expression e2;

    /**
     * @param e1 the first expression
     * @param e2 the second expression
     */
    public BinaryExpression(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }

    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());
        lst.addAll(e2.getVariables());

        return lst;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        Expression e1 = this.getE1();
        Expression e2 = this.getE2();

        return e1.evaluate(assignment) & e2.evaluate(assignment);
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


    /**
     * @return the second expression
     */
    public Expression getE2() {
        return e2;
    }

    /**
     * @param e2 the new expression we want to set
     */
    public void setE2(Expression e2) {
        this.e2 = e2;
    }

}
