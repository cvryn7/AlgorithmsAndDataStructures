package BinarySearchTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Karan Bhagat on 4/10/2017.
 */

class Node {
    private Node left = null;
    private Node right = null;
    private int data = 0;

    Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    Node getLeft() {
        return left;
    }

    Node getRight() {
        return right;
    }

    int getData() {
        return data;
    }

    void setLeft(Node left) {
        this.left = left;
    }

    void setRight(Node right) {
        this.right = right;
    }

    void setData(int data) {
        this.data = data;
    }
}

public class BinarySearchTree {

    Node root = null;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfElems = Integer.parseInt(br.readLine());

        int[] dataArray = new int[numberOfElems];

        String data;
        int counter = 0;
        String[] dataString = br.readLine().split(" ");
        for (int i = 0; i < numberOfElems; i++) {
            dataArray[i] = Integer.parseInt(dataString[i]);
        }

        BinarySearchTree bst = new BinarySearchTree();

        bst.createTree(dataArray);

        bst.printTree();
    }

    public void createTree(int[] dataArray) {
        for(int i = 0; i < dataArray.length; i++) {
            root = addToTree(dataArray[i], root);
        }
    }

    public Node addToTree(int data, Node root) {
        if (root == null) {
            root = new Node(data, null, null);
            return root;
        }

        if (data <= root.getData()) {
            root.setLeft(addToTree(data, root.getLeft()));
        } else {
            root.setRight(addToTree(data, root.getRight()));
        }

        return root;
    }

    public void printTree() {
        inorderPrint(root);
    }

    public void inorderPrint(Node root) {
        if (root.getLeft() != null) {
            inorderPrint(root.getLeft());
        }
        System.out.print(root.getData() + " ");
        if (root.getRight() != null) {
            inorderPrint(root.getRight());
        }
    }
}
