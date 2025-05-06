import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a variable.
 */
public class Var implements Expression {
    private String string;

    /**
     * @param string the chosen string for the variable
     */
    public Var(String string) {
        this.string = string;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        for (var entry : assignment.entrySet()) {
            String key = entry.getKey();
            if (key.equals(this.string)) {
                return entry.getValue();
            }
        }

        throw new Exception();
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception();
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

    @Override
    public Expression nandify() {
        return new Var(string);
    }

    @Override
    public Expression norify() {
        return new Var(string);
    }

    @Override
    public Expression simplify() {
        return new Var(this.string);
    }

}
