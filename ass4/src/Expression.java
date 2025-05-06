import java.util.List;
import java.util.Map;

/**
 * This class represents an expression.
 */
public interface Expression {

   /**
   * Evaluate the expression using the variable values provided
   * in the assignment, and return the result. If the expression
   * contains a variable which is not in the assignment, an exception
   * is thrown.
    * @param assignment a map with the variables and their respective assignments
    * @return the result of the expression
    * @throws Exception if the variable isn't in the assignment
    */
   Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

   /**
    * A convenience method. Like the `evaluate(assignment)` method above
    * but uses an empty assignment
    * @return the result of the expression
    * @throws Exception if the variable isn't in the assignment
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
    * @param var the variable we want to assign value to
    * @param expression the expression we want to switch the variable with
    * @return a new expression wit
    */
   Expression assign(String var, Expression expression);

   /**
    * @return the expression tree resulting from converting all the operations to the logical Nand operation.
    */
   Expression nandify();

   /**
    * @return the expression tree resulting from converting all the operations to the logical Nor operation.
    */
   Expression norify();

   /**
    * @return a simplified version of the current expression.
    */
   Expression simplify();
}
