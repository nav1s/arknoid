
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
        for (var entry : assignment.entrySet()) {
            String key = entry.getKey();
            if (key.equals(this.string)) {
                return entry.getValue();
            }
        }

        throw new Exception("Unable to find variable");
    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception("Unable to find variable");
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

        return expression.duplicate();
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public Expression nandify() {
        return this.duplicate();
    }

    @Override
    public Expression norify() {
        return this.duplicate();
    }

    @Override
    public Expression duplicate() {
        return new Var(this.string);
    }

}
