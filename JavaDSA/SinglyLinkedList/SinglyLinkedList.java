package JavaDSA.SinglyLinkedList;

public class SinglyLinkedList {
	Node head;

	class Node {
		int val;
		Node next = null;

		Node(int val) {
			this.val = val;
		}
	}

	public void printList() {
		Node traverseNode = head;
		while (traverseNode.next != null) {
			System.out.println(traverseNode.val);
			traverseNode = traverseNode.next;
		}
		System.out.println(traverseNode.val);
	}

	public int getByIndex(int index) {
		Node traverseNode = head;
		for (int i = 0; i < index; i++) {
			traverseNode = traverseNode.next;
		}
		return traverseNode.val;
	}

	public void setByIndex(int index, int value) {
		Node traverseNode = head;
		for (int i = 0; i < index; i++) {
			traverseNode = traverseNode.next;
		}
		traverseNode.val = value;
	}

	public int addFront(int val) {
		// 1 2 3 4 5 add:6
		// 1 2 3 4 5 6
		Node traverseNode = head;
		if (traverseNode == null) {
			head = new Node(val);
		} else {
			while (traverseNode.next != null) {
				traverseNode = traverseNode.next;
			}
			traverseNode.next = new Node(val);
		}
		return val;
	}

	public int addBack(int val) {
		Node insertionNode = new Node(val);
		insertionNode.next = head;
		head = insertionNode;
		return val;
	}

	public int addAtIndex(int val, int index) {
		int i = 0;
		Node beforeNode = head;
		if (index == 0) {
			addBack(val);
		} else {
			while (i < index - 1) {
				beforeNode = beforeNode.next;
				i++;
			}
			Node afterNode = beforeNode.next;
			Node newNode = new Node(val);

			beforeNode.next = newNode;
			newNode.next = afterNode;
		}
		return val;
	}

	public int removeBack() {
		Node removedNode = head;
		head = removedNode.next;
		removedNode.next = null;
		return removedNode.val;
	}

	public int removeFront() {
		Node traverseNode = head;
		Node endNode = head;
		int i = 0;
		while (traverseNode.next != null) {
			i++;
			traverseNode = traverseNode.next;
		}
		for (int j = 0; j < i - 1; j++) {
			endNode = endNode.next;
		}
		endNode.next = null;
		return traverseNode.val;
	}
}
