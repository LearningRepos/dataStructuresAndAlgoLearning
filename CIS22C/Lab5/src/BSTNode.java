/**
 * Name: Mihir Achyuta
 * Lab Number: 5
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a BST and a BSTNode ADT containing money objects and to perform various traversals on the BST tree
 * along with allowing the user to insert, delete, and search nodes in the BST.
 **/

public class BSTNode {
    private money data;
    private BSTNode left;
    private BSTNode right;

    BSTNode(money data) {
        this.data = data;
    }

    public money getData() {
        return data;
    }

    public void setData(money data) {
        this.data = data;
    }

    public BSTNode getLeft() {
        return left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
