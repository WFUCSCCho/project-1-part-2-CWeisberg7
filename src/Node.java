/*********************************************
 * @file: Node.java
 * @description: Class to represent nodes of the BST. EAch node holds
 * an element, references to both left and right subtrees, and their
 * accompanying get/set methods.
 * @author: Charles Weisberg
 * @date: 22 September 2024
 *********************************************/
class Node<T extends Comparable<T>> {
    private T element; // the value stored in the node
    private Node<T> left; //references left child
    private Node<T> right; //references right child

    /**
     * Default constructor initializing a node with no value
     */
    public Node() {
        left = right = null;
    }

    /**
     * Constructor to create a node with a specified value.
     * @param v the value to be stored in the node
     */
    public Node(T v) {
        left = right = null;
        element = v;
    }

    /**
     * Constructor to create a node with a specified value and children
     * @param v the value to be stored in the node
     * @param l the left child node
     * @param r the right child node
     */
    public Node(T v, Node<T> l, Node<T> r) {
        element = v;
        left = l;
        right = r;
    }

    /**
     * SEts the value of the node.
     * @param v the value to be set
     */
    public void setElement(T v) {
        element = v;
    }

    /**
     * SEts the left child of the node.
     * @param l the left child node
     */
    public void setLeft(Node<T> l) {
        left = l;
    }

    /**
     * Sets the right child of the node
     * @param r the right child node
     */
    public void setRight(Node<T> r) {
        right = r;
    }

    /**
     * Gets the left child of the node.
     * @return the left child node
     */
    public Node<T> getLeft() {
        return left;
    }

    /**
     * Gets the right child of the node.
     * @return the right child node
     */
    public Node<T> getRight() {

        return right;
    }

    /**
     * Gets teh value stored in the node.
     * @return the value of the node
     */
    public T getElement() {
        return element;
    }

    /**
     * Checks if the node is a leaf (i.e., has no children).
     * @return true if the node is a lead, false otherwise
     */
    public boolean isLeaf() {

        return (left == null && (right == null));
    }
}

