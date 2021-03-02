import java.util.ArrayDeque;
import java.util.Stack;

public class BST {
    public static void main(String args[]) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(50);
        bst.add(75);
        bst.add(25);
        bst.add(30);
        bst.add(20);
        bst.add(80);
        bst.add(60);
        // bst.bfsIter(bst.root);
        // bst.dfsPreIter(bst.root);
        // bst.dfsPreorderRecur(bst.root);
        // bst.dfsInorderIter(bst.root);
        // bst.dfsInOrderRecur(bst.root);
        // bst.dfsPostOrderIter(bst.root);
        // bst.dfsPostOrderRecur(bst.root);
    }

    static class BinarySearchTree {
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
            Node previousNode = null;

            while (traverseNode != null) {
                previousNode = traverseNode;
                if (value < traverseNode.value) {
                    traverseNode = traverseNode.left;
                } else {
                    traverseNode = traverseNode.right;
                }
            }

            if (previousNode == null) {
                root = new Node(value);
            } else if (value < previousNode.value) {
                previousNode.left = new Node(value);
            } else {
                previousNode.right = new Node(value);
            }
        }

        public boolean find(int value) {
            Node traverseNode = root;
            boolean found = false;
            while (traverseNode != null && !found) {
                if (traverseNode.value == value) {
                    found = true;
                } else if (value < traverseNode.value) {
                    traverseNode = traverseNode.left;
                } else {
                    traverseNode = traverseNode.right;
                }
            }
            return found;
        }

        public void bfsIter(Node traverseNode) {
            if (traverseNode != null) {
                ArrayDeque<Node> q = new ArrayDeque();
                q.add(traverseNode);
                while (q.size() > 0) {
                    Node currNode = q.poll();
                    System.out.println(currNode.value);
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
            }
        }

        public void dfsPreIter(Node traverseNode) {
            if (traverseNode != null) {
                Stack<Node> s = new Stack();
                s.add(traverseNode);
                while (s.size() > 0) {
                    Node currNode = s.pop();
                    System.out.println(currNode.value);
                    if (currNode.right != null) {
                        s.add(currNode.right);
                    }
                    if (currNode.left != null) {
                        s.add(currNode.left);
                    }
                }
            }
        }

        public void dfsPreorderRecur(Node traverseNode) {
            if (traverseNode != null) {
                System.out.println(traverseNode.value);
                dfsPreorderRecur(traverseNode.left);
                dfsPreorderRecur(traverseNode.right);
            }
        }

        public void dfsInorderIter(Node traverseNode) {
            if (traverseNode != null) {
                Stack<Node> s = new Stack();
                s.add(traverseNode);

                while (traverseNode.left != null) {
                    s.add(traverseNode.left);
                    traverseNode = traverseNode.left;
                }

                while (s.size() > 0) {
                    Node currNode = s.pop();
                    System.out.println(currNode.value);
                    if (currNode.right != null) {
                        s.add(currNode.right);
                    }
                }
            }
        }

        public void dfsInOrderRecur(Node traverseNode) {
            if (traverseNode != null) {
                dfsInOrderRecur(traverseNode.left);
                System.out.println(traverseNode.value);
                dfsInOrderRecur(traverseNode.right);
            }
        }

        public void dfsPostOrderIter(Node traverseNode) {
            if (traverseNode != null) {
                Stack<Node> s1 = new Stack();
                Stack<Node> s2 = new Stack();
                s1.add(traverseNode);

                while (s1.size() > 0) {
                    Node currNode = s1.pop();
                    s2.add(currNode);
                    if (currNode.left != null) {
                        s1.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        s1.add(currNode.right);
                    }
                }

                while (s2.size() > 0) {
                    System.out.println(s2.pop().value);
                }
            }
        }

        public void dfsPostOrderRecur(Node traverseNode) {
            if (traverseNode != null) {
                dfsPostOrderRecur(traverseNode.left);
                dfsPostOrderRecur(traverseNode.right);
                System.out.println(traverseNode.value);
            }
        }
    }

}