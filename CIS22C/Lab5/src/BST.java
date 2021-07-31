import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;

public class BST {
    private BSTNode root;

    public BST() {
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

        while (!moneyQueue.isEmpty()) {
            int size = moneyQueue.size();

            for (int i = 0; i < size; i++) {
                BSTNode currNode = moneyQueue.poll();
                currNode.getData().printCurrency();

                if (currNode.getLeft() != null) moneyQueue.offer(currNode.getLeft());
                if (currNode.getRight() != null) moneyQueue.offer(currNode.getRight());
            }
        }
        System.out.println();
    }

    public void inOrder() {
        System.out.println("Performing Depth First Search InOrder Traversal");
        inOrderHelper(getRoot());
        System.out.println();
    }

    public void inOrderHelper(BSTNode root) {
        if (root.getLeft() != null) inOrderHelper(root.getLeft());
        root.getData().printCurrency();
        if (root.getRight() != null) inOrderHelper(root.getRight());
    }

    public void preOrder() {
        System.out.println("Performing Depth First Search PreOrder Traversal");
        preOrderHelper(getRoot());
        System.out.println();
    }

    public void preOrderHelper(BSTNode root) {
        root.getData().printCurrency();
        if (root.getLeft() != null) preOrderHelper(root.getLeft());
        if (root.getRight() != null) preOrderHelper(root.getRight());
    }

    public void postOrder() {
        System.out.println("Performing Depth First Search PostOrder Traversal");
        postOrderHelper(getRoot());
        System.out.println();
    }

    public void postOrderHelper(BSTNode root) {
        if (root.getLeft() != null) postOrderHelper(root.getLeft());
        if (root.getRight() != null) postOrderHelper(root.getRight());
        root.getData().printCurrency();
    }
}
