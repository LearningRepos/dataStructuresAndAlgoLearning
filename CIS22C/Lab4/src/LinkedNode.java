/**
 * Name: Mihir Achyuta
 * Lab Number: 4
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a Linked List, Stack, and Queue with money objects and LinkedNodes and perform
 * various operations on each of these data structures
 **/

public class LinkedNode {
    //a linked node has a money data attribute and a next pointer to the next Linked Node
    public money data;
    public LinkedNode next;

    LinkedNode(money data) {
        this.data = data;
    }
}
