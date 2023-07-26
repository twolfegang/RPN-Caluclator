import java.util.Scanner;

/**
 * The RPNCalculator class runs through the RPN program to calculate the
 * result of an expression entered in RPN by the user.
 *
 * @author Tim Harris
 * @version 1.0
 */
public class RPNCalculator {
    /**
     * Collects user input and calculates the result. Repeats until the
     * user chooses to stop.
     *
     * @param args A string array containing the command line arguments.
     */
    public static void main(String[] args) {
        String repeat;  // Used to allow user to repeat program
        String rpnString;   // The user input in reverse polish notation
        double finalCalc;

        // Welcome message
        System.out.println("\nWelcome to the RPN Calculator!\n");
        System.out.println("(blank line to quit)");

        // Repeats until user enters a blank line
        do {
            // Create new Scanner object
            Scanner keyboard = new Scanner(System.in);

            // Get RPN from user
            System.out.print("calc> ");
            rpnString = keyboard.nextLine();

            // Create new RPN object
            RPN newCalc = new RPN(rpnString);

            // Returns the result from the evaluate method in RPN
            finalCalc = newCalc.evaluate();

            // Print the result
            System.out.println(finalCalc);

            repeat = rpnString;
        }while (repeat != "");  // Repeat if user input was a blank line

        // Goodbye message
        System.out.println("\n Thanks for using the RPN Calculator! Goodbye!");
    }
}
