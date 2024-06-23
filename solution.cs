Here is a C# console application that flattens a binary tree into a linked list in-place:

```C#
using System;

public class TreeNode
{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}

public class Solution
{
    private TreeNode prev = null;

    public void Flatten(TreeNode root)
    {
        if (root == null)
            return;
        Flatten(root.right);
        Flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

class Program
{
    static void Main(string[] args)
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Solution solution = new Solution();
        solution.Flatten(root);

        TreeNode node = root;
        while (node != null)
        {
            Console.Write(node.val + " ");
            node = node.right;
        }
    }
}
```

This program creates a binary tree with the root node value 1. The left child of the root node is 2 and the right child is 5. The left child of node 2 is 3 and the right child is 4. The right child of node 5 is 6. The Flatten method is then called to flatten the binary tree into a linked list in-place. The linked list is then printed to the console.