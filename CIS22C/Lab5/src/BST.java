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
    //bst has a root(start) and printwriter for writing to file
    private BSTNode root;
    private PrintWriter myWriter = new PrintWriter(new FileWriter("output.txt", false));
    private int count = 0;

    public BST() throws IOException {
    }

    /**
     * These functions get the root and count bstnode/int attributes
     * Pre:
     * no input
     * Post:
     * returns root/count depending on the getter function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm getRoot/Count()
     *      return root/count
     **/
    public BSTNode getRoot() {
        return root;
    }

    public int getCount() {
        return count;
    }

    /**
     * These functions set the root/count bstnode/int attributes
     * Pre:
     * root - the root of the binary search tree
     * count - the numebr of nodes in the bst
     * Post:
     * returns nothing as void but sets the new data to the one in the parameter
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm setRoot/Count(root/count)
     *      this.root/count = root/count
     **/
    public void setRoot(BSTNode root) {
        this.root = root;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * These functions check if the bst is empty and empty the bst
     * Pre:
     * no input
     * Post:
     * returns boolean if bst is empty or returns nothignas void but sets the root to null and count to 0
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm setData/Left/Right(data/left/right)
     *      return data/left/right
     **/
    public boolean isEmpty() {
        return getCount() == 0;
    }

    public void empty() {
        setRoot(null);
        setCount(0);
    }

    /**
     * This function inserts a node into the bst
     * Pre:
     * nodeToInsert - the bst node to insert
     * Post:
     * returns the bst node added
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm insert(nodetoinsert)
     *      if root null make root the inserted node
     *      else
     *          currNode = getRoot()
     *
     *          while(true)
     *              if currNode greater than insertedNode
     *                  if left child empty insert node at left and break
     *                  else go left
     *             if currNode less than or equal to insertedNode and break
     *                  if right child empty insert node at right and break
     *                  else go right
     **/
    public BSTNode insert(BSTNode nodeToInsert) throws IOException {
        if (getRoot() == null) {
            setRoot(nodeToInsert);
        } else {
            //node to traverse bst
            BSTNode currNode = getRoot();

            while (true) {
                //if currnode greater than inserted node place left if there is space else go left
                if (currNode.getData().isCurrencyGreaterBool(nodeToInsert.getData())) {
                    if (currNode.getLeft() == null) {
                        currNode.setLeft(nodeToInsert);
                        break;
                    } else {
                        currNode = currNode.getLeft();
                    }
                }
                //if currnode less than or equal to inserted node place right if there is space else go right
                else {
                    if (currNode.getRight() == null) {
                        currNode.setRight(nodeToInsert);
                        break;
                    } else {
                        currNode = currNode.getRight();
                    }
                }
            }
        }

        setCount(getCount()+1);
        return nodeToInsert;
    }

    /**
     * This function searches if a node exits in the bst
     * Pre:
     * nodeToFind - the bst node tofind
     * Post:
     * returns the bst node if exists or null
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm search(nodetofind)
     *      if root null return null
     *      else
     *          currNode = getRoot
     *
     *          while(currNode not null)
     *              if currNode equal to nodetofind return nodeToFind
     *              else if currNode greater than nodetofind go left
     *              else fo right
     **/
    public BSTNode search(BSTNode nodeToFind) {
        if (getRoot() == null) {
            return null;
        } else {
            //node to traverse bst
            BSTNode currNode = getRoot();

            while (currNode != null) {
                //if currnode equal to findnode return nodetofing
                if (currNode.getData().areCurrencyEqualBool(nodeToFind.getData())) {
                    return nodeToFind;
                }
                //if currnode greater than findnode go left
                else if (currNode.getData().isCurrencyGreaterBool(nodeToFind.getData())) {
                    currNode = currNode.getLeft();
                }
                //if currnode less than or equal to findnode go right
                else {
                    currNode = currNode.getRight();
                }
            }
        }

        //if node not found return null
        return null;
    }

    /**
     * This function deletes a bst node if it exists
     * Pre:
     * nodeToDelete - the node to delete from the bst
     * Post:
     * returns bst node if the deleted node exists in the tree else returns null
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm delete(nodeToDelete)
     *      prevNode and currNode = getRoot()
     *      while(currNode not null and not equal to deletedNode)
     *          preNode = currNode and currNode go left if greater than deletedNode else go right
     *      return root if currNode null
     *
     *      if currNode has no left or right child node
     *          if currNode not root
     *              if prevNode left is currNode set prevNode left to null
     *              else set prevNode right to null
     *          else set root to null
     *      if currNode has 2 child nodes
     *          find the leftmost right node(successor)
     *          delete that successor
     *          set currNode to suceessor data
     *      if currNode has 1 child node
     *          get the non null node
     *          if currNode not equal to root
     *              setPrev left node to child if currNode equals parent left
     *              else setPrev right node to child
     *          else set prevNode to child
     **/
    public BSTNode delete(BSTNode nodeToDelete)
    {
        BSTNode prevNode = null;
        BSTNode currNode = getRoot();

        while (currNode != null && !currNode.getData().areCurrencyEqualBool(nodeToDelete.getData()))
        {
            prevNode = currNode;
            if (currNode.getData().isCurrencyGreaterBool(nodeToDelete.getData())) {
                currNode = currNode.getLeft();
            }
            else {
                currNode = currNode.getRight();
            }
        }

        if (currNode == null) {
            return root;
        }

        // remove node if no children
        if (currNode.getLeft() == null && currNode.getRight()== null)
        {
            if (!currNode.getData().areCurrencyEqualBool(getRoot().getData()))
            {
                if (prevNode.getLeft().getData().areCurrencyEqualBool(currNode.getData())) {
                    prevNode.setLeft(null);
                }
                else {
                    prevNode.setRight(null);
                }
            }
            else {
                root = null;
            }
        }

        // remove node if it has 2 children
        else if (currNode.getLeft() != null && currNode.getRight() != null)
        {
            BSTNode successor = currNode.getRight();
            while (successor.getLeft() != null) {
                successor.setLeft(successor.getLeft());
            }

            money m = successor.getData();
            delete(successor);
            currNode.setData(m);
        }

        //set the previous node to be the only 1 child node if the node only has 1 child
        else {
            BSTNode child = (currNode.getLeft() != null)? currNode.getLeft(): currNode.getRight();

            if (!currNode.getData().areCurrencyEqualBool(getRoot().getData()))
            {
                if (currNode.getData().areCurrencyEqualBool(prevNode.getLeft().getData())) {
                    prevNode.setLeft(child);
                }
                else {
                    prevNode.setRight(child);
                }
            }

            else {
                setRoot(child);
            }
        }

        return root;
    }

    /**
     * This function prints the bst by executing the breadth first search traversal method
     * Pre:
     * none
     * Post:
     * returns nothing as void but calls the method which performs a breadth first traversal on the tree
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm printBST()
     *      bfs()
     **/
    public void printBST() throws IOException {
        bfs();
    }

    /**
     * This function executes the breadth first search traversal method
     * Pre:
     * none
     * Post:
     * returns nothing as void but performs a breadth first traversal on the tree
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm bfs()
     * queue q;
     *
     * add root to queue
     * print "perfoming breadth first search traversal"
     *
     * while(q not empty)
     *      size = q size
     *
     *      loop over size 0 to size
     *          dequeue node
     *          print node
     *          add left child node to queue if exists
     *          add right child node if exists
     **/
    public void bfs() throws IOException {
        Queue<BSTNode> moneyQueue = new ArrayDeque<>();
        moneyQueue.offer(root);
        System.out.println("Performing Breadth First Search Traversal");
        myWriter.write("Performing Breadth First Search Traversal");
        myWriter.write(System.getProperty("line.separator"));

        //while queue is empty get node, print it and add its children
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

    /**
     * This function executes the inorder depth first search traversal method
     * Pre:
     * none
     * Post:
     * returns nothing as void calls the inOrderHelper function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm inOrder()
     *      print "performing inorder traversal"
     *      inOrderHelper(getRoot())
     **/
    public void inOrder() {
        System.out.println("Performing Depth First Search InOrder Traversal");
        myWriter.write("Performing Depth First Search InOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        inOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    /**
     * This function performs an in order depth first search recursively
     * Pre:
     * root - the BSTNode of the binary search tree
     * Post:
     * returns nothing as void but prints the tree in an in order fashion
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm inOrderHelper(BSTNode root)
     *      if leftChildExists inOrderHelper(BSTNode root.left)
     *      print node
     *      if rightChildExists inOrderHelper(BSTNode root.right)
     **/
    public void inOrderHelper(BSTNode root) {
        //traverse left subtree, print node, traverse right subtree
        if (root.getLeft() != null) inOrderHelper(root.getLeft());

        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));

        if (root.getRight() != null) inOrderHelper(root.getRight());
    }

    /**
     * This function executes the preorder depth first search traversal method
     * Pre:
     * none
     * Post:
     * returns nothing as void calls the preOrderHelper function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm preOrder()
     *      print "performing preorder traversal"
     *      preOrderHelper(getRoot())
     **/
    public void preOrder() {
        System.out.println("Performing Depth First Search PreOrder Traversal");
        myWriter.write("Performing Depth First Search PreOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        preOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    /**
     * This function performs a preorder depth first search recursively
     * Pre:
     * root - the BSTNode of the binary search tree
     * Post:
     * returns nothing as void but prints the tree in a preorder fashion
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm preOrderHelper(BSTNode root)
     *      print node
     *      if leftChildExists preOrderHelper(BSTNode root.left)
     *      if rightChildExists preOrderHelper(BSTNode root.right)
     **/
    public void preOrderHelper(BSTNode root) {
        //print node, traverse left subtree, traverse right subtree
        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));

        if (root.getLeft() != null) preOrderHelper(root.getLeft());
        if (root.getRight() != null) preOrderHelper(root.getRight());
    }

    /**
     * This function executes the post order depth first search traversal method
     * Pre:
     * none
     * Post:
     * returns nothing as void calls the postOrderHelper function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm postOrder()
     *      print "performing postorder traversal"
     *      postOrderHelper(getRoot())
     **/
    public void postOrder() {
        System.out.println("Performing Depth First Search PostOrder Traversal");
        myWriter.write("Performing Depth First Search PostOrder Traversal");
        myWriter.write(System.getProperty("line.separator"));

        postOrderHelper(getRoot());

        System.out.println();
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
    }

    /**
     * This function performs a post order depth first search recursively
     * Pre:
     * root - the BSTNode of the binary search tree
     * Post:
     * returns nothing as void but prints the tree in a post order fashion
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm postOrderHelper(BSTNode root)
     *      if leftChildExists postOrderHelper(BSTNode root.left)
     *      if rightChildExists postOrderHelper(BSTNode root.right)
     *      print node
     **/
    public void postOrderHelper(BSTNode root) {
        //traverse left subtree, traverse right subtree, print node
        if (root.getLeft() != null) postOrderHelper(root.getLeft());
        if (root.getRight() != null) postOrderHelper(root.getRight());

        root.getData().printCurrency();
        myWriter.write(root.getData().getCurrencyNoteValue() + " Dollar " + root.getData().getCurrencyCoinValue() + " Cent");
        myWriter.write(System.getProperty("line.separator"));
    }
}
