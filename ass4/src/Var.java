
import java.util.ArrayList;
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
        ArrayList<String> lst = new ArrayList<>();
        lst.add(string);

        return lst;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (!this.string.equals(var)) {
            return new Var(this.string);
        }

        return expression;
    }

    @Override
    public String toString() {
        return string;
    }

}

