import java.util.List;
import java.util.Map;

/**
*/
public interface Expression {
   /**
   * Evaluate the expression using the variable values provided
   * in the assignment, and return the result. If the expression
   * contains a variable which is not in the assignment, an exception
   * is thrown.
    * @param assignment
    * @return the result of the expression
    * @throws Exception if the variable isn't in the assignment
    */
   Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

   /**
    * A convenience method. Like the `evaluate(assignment)` method above
    * but uses an empty assignment
    * @return a
    * @throws Exception
    */
   Boolean evaluate() throws Exception;

   /**
    * @return a list of the variables in the expression.
    */
   List<String> getVariables();

   /**
    * @return a nice string representation of the expression.
    */
   @Override
   String toString();

   /**
   * Returns a new expression in which all occurrences of the variable
   * var are replaced with the provided expression (Does not modify the
   * current expression).
    * @param var
    * @param expression
    * @return a new expression with
    */
   Expression assign(String var, Expression expression);
}
