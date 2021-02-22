package JavaDSA.Queue;

public class Queue {
    Node head;
    Node tail;

    public class Node {
        Node next = null;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void printQueue() {
        Node traverseNode = head;
        if (traverseNode == null) {
            System.out.println(traverseNode);
        } else {
            while (traverseNode.next != null) {
                System.out.println(traverseNode.value);
                traverseNode = traverseNode.next;
            }
            System.out.println(traverseNode.value);
        }
    }

    public int push(int value) {
        Node insertionNode = new Node(value);
        if (head == null && tail == null) {
            head = insertionNode;
            tail = insertionNode;
        } else {
            tail.next = insertionNode;
            tail = insertionNode;
        }
        return insertionNode.value;
    }

    public int pop() {
        Node deletedNode = head;
        if (head == null) {
            System.out.println("No elements in queue");
        } else {
            head = deletedNode.next;
            deletedNode.next = null;
            if (head == null) {
                tail = null;
            }
        }
        return deletedNode.value;
    }
}
