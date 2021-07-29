import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Name: Mihir Achyuta
 * Lab Number: 4
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a Linked List, Stack, and Queue with money objects and LinkedNodes and perform
 * various operations on each of these data structures
 **/

public class LinkedList {
    //count, head, tail private data attributes
    private int count;
    private LinkedNode head;
    private LinkedNode tail;
    PrintWriter myWriter = new PrintWriter(new FileWriter("output", true));

    /**
     * These functions get the private attributes and return them
     * Pre:
     * no input
     * Post:
     * return an integer or LinkedNode depending on the getter function
     **/
    public int getCount() {
        return count;
    }

    public LinkedNode getHead() {
        return head;
    }

    public LinkedNode getTail() {
        return tail;
    }

    /**
     * These functions set the private attributes
     * Pre:
     * count, head, tail - the new count, head, tail to set
     * Post:
     * sets the LinkedList count, head, tail to the provided new one
     **/
    public void setCount(int count) {
        this.count = count;
    }

    public void setHead(LinkedNode head) {
        this.head = head;
    }

    public void setTail(LinkedNode tail) {
        this.tail = tail;
    }

    //constructor for creating a Linked List
    LinkedList() throws IOException {
    }

    /**
     * This function destroys a LinkedList by setting everything back to null and 0
     * Pre:
     * no input
     * Post:
     * sets the LinkedList head and tail to null and the length to 0
     **/
    public void destroy() {
        //reset everything
        setCount(0);
        setHead(null);
        setTail(null);
    }

    /**
     * This function adds a LinkedNode to the end of the LinkedList
     * Pre:
     * nodeToAdd - the LinkedList Node to add to the end of the LinkedList
     * Post:
     * returns the added LinkedNode
     **/
    public LinkedNode addToList(LinkedNode nodeToAdd) {
        //set head and tail to node if empty else append to end
        if (getHead() == null) {
            setHead(nodeToAdd);
            setTail(nodeToAdd);
        } else {
            LinkedNode tail = getTail();
            tail.next = nodeToAdd;
            setTail(tail.next);
        }
        setCount(getCount() + 1);

        return nodeToAdd;
    }

    /**
     * This function deletes a LinkedNode from a Linked List
     * Pre:
     * nodeToDelete - the LinkedList Node to delete from the Linked List
     * Post:
     * returns the deleted LinkedNode if the node was deleted or null if the LinkedNode is not in the array
     **/
    public LinkedNode deleteFromList(LinkedNode nodeToDelete) {
        //if node exists then delete
        if (linkedNodeExists(nodeToDelete) && !isEmpty()) {
            //destroy list if 1 node
            if (getHead().next == null) {
                LinkedNode deletedNode = getHead();
                destroy();

                return deletedNode;
            }
            //if node is head then remove head and make new head
            else if (nodeToDelete.data.getCurrencyNoteValue() == getHead().data.getCurrencyNoteValue()) {
                if (nodeToDelete.data.getCurrencyCoinValue() == getHead().data.getCurrencyCoinValue()) {
                    LinkedNode deletedNode = getHead();
                    setHead(getHead().next);
                    deletedNode.next = null;

                    return deletedNode;
                }
            }
            //if node tail remove tail and reassign new tail
            else if (nodeToDelete.data.getCurrencyNoteValue() == getTail().data.getCurrencyNoteValue()) {
                if (nodeToDelete.data.getCurrencyCoinValue() == getTail().data.getCurrencyCoinValue()) {
                    LinkedNode currNode = getHead();
                    while (currNode.next != getTail()) {
                        currNode = currNode.next;
                    }

                    currNode.next = null;
                    setTail(currNode);

                    return nodeToDelete;
                }
            }
            //else navigate to deleted node and set prevNode to nextNode
            else {
                LinkedNode currNode = getHead();
                LinkedNode prevNode = null;
                LinkedNode nextNode = null;

                while (currNode.data.getCurrencyNoteValue() != nodeToDelete.data.getCurrencyNoteValue() &&
                        currNode.data.getCurrencyCoinValue() != nodeToDelete.data.getCurrencyCoinValue()) {
                    nextNode = currNode.next;
                    prevNode = currNode;
                    currNode = currNode.next;
                }

                prevNode.next = nextNode;
                currNode.next = null;

                return currNode;
            }

            setCount(getCount() - 1);
        }

        return null;
    }

    /**
     * This function checks to see if an item exists in LinkedList
     * Pre:
     * nodeToFind - the LinkedList Node to find in the LinkedList
     * Post:
     * returns true if the LinkedNode is in the data and false if it isnt
     **/
    public boolean linkedNodeExists(LinkedNode nodeToFind) {
        LinkedNode currNode = getHead();

        //traverse list and check each value for equivalency
        while (currNode != null) {
            if (nodeToFind.data.getCurrencyNoteValue() == currNode.data.getCurrencyNoteValue()) {
                if (nodeToFind.data.getCurrencyCoinValue() == currNode.data.getCurrencyCoinValue()) {
                    return true;
                }
            }
            currNode = currNode.next;
        }

        return false;
    }

    /**
     * This function finds an item of the Linked List by index
     * Pre:
     * index - linked list index to get data
     * Post:
     * returns the LinkedNode found at the index or null if the index is out of bounds
     **/
    public LinkedNode findFromList(int index) {
        //checks for out of bounds errors
        if (index >= getLength() || index < 0) return null;
        LinkedNode currNode = getHead();

        //traverses until but not until index to get the currentNode at the index
        for (int i = 0; i < index; i++) {
            if (currNode == null) return null;
            currNode = currNode.next;
        }

        return currNode;
    }

    /**
     * This function gets the length of a Linked List
     * Pre:
     * no input
     * Post:
     * returns an integer corresponding to the List's length/count
     **/
    public int getLength() {
        return getCount();
    }

    /**
     * This function checks if the Linked List is empty by checking its length
     * Pre:
     * no input
     * Post:
     * returns a boolean value true if the list is empty(0 length size) and false if the list is not empty
     **/
    public boolean isEmpty() {
        return getCount() == 0;
    }

    /**
     * This function prints a detailed version of the Linked List Data structure by traversing the entire List
     * Pre:
     * no input
     * Post:
     * returns nothing as it is void but prints a line in the format : currencyNoteValue currencyNoteName currencyCoinValue currencyCoinName
     **/
    public void printList() throws IOException {
        LinkedNode currNode = getHead();
        System.out.println("Printing Current LinkedList");
        myWriter.write("Printing Current LinkedList");
        myWriter.write(System.getProperty("line.separator"));

        //print as long as node is not null
        while (currNode != null) {
            currNode.data.printCurrency();
            myWriter.write(currNode.data.getCurrencyNoteValue() + " Dollar " + currNode.data.getCurrencyCoinValue() + " Cent");
            myWriter.write(System.getProperty("line.separator"));
            currNode = currNode.next;
        }
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
        System.out.println();
    }
}