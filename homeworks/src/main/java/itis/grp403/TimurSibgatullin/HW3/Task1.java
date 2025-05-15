package itis.grp403.TimurSibgatullin.HW3;
import java.util.*;

public class Task1 {
    private static Map<Node, Integer> heights = new HashMap<>();

    public static int computeHeights(Node node) {
        if (node == null) return -1;

        int leftHeight = computeHeights(node.left);
        int rightHeight = computeHeights(node.right);
        int currentHeight = 1 + Math.max(leftHeight, rightHeight);

        heights.put(node, currentHeight);
        return currentHeight;
    }

    public static void printHeights(Node root) {
        computeHeights(root);
        for (Map.Entry<Node, Integer> entry : heights.entrySet()) {
            System.out.println("Node " + entry.getKey().val + " Height: " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printHeights(root);
    }
}