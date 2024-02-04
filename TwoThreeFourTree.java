
package com.mycompany.twothreefourtree;


class Node {
    int key1, key2, key3;
    Node parent;
    Node left, middle, right;

    public Node(int key) {
        this.key1 = key;
        this.key2 = this.key3 = -1;
        this.parent = this.left = this.middle = this.right = null;
    }
}

public class TwoThreeFourTree {
    private Node root;

    public TwoThreeFourTree() {
        this.root = null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node result = insert(root, key);

            if (result != null) {
                Node newRoot = new Node(result.key2);
                newRoot.left = result;
                newRoot.right = root;
                root.parent = newRoot;
                result.parent = newRoot;
                root = newRoot;
            }
        }
    }

    private Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key3 == -1) {
            if (key < node.key1) {
                shiftKeys(node, key);
            } else if (key > node.key1 && key < node.key2) {
                shiftKeys(node, key);
            } else {
                shiftKeys(node, key);
            }
            return null;
        } else {
            if (key < node.key1) {
                Node result = insert(node.left, key);
                if (result != null) {
                    if (node.key3 != -1) {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return result;
                    } else {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return null;
                    }
                }
            } else if (key > node.key1 && key < node.key2) {
                Node result = insert(node.middle, key);
                if (result != null) {
                    if (node.key3 != -1) {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return result;
                    } else {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return null;
                    }
                }
            } else {
                Node result = insert(node.right, key);
                if (result != null) {
                    if (node.key3 != -1) {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return result;
                    } else {
                        shiftKeys(node, result.key2);
                        result.key2 = -1;
                        result.key3 = -1;
                        result.left = null;
                        result.middle = null;
                        result.right = null;
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private void shiftKeys(Node node, int key) {
        if (key < node.key1) {
            node.key3 = node.key2;
            node.key2 = node.key1;
            node.key1 = key;
        } else if (key > node.key1 && key < node.key2) {
            node.key3 = node.key2;
            node.key2 = key;
        } else {
            node.key3 = key;
        }
    }

    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);
            if (node.key1 != -1) {
                System.out.print(node.key1 + " ");
            }
            inOrderTraversal(node.middle);
            if (node.key2 != -1) {
                System.out.print(node.key2 + " ");
            }
            inOrderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        TwoThreeFourTree tree = new TwoThreeFourTree();

        int[] keys = {20, 10, 5, 15, 25, 30, 35};
        for (int key : keys) {
            tree.insert(key);
        }

        System.out.println("Inorder Traversal:");
        tree.inOrderTraversal();
    }
}