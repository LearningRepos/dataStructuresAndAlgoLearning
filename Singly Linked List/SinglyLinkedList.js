class Node{
    constructor(value){
        this.value = value;
        this.next = null;
    }
}

class SinglyLinkedList{
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
    push(val){
        var node = new Node(val);
        if(this.head === null){
            this.head = node;
            this.tail = node;
        }
        else{
            this.tail.next = node;
            this.tail = node;
        }
        this.length++;
        return this;
    }
}

//bad way of pushing a new value at the end of the list
/*
var first = new Node("Hello");
first.next = new Node("Sir");
first.next.next = new Node("Thanks");
*/

var list = new SinglyLinkedList();
//pushes "Hi" at first and Ha at second
list.push("Hi");
list.push("Ha");
list.push("He");
console.log(list);