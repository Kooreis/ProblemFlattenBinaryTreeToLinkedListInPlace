Here is a Java console application that flattens a binary tree into a linked list in-place:

```java
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Main {
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }

            if (!stack.isEmpty()) {
                current.right = stack.peek();
            }
            current.left = null;
        }
    }

    public static void printTree(TreeNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        printTree(root);
    }
}
```

This program creates a binary tree with the root node value 1. The left child of the root is a node with value 2 and the right child is a node with value 5. The node with value 2 has two children: a left child with value 3 and a right child with value 4. The node with value 5 has a right child with value 6. The `flatten` method is then called to flatten the binary tree into a linked list in-place. The `printTree` method is used to print the flattened tree.