import java.util.Scanner;

/**
 * The RPN class evaluates a line of numbers and operators input
 * by the user in Reverse Polish Notation to come up with a numerical
 * result.
 *
 * @author Tim Harris
 * @version 1.0
 */
public class RPN {
    private String rpnInput;    // Holds the RPN entered by the user
    private double result;      // Holds the result of the calculation

    /**
     * Constructor
     *
     * @param userInput The user input line in RPN
     */
    public RPN(String userInput) {
        rpnInput = userInput;
    }

    public double evaluate(){
        // Create new Stack object
        Stack st = new Stack();
        double firstValue;  // The first of two values used in each calculation
        double secondValue; // The second of two values used
        double onlyOneValue;    // Used if there is only one double input by the user
        char operator;          // Holds each operator

        // Create new Scanner object to look through the user input
        Scanner stringScanner = new Scanner(rpnInput);

        // Push the first number onto the stack
        st.push(stringScanner.nextDouble());

        // Check to see if there is only one number in the string
        if (!stringScanner.hasNext()){
            // If there is, pop it from the stack and return it
            onlyOneValue = st.pop();
            return onlyOneValue;
        }

        // Goes until the end of the String input by the user
        while (stringScanner.hasNext()){
            // If the next character is a number, push it onto the stack
            if (stringScanner.hasNextDouble()){
                st.push(stringScanner.nextDouble());
            }
            else{
                // Make sure the stack is not empty before popping the top
                // values to their variables
                if (st.empty()){
                    throw new IllegalArgumentException("Too many operators!");
                }
                firstValue = st.pop();
                if (st.empty()){
                    throw new IllegalArgumentException("Too many operators!");
                }
                secondValue = st.pop();

                // The operator is the next character
                operator = stringScanner.next().charAt(0);

                // Use the character as the correct operator and push
                // the result onto the stack
                if (operator == '+') {
                   result = firstValue + secondValue;
                   st.push(result);
                }
                else if (operator == '-') {
                    result = firstValue - secondValue;
                    st.push(result);
                }
                else if (operator == '*') {
                    result = firstValue * secondValue;
                    st.push(result);
                }
                else if (operator == '/') {
                    result = firstValue / secondValue;
                    st.push(result);
                }

                // If the next character is not mathematical, throw an exception
                else {
                   throw new IllegalArgumentException("Unknown operator: " + operator);
                }

                // If there is a double in the wrong place in the string,
                // throw an exception
                if (stringScanner.hasNextDouble()){
                    throw new IllegalArgumentException("Please list all numbers " +
                            "first, then all operators");
                }
            }
        }
        // If the stack has multiple values after the string is
        // all processed, throw an exception
        if (!st.empty()){
            st.pop();
            if (!st.empty()){
                throw new IllegalArgumentException("Not enough operators!");
            }
        }
        return result;
    }
}
