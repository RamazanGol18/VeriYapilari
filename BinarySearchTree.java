

package com.mycompany.binarysearchtree;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinarySearchTree {

    private TreeNode root;

    public BinarySearchTree() {
        root = null;
    }

    
    private TreeNode insert(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    
    public void insert(int data) {
        root = insert(root, data);
    }

    
    private void inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    
    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    
    private TreeNode search(TreeNode root, int data) {
        if (root == null || root.data == data) {
            return root;
        }

        if (data < root.data) {
            return search(root.left, data);
        }

        return search(root.right, data);
    }

   
    public TreeNode search(int data) {
        return search(root, data);
    }

    
    private TreeNode delete(TreeNode root, int data) {
        if (root == null) {
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            
            root.data = minValue(root.right);

            
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    
    public void delete(int data) {
        root = delete(root, data);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();

        
        int searchValue = 40;
        TreeNode foundNode = bst.search(searchValue);
        if (foundNode != null) {
            System.out.println("Değer " + searchValue + " bulundu.");
        } else {
            System.out.println("Değer " + searchValue + " bulunamadı.");
        }

        
        int deleteValue = 30;
        System.out.println("Değer " + deleteValue + " silindi.");
        bst.delete(deleteValue);

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal();
    }
}
