
import java.util.ArrayList;
import java.util.List;

/**
 */
public abstract class UnaryExpression extends BaseExpression{
    protected Expression e1;

    @Override
    public List<String> getVariables() {
        ArrayList<String> lst = new ArrayList<>();
        lst.addAll(e1.getVariables());

        return lst;
    }

}
