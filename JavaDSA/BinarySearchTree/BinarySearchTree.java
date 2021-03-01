package JavaDSA.BinarySearchTree;

public class BinarySearchTree {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(50);
        bst.add(75);
        bst.add(25);
        bst.add(30);
        bst.add(20);
        bst.add(80);
        bst.add(60);
        System.out.println(bst.find(60));
    }

    Node root;

    public class Node {
        int value;
        Node left = null;
        Node right = null;

        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        Node traverseNode = root;
        Node insertedNode = new Node(value);
        if (root == null) {
            root = insertedNode;
        } else {
            while (true) {
                if (insertedNode.value < traverseNode.value) {
                    if (traverseNode.left == null) {
                        traverseNode.left = insertedNode;
                        break;
                    } else {
                        traverseNode = traverseNode.left;
                    }
                } else {
                    if (traverseNode.right == null) {
                        traverseNode.right = insertedNode;
                        break;
                    } else {
                        traverseNode = traverseNode.right;
                    }
                }
            }
        }
    }

    public boolean find(int value) {
        Node traverseNode = root;
        if (traverseNode == null) {
            return false;
        }
        while (true) {
            if (traverseNode.value == value) {
                return true;
            } else if (traverseNode.left == null && traverseNode.right == null) {
                return false;
            } else if (value < traverseNode.value) {
                if (traverseNode.left == null) {
                    return false;
                } else {
                    traverseNode = traverseNode.left;
                }
            } else {
                if (traverseNode.right == null) {
                    return false;
                } else {
                    traverseNode = traverseNode.right;
                }
            }
        }
    }

}
