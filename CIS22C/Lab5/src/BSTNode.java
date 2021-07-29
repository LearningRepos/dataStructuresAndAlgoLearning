public class BSTNode {
    private money data;
    private BSTNode left;
    private BSTNode right;

    BSTNode(money data, BSTNode left, BSTNode right){
        this.data = data;
        this.left = left;
        this.right = right;
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
