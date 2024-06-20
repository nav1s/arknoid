
import java.util.List;
import java.util.Map;

/**
 */
public class Var implements Expression {
    private String string;

    /**
     * @param string
     */
    public Var(String string) {
        this.string = string;
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

    @Override
    public String toString() {
        return string;
    }

}

