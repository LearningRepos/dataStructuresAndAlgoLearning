package JavaDSA.Stack;

public class Stack {
    Node head;

    public class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public void printStack() {
        Node traverseNode = head;
        while (traverseNode.next != null) {
            System.out.println(traverseNode.value);
            traverseNode = traverseNode.next;
        }
        System.out.println(traverseNode.value);
    }

    public int push(int value) {
        Node insertionNode = new Node(value);
        insertionNode.next = head;
        head = insertionNode;
        return insertionNode.value;
    }

    public int pop() {
        Node deletedNode = head;
        head = deletedNode.next;
        deletedNode.next = null;
        return deletedNode.value;
    }
}
