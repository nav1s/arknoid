
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 */
public class Val implements Expression {
    private Boolean bool;

    /**
     * @param bool
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
        return this.duplicate();
    }

    @Override
    public Expression norify() {
        return this.duplicate();
    }

    @Override
    public Expression duplicate() {
        return new Val(this.bool);
    }

    @Override
    public Expression simplify() {
        if (this.getVariables().size() == 0) {
            try {
                return new Val(this.evaluate());
            } catch (Exception e) {
                return new Val(false);
            }
        }

        return simplifyNonEmptyExpression();
    }

    @Override
    public Expression simplifyNonEmptyExpression() {
        return new Val(this.bool);
    }


}
