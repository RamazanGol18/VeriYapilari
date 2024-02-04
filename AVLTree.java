package com.mycompany.avltree;

class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = this.right = null;
    }
}

public class AVLTree {
    private Node root;

    public AVLTree() {
        this.root = null;
    }

    
    private int height(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    
    private void updateHeight(Node node) {
        if (node != null) {
            node.height = 1 + Math.max(height(node.left), height(node.right));
        }
    }

    
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        
        x.right = y;
        y.left = T2;

        
        updateHeight(y);
        updateHeight(x);

        
        return x;
    }

    
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        
        y.left = x;
        x.right = T2;

        
        updateHeight(x);
        updateHeight(y);

        
        return y;
    }

    
    private Node insert(Node root, int data) {
        
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        } else {
            
            return root;
        }

        
        updateHeight(root);

       
        int balance = getBalance(root);

        
        if (balance > 1 && data < root.left.data) {
            return rightRotate(root);
        }

        
        if (balance < -1 && data > root.right.data) {
            return leftRotate(root);
        }

        
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        
        return root;
    }

    
    public void insert(int data) {
        root = insert(root, data);
    }

   
    private void siraylaGecis(Node root) {
        if (root != null) {
            siraylaGecis(root.left);
            System.out.print(root.data + " ");
            siraylaGecis(root.right);
        }
    }

    
    public void siraylaGecis() {
        siraylaGecis(root);
        System.out.println();
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();

        
        avlTree.insert(10);
        avlTree.insert(25);
        avlTree.insert(30);
        avlTree.insert(40);
        

        
        System.out.println("Sırayla Geçiş : ");
        avlTree.siraylaGecis();
    }
}
