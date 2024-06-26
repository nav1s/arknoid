
import java.util.ArrayList;
import java.util.List;

/**
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression e1;
    private Expression e2;
    /**
     * @param e1
     * @param e2
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

    /**
     * @return the first expression
     */
    public Expression getE1() {
        return e1;
    }

    /**
     * @param e1
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
     * @param e2
     */
    public void setE2(Expression e2) {
        this.e2 = e2;
    }

}
