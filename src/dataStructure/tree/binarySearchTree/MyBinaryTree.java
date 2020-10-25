package dataStructure.tree.binarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyBinaryTree {

    private class Node {
        int value;
        Node leftChild;
        Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }

    Node root;

    public void insertInBinarySearchTree(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }

                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }

                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        }

        Node current = root;
        while (current != null) {
            if (value == current.value) {
                return true;
            }

            current = value < current.value? current.leftChild: current.rightChild;
        }

        return false;
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.value + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    public void depthFirstPreOrderTraversal() {
        preOrder(root);
        System.out.println("");
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }

        inOrder(root.leftChild);
        System.out.print(root.value + " ");
        inOrder(root.rightChild);
    }

    public void depthFirstInOrderTraversal() {
        inOrder(root);
        System.out.println("");
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.value + " ");
    }

    public void depthFirstPostOrderTraversal() {
        postOrder(root);
        System.out.println("");
    }

    private int height(Node root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int height() {
        return height(root);
    }

    private int min(Node root) {
        return Math.min(root.leftChild != null? min(root.leftChild): root.value, root.rightChild != null? min(root.rightChild): root.value);
    }

    public int min() {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        return min(root);
    }

    private boolean isEqual(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 ==null) {
            return false;
        }

        return root1.value == root2.value && isEqual(root1.leftChild, root2.leftChild) && isEqual(root1.rightChild, root2.rightChild);
    }

    public boolean isEqual(MyBinaryTree tree) {
        if (tree == null) {
            throw new IllegalArgumentException();
        }

        return isEqual(root, tree.root);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.value < min || root.value > max) {
            return false;
        }

        return isBinarySearchTree(root.leftChild, min, max-1) &&
                    isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private void nodesAtKDistance(Node node, int distance, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (distance == 0) {
            list.add(node.value);
            return;
        }

        nodesAtKDistance(node.leftChild, distance - 1, list);
        nodesAtKDistance(node.rightChild, distance - 1, list);
    }

    public List<Integer> nodesAtKDistance(int k) {
        if (root == null) {
            throw new IllegalArgumentException();
        }

        List<Integer> list = new ArrayList<>();

        nodesAtKDistance(root, k, list);

        return list;
    }

    private void breadthFirstTraversal(Node node, int distance, HashMap<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }

        List<Integer> distances = map.containsKey(distance)? map.get(distance): new ArrayList<>();
        distances.add(node.value);
        map.put(distance, distances);

        breadthFirstTraversal(node.leftChild, distance + 1, map);
        breadthFirstTraversal(node.rightChild, distance + 1, map);
    }

    public HashMap<Integer, List<Integer>> breadthFirstTraversal() {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        breadthFirstTraversal(root, 0, map);

        return map;
    }

    public static void main(String[] args) {
        MyBinaryTree binaryTree = new MyBinaryTree();
        binaryTree.insertInBinarySearchTree(10);
        binaryTree.insertInBinarySearchTree(20);
        binaryTree.insertInBinarySearchTree(30);
        System.out.println(binaryTree.find(20));
        binaryTree.insertInBinarySearchTree(1);
        binaryTree.insertInBinarySearchTree(2);
        binaryTree.insertInBinarySearchTree(3);
        System.out.println(binaryTree.find(50));
        binaryTree.depthFirstPreOrderTraversal();
        binaryTree.depthFirstInOrderTraversal();
        binaryTree.depthFirstPostOrderTraversal();
        System.out.println(binaryTree.height());
        System.out.println(binaryTree.min());

        MyBinaryTree binaryTree2 = new MyBinaryTree();
        binaryTree2.insertInBinarySearchTree(10);
        binaryTree2.insertInBinarySearchTree(20);
        binaryTree2.insertInBinarySearchTree(30);
        binaryTree2.insertInBinarySearchTree(1);
        binaryTree2.insertInBinarySearchTree(2);
        binaryTree2.insertInBinarySearchTree(3);

        System.out.println(binaryTree.isEqual(binaryTree2));

        System.out.println(binaryTree.isBinarySearchTree());

        System.out.println(binaryTree.nodesAtKDistance(2));

        System.out.println(binaryTree.breadthFirstTraversal());
    }

}
