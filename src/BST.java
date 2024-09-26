/*********************************************
 * @file: BST.java
 * @description: Manages the structure of binary search trees (BST)
 * supports operations such as insertion, removal, and iteration without needing to understand the type of its elements
 * @author: Charles Weisberg
 * @date: 26 September 2024
 *********************************************/

import java.util.Iterator;
import java.util.Stack;

public class BST<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> root; // the root node of the BST
    private int nodecount; // the count of nodes in the BST

    /**
     * // Implement the constructor to create an empty BST
     */
    public BST() {
        root = null;
        nodecount = 0;
    }

    /**
     * Implement the clear method to clear all nodes in the BST
     */
    public void clear() {
        root = null;
        nodecount = 0;
    }

    /**
     * returns the number of nodes in BST
     *
     * @return the suze of the BST
     */
    public int size() {
        return nodecount;
    }

    /**
     * Inserts a new element into the BST
     *
     * @param e the element to be inserted
     */
    public void insert(T e) {
        root = inserthelp(root, e);
        nodecount++;
    }

    /**
     * Helper method to recursively insert a new element
     * Added >= to allow for duplicate cars with the same price to be added to BST
     *
     * @param root the current node being looked at
     * @param e    the element to be inserted
     * @return the updated subtree
     */
    private Node<T> inserthelp(Node<T> root, T e) {
        if (root == null) {
            return new Node<>(e);
        }
        if (e.compareTo(root.getElement()) < 0) {
            root.setLeft((inserthelp(root.getLeft(), e)));
        } else if (e.compareTo(root.getElement()) >= 0) {
            root.setRight(inserthelp(root.getRight(), e));
        }
        return root;
    }

    /**
     * Removes an element from the BST
     *
     * @param e the element to be removed
     * @return the updated roof of the BST
     */
    public Node<T> remove(T e) {
        root = removehelp(root, e);
        return root;
    }

    /**
     * Helper method to recursively remove an element
     *
     * @param root the current node being looked at
     * @param e    the element to be removed
     * @return the updated subtree
     */
    private Node<T> removehelp(Node<T> root, T e) {
        if (root == null) {
            return null;
        }
        if (e.compareTo(root.getElement()) < 0) {
            root.setLeft(removehelp(root.getLeft(), e));
        } else if (e.compareTo(root.getElement()) >= 0) {
            root.setRight(removehelp(root.getRight(), e));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            }
            root.setElement(minVal(root.getRight()));
            root.setRight(removehelp(root.getRight(), root.getElement()));
        }
        return root;
    }

    /**
     * Finds teh minimum value in a subtree
     *
     * @param root the root of the subtree
     * @return the minimum element
     */
    private T minVal(Node<T> root) {
        T min = root.getElement();
        while (root.getLeft() != null) {
            min = root.getLeft().getElement();
            root = root.getLeft();
        }
        return min;
    }

    /**
     * Searches for an element in the BST
     *
     * @param e the element to search for
     * @return the node containing the element, or null if not found
     */
    public Node<T> search(T e) {
        return searchhelp(root, e);
    }

    /**
     * Helper method to recursively search for an element.
     *
     * @param root the current node being looked at
     * @param e    the element to search for
     * @return the node containing the element, or null if not found
     */
    private Node<T> searchhelp(Node<T> root, T e) {
        if (root == null || root.getElement().equals(e)) {
            return root;
        }
        if (e.compareTo(root.getElement()) < 0) {
            return searchhelp(root.getLeft(), e);
        } else {
            return searchhelp(root.getRight(), e);
        }
    }

    /**
     * Returns an iterator for the BST
     *
     * @return an iterator for the elements in the BST
     */
    public Iterator<T> iterator() {
        return new BSTIterator<>(root);
    }
}
// Implement the BSTIterator class

class BSTIterator<T extends Comparable<T>> implements Iterator<T> {
    private Stack<Node<T>> stack = new Stack<>();

    /**
     * Constructor for the BSTIterator.
     *
     * @param root the root node of the BST
     */
    public BSTIterator(Node<T> root) {
        pushAll(root);
    }

    /**
     * Pushes all left nodes onto the stack
     *
     * @param node the current node
     */
    private void pushAll(Node<T> node) {
        while (node != null) {
            stack.push(node);
            node = node.getLeft();
        }
    }

    /**
     * Checks if there is a next element in the iteration.
     *
     * @return true if there is a next element, false otherwise
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * REturns the next element in the iteration.
     *
     * @return the next element
     */
    public T next() {
        Node<T> temp = stack.pop();
        pushAll(temp.getRight());
        return temp.getElement();
    }
}



