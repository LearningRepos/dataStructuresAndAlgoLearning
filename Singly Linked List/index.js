class Node {
  constructor(val) {
    this.val = val;
    this.next = null;
  }
}

class SinglyLinkedList {
  constructor() {
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  loop() {
    var startNode = this.head;

    for (var i = 0; i < this.length; i++) {
      console.log(startNode.val);
      startNode = startNode.next;
    }
  }

  push(val) {

    var newNode = new Node(val);
    if (this.length === 0) {
      this.head = newNode;
      this.tail = newNode;
    }
    else {
      this.tail.next = newNode;
      this.tail = newNode;
    }
    this.length++;

  }

  pop() {

    if (this.length === 0) {
      return undefined;
    }

    var currentNode = this.head;
    var newTail = this.head;

    while (currentNode.next) {
      newTail = currentNode;
      currentNode = currentNode.next;
    }

    newTail.next = null;
    this.tail = newTail;
    this.length--;

    if (this.length === 0) {
      this.head = null;
      this.tail = null;
    }

    return currentNode;

  }

  shift() {
    if (this.length === 0) {
      return undefined;
    }
    var removedHead = this.head;
    this.head = this.head.next;
    this.length--;

    if (this.length === 0) {
      this.head = null;
      this.tail = null;
    }

    return removedHead;
  }

  unshift(val) {

    var newHead = new Node(val);

    if (this.length === 0) {
      this.head = newHead;
      this.tail = newHead
    }
    else {
      var oldHead = this.head;
      newHead.next = oldHead;
      this.head = newHead;
    }
    this.length++;
  }

  get(index) {
    if (index < 0 || index > this.length) {
      return undefined;
    }
    var startNode = this.head;
    for (var i = 0; i < index; i++) {
      startNode = startNode.next;
    }
    return startNode;
  }

  set(index, value) {
    if (index < 0 || index > this.length) {
      return undefined;
    }
    var currentNode = this.get(index);
    currentNode.val = value;
  }

  insert(index, value) {
    if (index < 0 || index > this.length) {
      return undefined;
    }
    else if (index === 0) {
      this.unshift(val);
    }
    else if (index === this.length) {
      this.push(val);
    }
    else {
      var previousNode = this.get(index - 1);
      var pastNode = previousNode.next;
      var insertNode = new Node(value);

      previousNode.next = insertNode;
      insertNode.next = pastNode;
      this.length++;
    }
  }

  remove(index) {
    if (index < 0 || index >= this.length) {
      return undefined;
    }
    else if(index === 0){
      this.shift();
    }
    else if(index === this.length-1){
      this.pop();
    }
    else{
      var previousNode = this.get(index-1);
      var pastNode = this.get(index+1);

      previousNode.next = pastNode;
      this.length--;

      return this.get(index);
    }
  }

  reverse(){
    var node = this.head;
    this.head = this.tail;
    this.tail = node;

    var previous = null;
    var next = null;

    for(var i =0; i<this.length; i++){
      next = node.next;
      node.next = previous;
      previous = node;
      node = next;
    }
  }

}

var list = new SinglyLinkedList();

list.push("Mihir");
list.push("Is");
list.push("Stupid");
console.log(list);

console.log();

list.shift();
console.log(list);

console.log();

list.unshift("Mihir");
list.unshift("Achyuta");
console.log(list);
console.log();

console.log(list.get(1));
console.log();

list.set(1, "Mihirio");
console.log(list);
console.log();

list.insert(1, "Boi");
list.insert(4,"Idiot");
list.loop();
console.log();

list.remove(5);
list.loop();
console.log();

list.reverse();
list.loop();