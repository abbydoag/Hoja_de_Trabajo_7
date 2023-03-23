package dictionary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    Node root;

    public Tree() {
        root = null;
    }

    public void insert(String word, String translation) {
        root = insertRec(root, word, translation);
    }
    private Node insertRec(Node root, String word, String translation) {
        if (root == null) {
            root = new Node(word, translation);
            return root;
        }
        if (word.compareToIgnoreCase(root.word) < 0)
            root.left = insertRec(root.left, word, translation);
        else if (word.compareToIgnoreCase(root.word) > 0)
            root.right = insertRec(root.right, word, translation);
        return root;
    }

    public Object search(String word) {
        return searchRec(root, word);
    }
    private Object searchRec(Node root, String word) {
        if (root == null || root.word.equalsIgnoreCase(word))
            return root == null ? null : root.translation;

        if (root.word.compareToIgnoreCase(word) > 0)
            return searchRec(root.left, word);

        return searchRec(root.right, word);
    }

    public String[] getWordsInOrder() {
        String[] result = new String[countNodes(root)];
        getWordsInOrderRec(root, result, 0);
        return result;
    }

    private int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getWordsInOrderRec(Node root, String[] result, int i) {
        if (root == null)
            return i;

        i = getWordsInOrderRec(root.left, result, i);
        result[i++] = root.word;
        i = getWordsInOrderRec(root.right, result, i);

        return i;
    }
    
    public void delete(String word) {
        root = deleteNode(root, word);
    }

    private Node deleteNode(Node current, String word) {
        if (current == null) {
            return null;
        }

        if (word.compareToIgnoreCase(current.word) < 0) {
            current.left = deleteNode(current.left, word);
        } else if (word.compareToIgnoreCase(current.word) > 0) {
            current.right = deleteNode(current.right, word);
        } else {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                Node minNode = findMinNode(current.right);
                current.word = minNode.word;
                current.translation = minNode.translation;
                current.right = deleteNode(current.right, minNode.word);
            }
        }

        return current;
    }

    private Node findMinNode(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return findMinNode(node.left);
        }
    }
}