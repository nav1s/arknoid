
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This class represents a boolean value.
 */
public class Val implements Expression {
    private Boolean bool;

    /**
     * @param bool the value of the expression
     */
    public Val(boolean bool) {
        this.bool = bool;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.bool;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.bool;
    }

    @Override
    public List<String> getVariables() {
        return new ArrayList<String>();
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Val(this.bool);
    }

    @Override
    public String toString() {
        if (bool.equals(true)) {
            return "T";
        }

        return "F";

    }

    @Override
    public Expression nandify() {
        return new Val(bool);
    }

    @Override
    public Expression norify() {
        return new Val(bool);
    }

    @Override
    public Expression simplify() {
        return new Val(this.bool);
    }


}
