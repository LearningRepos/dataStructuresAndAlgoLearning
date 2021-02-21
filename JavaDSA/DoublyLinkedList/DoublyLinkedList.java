public class DoublyLinkedList {
    Node head = null;
    Node tail = null;
    int length = 0;

    class Node {
        int val;
        Node next = null;
        Node prev = null;

        Node(int val) {
            this.val = val;
        }
    }

    public void printList() {
        Node traverseNode = head;
        for (int i = 0; i < length; i++) {
            System.out.println(traverseNode.val);
            traverseNode = traverseNode.next;
        }
    }

    public int getByIndex(int index) {
        int midNodeIdx = length / 2;
        if (index <= midNodeIdx) {
            Node traverseNode = head;
            for (int i = 0; i < index; i++) {
                traverseNode = traverseNode.next;
            }
            return traverseNode.val;
        } else {
            Node traverseNode = tail;
            for (int i = length - 1; i > index; i--) {
                traverseNode = traverseNode.prev;
            }
            return traverseNode.val;
        }
    }

    public void setByIndex(int val, int index) {
        int midNodeIdx = length / 2;
        if (index <= midNodeIdx) {
            Node traverseNode = head;
            for (int i = 0; i < index; i++) {
                traverseNode = traverseNode.next;
            }
            traverseNode.val = val;
        } else {
            Node traverseNode = tail;
            for (int i = length - 1; i > index; i--) {
                traverseNode = traverseNode.prev;
            }
            traverseNode.val = val;
        }
    }

    public void addToFront(int val) {
        Node insertedNode = new Node(val);
        if (length == 0) {
            head = insertedNode;
            tail = insertedNode;
        } else {
            tail.next = insertedNode;
            insertedNode.prev = tail;
            tail = insertedNode;
        }
        length++;
    }

    public void addToBack(int val) {
        Node insertedNode = new Node(val);
        if (length == 0) {
            head = insertedNode;
            tail = insertedNode;
        } else {
            head.prev = insertedNode;
            insertedNode.next = head;
            head = insertedNode;
        }
        length++;
    }

    public void deleteFromFront() {
        if (length <= 0) {
            System.out.println("Nothing in list");
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node futureTail = tail.prev;
            futureTail.next = null;
            tail.prev = null;
            tail = futureTail;
        }
        length--;
    }

    public void deleteFromBack() {
        if (length <= 0) {
            System.out.println("Nothing in list");
        } else if (length == 1) {
            head = null;
            tail = null;
        } else {
            Node futureHead = head.next;
            futureHead.prev = null;
            head.next = null;
            head = futureHead;
        }
        length--;
    }

    public void addByIndex(int val, int index) {
        if (index == 0) {
            addToBack(val);
        } else if (index == length) {
            addToFront(val);
        } else {
            Node beforeNode = head;
            Node insertionNode = new Node(val);
            for (int i = 0; i < index - 1; i++) {
                beforeNode = beforeNode.next;
            }
            Node afterNode = beforeNode.next;

            beforeNode.next = insertionNode;
            insertionNode.prev = beforeNode;
            insertionNode.next = afterNode;
            afterNode.prev = insertionNode;
            length++;
        }
    }

    public void deleteByIndex(int index) {
        if (index == 0) {
            deleteFromBack();
        } else if (index == length - 1) {
            deleteFromFront();
        } else {
            Node beforeNode = head;
            for (int i = 0; i < index - 1; i++) {
                beforeNode = beforeNode.next;
            }
            Node deleteNode = beforeNode.next;
            Node afterNode = deleteNode.next;

            beforeNode.next = null;
            deleteNode.prev = null;

            afterNode.prev = null;
            deleteNode.next = null;

            beforeNode.next = afterNode;
            afterNode.prev = beforeNode;
            length--;
        }
    }
}