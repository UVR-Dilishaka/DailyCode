
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Node {
    String val;
    Node left;
    Node right;

    Node(String val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    Node(String val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeCodec {

    // Serializes a binary tree to a string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    // Helper method for preorder traversal and building the string
    private void serializeHelper(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append("None,");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Deserializes a string back into a binary tree.
    public Node deserialize(String data) {
        List<String> dataList = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(dataList);
    }

    // Helper method to build the tree recursively
    private Node deserializeHelper(List<String> dataList) {
        String val = dataList.remove(0);
        if (val.equals("None")) {
            return null;
        }
        Node node = new Node(val);
        node.left = deserializeHelper(dataList);
        node.right = deserializeHelper(dataList);
        return node;
    }

    public static void main(String[] args) {
        BinaryTreeCodec codec = new BinaryTreeCodec();

        // Test the serialization and deserialization
        Node node = new Node("root", new Node("left", new Node("left.left"), null), new Node("right"));
        
        // Serialize the tree
        String serialized = codec.serialize(node);
        System.out.println("Serialized Tree: " + serialized);
        
        // Deserialize the tree
        Node deserialized = codec.deserialize(serialized);
        System.out.println("Deserialized left.left value: " + deserialized.left.left.val);
        
        // Check if the deserialization is correct
        assert deserialized.left.left.val.equals("left.left");
    }
}
