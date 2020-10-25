package dataStructure.tree.avlTree;

public class MyAVLTree {
    private class Node {
        int value;
        Node leftChild;
        Node rightChild;
        int height;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return Integer.toString(value);
        }
    }

    Node root;

    private int height(Node root) {
        return (root == null) ? -1 : root.height;
    }

    private Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }

        if (value < root.value) {
            root.leftChild = insert(root.leftChild, value);
        } else {
            root.rightChild = insert(root.rightChild, value);
        }

        root.height = 1 + Math.max(height(root.leftChild), height(root.rightChild));

        int balanceFactor = height(root.leftChild) - height(root.rightChild);
        if (balanceFactor <= 1) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        return root;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public static void main(String[] args) {
        MyAVLTree avlTree = new MyAVLTree();
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(30);
        avlTree.insert(1);
        avlTree.insert(25);
    }
}
