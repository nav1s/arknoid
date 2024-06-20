
import java.util.List;
import java.util.Map;

/**
 */
public class And implements Expression {

    /**
     * @param var
     * @param var2
     */
    public And(Var var, Var var2) {
        // TODO Auto-generated constructor stub
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVariables'");
    }

    @Override
    public Expression assign(String var, Expression expression) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assign'");
    }

    /**
    * @return a nice string representation of the expression.
    */
    @Override
    public String toString() {
        return "";
    }

}
