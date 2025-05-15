package itis.grp403.TimurSibgatullin.HW3;
public class Task3 {
    public static String serialize(NNode root) {
        if (root == null) return "NULL";

        StringBuilder sb = new StringBuilder();
        sb.append("(").append(root.val);

        if (root.children.isEmpty()) {
            sb.append(", NULL");
        } else {
            for (NNode child : root.children) {
                sb.append(", ").append(serialize(child));
            }
        }

        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        NNode root = new NNode(1);
        NNode node2 = new NNode(2);
        NNode node3 = new NNode(3);
        NNode node4 = new NNode(4);
        NNode node5 = new NNode(5);

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);
        node3.children.add(node5);

        String result = serialize(root);
        System.out.println(result);
    }
}
