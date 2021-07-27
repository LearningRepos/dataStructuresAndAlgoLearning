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

public class lab4main {
    public static void main(String[] args) throws IOException {
        //clears file originally
        PrintWriter myWriter = new PrintWriter(new FileWriter("output", false));

        //created 7 nodes of random money value
        LinkedNode node1 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node2 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node3 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node4 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node5 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node6 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        LinkedNode node7 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));

        //creates a LinkedList, Stack, and Queue
        LinkedList moneyList = new LinkedList();
        Stack moneyStack = new Stack();
        Queue moneyQueue = new Queue();

        //performs various operations on moneyList LinkedList
        System.out.println("Adding node 1 to list");
        moneyList.addToList(node1);
        moneyList.printList();

        System.out.println("Checks to see if node 1 exists");
        System.out.println("Node 1 Exists " + moneyList.linkedNodeExists(node1));
        System.out.println();

        System.out.println("Adding node 2,3,4 to list");
        moneyList.addToList(node2);
        moneyList.addToList(node3);
        moneyList.addToList(node4);
        moneyList.printList();

        System.out.println("Checks Node at index 3");
        moneyList.findFromList(3).data.printCurrency();
        System.out.println();

        System.out.println("Adds node 5,6,7 to list");
        moneyList.addToList(node5);
        moneyList.addToList(node6);
        moneyList.addToList(node7);
        moneyList.printList();

        System.out.println("Deletes the head and tail from the list");
        moneyList.deleteFromList(node1);
        moneyList.deleteFromList(node7);
        moneyList.printList();

        //creates new nodes for stack
        node1 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node2 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node3 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node4 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node5 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node6 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node7 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        //performs various operations on moneyStack Stack
        System.out.println("Adding node 7 to stack");
        moneyStack.push(node7);
        moneyStack.printStack();

        System.out.println("Peeking node 7 from the stack");
        moneyStack.peek().data.printCurrency();
        System.out.println();

        System.out.println("Adding node 6,5,4 to stack");
        moneyStack.push(node6);
        moneyStack.push(node5);
        moneyStack.push(node4);
        moneyStack.printStack();

        System.out.println("Popping node 4 and 5 from the stack");
        moneyStack.pop().data.printCurrency();
        moneyStack.pop().data.printCurrency();
        moneyStack.printStack();

        System.out.println("Adding node 3,2,1 to stack");
        moneyStack.push(node3);
        moneyStack.push(node2);
        moneyStack.push(node1);
        moneyStack.printStack();

        System.out.println("Peeking from stack");
        moneyStack.peek().data.printCurrency();
        System.out.println();

        //creates new nodes for queue
        node1 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node2 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node3 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node4 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node5 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node6 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        node7 = new LinkedNode(new money((int) Math.floor(Math.random() * 100), (int) Math.floor(Math.random() * 100)));
        //performs various operations on moneyQueue Queue
        System.out.println("Adding nodes 3,2,1 to queue");
        moneyQueue.enqueue(node3);
        moneyQueue.enqueue(node2);
        moneyQueue.enqueue(node1);
        moneyQueue.printQueue();

        System.out.println("Peeking from rear and front of queue");
        moneyQueue.peekFront().data.printCurrency();
        moneyQueue.peekRear().data.printCurrency();
        System.out.println();

        System.out.println("Adding nodes 7,6,5,4 to queue");
        moneyQueue.enqueue(node7);
        moneyQueue.enqueue(node6);
        moneyQueue.enqueue(node5);
        moneyQueue.enqueue(node4);
        moneyQueue.printQueue();

        System.out.println("Dequeueing node 3 from the stack");
        moneyQueue.dequeue();
        moneyQueue.printQueue();
    }
}
