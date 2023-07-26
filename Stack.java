/**
 * A linked list implementation of a stack.
 *
 * @author Tim Harris
 * @version 1.0
 */
public class Stack {
    /**
     * Creates the nodes for a linked list.
     */
    private class Node
    {
        double value;   // The values of the doubles from the string.
        Node next;      // The next node.

        /**
         * Constructor: creates a new node.
         *
         * @param val The values of the numbers from the string
         * @param n The next node
         */
        Node(double val, Node n)
        {
            value = val;
            next = n;
        }
    }

    private Node top = null;  // The top of the stack

    /**
     * The empty method checks for an empty stack.
     *
     * @return True if stack is empty, false otherwise.
     */
    public boolean empty()
    {
        return top == null;
    }

    /**
     * The push method adds a new item to the stack.
     *
     * @param i The item to be pushed onto the stack.
     */
    public void push(double i)
    {
        top = new Node(i, top);
    }

    /**
     * The Pop method removes the value at the top of the stack.
     *
     * @return The value at the top of the stack.
     */
    public double pop()
    {
            double retValue = top.value;
            top = top.next;
            return retValue;
    }

    /**
     * The peek method returns the top value on the stack.
     *
     * @return The value at the top of the stack.
     */

    public double peek()
    {
            return top.value;
    }
}
