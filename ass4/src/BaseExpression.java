
/**
 * This class is an abstract class for a basic expression.
 */
public abstract class BaseExpression implements Expression {

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

}