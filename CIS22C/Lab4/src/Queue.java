import java.io.IOException;

/**
 * Name: Mihir Achyuta
 * Lab Number: 4
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a Linked List, Stack, and Queue with money objects and LinkedNodes and perform
 * various operations on each of these data structures+
 **/

public class Queue extends LinkedList {
    //constructor that creates the queue
    public Queue() throws IOException {
        super();
    }

    /**
     * This function adds a LinkedNode to the queue
     * Pre:
     * nodeToAdd - the node to add to the end of the queue
     * Post:
     * adds a node to the end of the queue and returns the added LinkedNode
     **/
    public LinkedNode enqueue(LinkedNode nodeToAdd) {
        addToList(nodeToAdd);

        return nodeToAdd;
    }

    /**
     * This function removes the oldest(earliest inserted) LinkedNode from the queue
     * Pre:
     * no input
     * Post:
     * removes the oldest(earliest inserted) LinkedNode from the queue and returns the deleted LinkedNode
     **/
    public LinkedNode dequeue() {
        if (isEmpty()) return null;
        else {
            LinkedNode deletedNode = getHead();
            setHead(getHead().next);
            deletedNode.next = null;

            return deletedNode;
        }
    }

    /**
     * This function retrieved the oldest(earliest inserted) LinkedNode from the queue
     * Pre:
     * no input
     * Post:
     * returns the LinkedNode or null if the Queue is empty
     **/
    public LinkedNode peekFront() {
        if (isEmpty()) return null;

        return getHead();
    }

    /**
     * This function retrieved the youngest(latest inserted) LinkedNode from the queue
     * Pre:
     * no input
     * Post:
     * returns the LinkedNode or null if the Queue is empty
     **/
    public LinkedNode peekRear() {
        if (isEmpty()) return null;

        return getTail();
    }

    /**
     * This function empties/destroys the queue
     * Pre:
     * no input
     * Post:
     * sets the head and tail to null and the length to 0
     **/
    public void destroyQueue() {
        destroy();
    }

    /**
     * This function prints a detailed version of the Queue Data structure by traversing the entire Queue
     * Pre:
     * no input
     * Post:
     * returns nothing as it is void but prints a line in the format : currencyNoteValue currencyNoteName currencyCoinValue currencyCoinName
     **/
    public void printQueue() throws IOException {
        LinkedNode currNode = getHead();
        System.out.println("Printing Current Queue");
        myWriter.write("Printing Current Queue");
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
