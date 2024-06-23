Here is a Python console application that flattens a binary tree into a linked list in-place:

```python
class Node:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def flatten(self, root):
        if not root:
            return None
        self.flatten(root.left)
        self.flatten(root.right)
        if root.left:
            temp = root.right
            root.right = root.left
            root.left = None
            while root.right:
                root = root.right
            root.right = temp

def print_tree(root):
    if root is None:
        return
    print(root.val, end=" ")
    print_tree(root.right)

def main():
    root = Node(1)
    root.left = Node(2)
    root.right = Node(5)
    root.left.left = Node(3)
    root.left.right = Node(4)
    root.right.right = Node(6)

    print("Original tree (preorder traversal):")
    print_tree(root)
    print()

    Solution().flatten(root)

    print("Flattened tree (preorder traversal):")
    print_tree(root)
    print()

if __name__ == "__main__":
    main()
```

This script first creates a binary tree with the Node class. The main function of the script creates a binary tree and prints it in preorder traversal. Then it flattens the tree using the flatten method of the Solution class and prints the flattened tree. The flatten method works by recursively flattening the left and right subtrees, then moving the left subtree to the right and attaching the original right subtree to the end of the new right subtree.