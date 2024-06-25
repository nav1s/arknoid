
import java.util.ArrayList;
import java.util.List;

/**
 */
public abstract class BinaryExpression extends BaseExpression{
    protected Expression e1;
    protected Expression e2;

    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());
        lst.addAll(e2.getVariables());

        return lst;
    }

    
}
