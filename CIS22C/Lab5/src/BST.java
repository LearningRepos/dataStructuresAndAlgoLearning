/**
 * Name: Mihir Achyuta
 * Lab Number: 5
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a BST and a BSTNode ADT containing money objects and to perform various traversals on the BST tree
 * along with allowing the user to insert, delete, and search nodes in the BST.
 **/

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class BST {
    private BSTNode root;
    private PrintWriter myWriter = new PrintWriter(new FileWriter("output.txt", false));

    public BST() throws IOException {
    }

    public BSTNode getRoot() {
        return root;
    }

    public BSTNode insert(BSTNode nodeToInsert) throws IOException {
        if (root == null) {
            root = nodeToInsert;
        } else {
            BSTNode currNode = getRoot();

            while (true) {
                if (currNode.getData().isCurrencyGreaterBool(nodeToInsert.getData())) {
                    if (currNode.getLeft() == null) {
                        currNode.setLeft(nodeToInsert);
                        break;
                    } else {
                        currNode = currNode.getLeft();
                    }
                } else {
                    if (currNode.getRight() == null) {
                        currNode.setRight(nodeToInsert);
                        break;
                    } else {
                        currNode = currNode.getRight();
                    }
                }
            }
        }

        return nodeToInsert;
    }

    public BSTNode search(BSTNode nodeToFind) {
        if (root == null) {
            return null;
        } else {
            BSTNode currNode = getRoot();

            while (currNode != null) {
                if (currNode.getData().areCurrencyEqualBool(nodeToFind.getData())) {
                    return nodeToFind;
                } else if (currNode.getData().isCurrencyGreaterBool(nodeToFind.getData())) {
                    currNode = currNode.getLeft();
                } else {
                    currNode = currNode.getRight();
                }
            }
        }

        return null;
    }

    public BSTNode delete(BSTNode nodeToDelete) {

        return null;
    }

    public void printBST() throws IOException {
        bfs();
    }

    public void bfs() throws IOException {
        Queue<BSTNode> moneyQueue = new ArrayDeque<>();
        moneyQueue.offer(root);
        System.out.println("Performing Breadth First Search Traversal");
        myWriter.write("Performing Breadth First Search Traversal");
        myWriter.write(System.getProperty("line.separator"));

        while (!moneyQueue.isEmpty()) {
            int size = moneyQueue.size();

            for (int i = 0; i < size; i++) {
                BSTNode currNode = moneyQueue.poll();
                currNode.getData().printCurrency();
                myWriter.write(currNode.getData().getCurrencyNoteValue() + " Dollar " + currNode.getData().getCurrencyCoinValue() + " Cent");
                myWriter.write(System.getProperty("line.separator"));

                if (currNode.getLeft() != null) moneyQueue.offer(currNode.getLeft());
                if (currNode.getRight() != null) moneyQueue.offer(currNode.getRight());
            }
        }

        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
        System.out.println();
    }

    public void inOrder() {
        System.out.println("Performing Depth First Search InOrder Traversal");
        myWriter.write("Performing Depth First Search InOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        inOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    public void inOrderHelper(BSTNode root) {
        if (root.getLeft() != null) inOrderHelper(root.getLeft());

        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));

        if (root.getRight() != null) inOrderHelper(root.getRight());
    }

    public void preOrder() {
        System.out.println("Performing Depth First Search PreOrder Traversal");
        myWriter.write("Performing Depth First Search PreOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        preOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    public void preOrderHelper(BSTNode root) {
        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));

        if (root.getLeft() != null) preOrderHelper(root.getLeft());
        if (root.getRight() != null) preOrderHelper(root.getRight());
    }

    public void postOrder() {
        System.out.println("Performing Depth First Search PostOrder Traversal");
        myWriter.write("Performing Depth First Search PostOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        postOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    public void postOrderHelper(BSTNode root) {
        if (root.getLeft() != null) postOrderHelper(root.getLeft());
        if (root.getRight() != null) postOrderHelper(root.getRight());

        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));
    }
}
