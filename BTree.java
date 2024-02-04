
package com.mycompany.btree;


import java.util.LinkedList;
import java.util.Queue;

class BNode {
    int[] keys;
    int keyCount;
    BNode[] children;

    public BNode(int t) {
        keys = new int[2 * t - 1];
        children = new BNode[2 * t];
        keyCount = 0;
    }
}

public class BTree {
    private BNode root;
    private int t;

    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void insert(int key) {
        if (root == null) {
            root = new BNode(t);
            root.keys[0] = key;
            root.keyCount = 1;
        } else {
            if (root.keyCount == 2 * t - 1) {
                BNode newRoot = new BNode(t);
                newRoot.children[0] = root;
                splitChild(newRoot, 0);
                root = newRoot;
            }
            insertNonFull(root, key);
        }
    }

    private void insertNonFull(BNode node, int key) {
        int i = node.keyCount - 1;

        if (node.children[i] == null) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.keyCount++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }

            i++;
            if (node.children[i].keyCount == 2 * t - 1) {
                splitChild(node, i);

                if (key > node.keys[i]) {
                    i++;
                }
            }

            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(BNode parentNode, int index) {
        BNode childNode = parentNode.children[index];
        BNode newChildNode = new BNode(t);

        parentNode.keyCount++;
        parentNode.children[index + 1] = newChildNode;

        for (int j = t - 1; j < 2 * t - 2; j++) {
            newChildNode.keys[j - t + 1] = childNode.keys[j];
        }

        newChildNode.keyCount = t - 1;
        childNode.keyCount = t - 1;

        for (int j = index + 1; j < parentNode.keyCount; j++) {
            parentNode.keys[j - 1] = parentNode.keys[j];
        }

        parentNode.keys[index] = childNode.keys[t - 1];

        for (int j = index + 1; j < parentNode.keyCount + 1; j++) {
            parentNode.children[j] = parentNode.children[j + 1];
        }
        parentNode.children[parentNode.keyCount] = newChildNode;
    }

    public void seviyeSirasiGecisi() {
        if (root == null) {
            System.out.println("B-Tree is empty.");
            return;
        }

        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BNode node = queue.poll();
            for (int i = 0; i < node.keyCount; i++) {
                System.out.print(node.keys[i] + " ");
            }
            System.out.print("| ");

            for (int i = 0; i <= node.keyCount; i++) {
                if (node.children[i] != null) {
                    queue.offer(node.children[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(2);

        int[] keys = {3, 7, 1, 8, 2, 5, 4, 6};
        for (int key : keys) {
            bTree.insert(key);
        }

        System.out.println("Seviye Sırası Geçişi:");
        bTree.seviyeSirasiGecisi();
    }
}