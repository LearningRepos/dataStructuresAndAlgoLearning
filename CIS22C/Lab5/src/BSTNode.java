/**
 * Name: Mihir Achyuta
 * Lab Number: 5
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a BST and a BSTNode ADT containing money objects and to perform various traversals on the BST tree
 * along with allowing the user to insert, delete, and search nodes in the BST.
 **/

public class BSTNode {

    //bstnode has private money object and also has a left and right child bstnode
    private money data;
    private BSTNode left;
    private BSTNode right;

    BSTNode(money data) {
        this.data = data;
    }

    /**
     * These functions get the data, left bstnode and right bstnode attributes
     * Pre:
     * no input
     * Post:
     * returns money/BSTNode depending on the getter function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm getData/Left/Right()
     *      return data/left/right
     **/

    public money getData() {
        return data;
    }

    public BSTNode getLeft() {return left;}

    public BSTNode getRight() {
        return right;
    }

    /**
     * These functions set the data, left bstnode and right bstnode attributes
     * Pre:
     * data - the money object which the BSTNode holds
     * left/right - the left/right child of the BSTNode
     * Post:
     * returns nothing as void but sets the new data to the one in the parameter
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm setData/Left/Right(data/left/right)
     *      this.data/left/right =  data/left/right
     **/

    public void setData(money data) {
        this.data = data;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
