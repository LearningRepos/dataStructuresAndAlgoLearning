import java.io.IOException;

/**
 * Name: Mihir Achyuta
 * Lab Number: 4
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a Linked List, Stack, and Queue with money objects and LinkedNodes and perform
 * various operations on each of these data structures
 **/

public class Stack extends LinkedList {

    //constructor that creates the stack
    public Stack() throws IOException {
        super();
    }

    /**
     * This function adds a LinkedNode to the Stack
     * Pre:
     * nodeToAdd - the LinkedList Node to add to the Stack
     * Post:
     * returns the added LinkedNode
     **/
    public LinkedNode push(LinkedNode nodeToAdd) {
        if (isEmpty()) {
            addToList(nodeToAdd);
        } else {
            nodeToAdd.next = getHead();
            setHead(nodeToAdd);
        }
        return nodeToAdd;
    }

    /**
     * This function deletes a LinkedNode from the Stack(the most recently inserted one)
     * Pre:
     * no input
     * Post:
     * returns the deleted LinkedNode if the node was deleted or null if the Stack is empty
     **/
    public LinkedNode pop() {
        if (isEmpty()) return null;
        else {
            LinkedNode deletedNode = getHead();
            setHead(getHead().next);
            deletedNode.next = null;

            return deletedNode;
        }
    }

    /**
     * This function retrieves the most recently inserted LinkedNode from the Stack
     * Pre:
     * no input
     * Post:
     * returns the LinkedNode or null if the Stack is empty
     **/
    public LinkedNode peek() {
        if (isEmpty()) return null;
        else {
            return getHead();
        }
    }

    /**
     * This function empties/destroys the stack
     * Pre:
     * no input
     * Post:
     * sets the head and tail to null and the length to 0
     **/
    public void destroyStack() {
        destroy();
    }

    /**
     * This function prints a detailed version of the Stack Data structure by traversing the entire Queue
     * Pre:
     * no input
     * Post:
     * returns nothing as it is void but prints a line in the format : currencyNoteValue currencyNoteName currencyCoinValue currencyCoinName
     **/
    public void printStack() throws IOException {
        LinkedNode currNode = getHead();
        System.out.println("Printing Current Stack");
        myWriter.write("Printing Current Stack");
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
