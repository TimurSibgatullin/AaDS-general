package itis.grp403.TimurSibgatullin.HW3;

public class Task2 {
    public static String serialize(Node root) {
        if (root == null) return "NULL";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return "(" + root.val + ", " + left + ", " + right + ")";
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        String result = serialize(root);
        System.out.println(result);
    }
}
