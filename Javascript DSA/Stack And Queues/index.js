//stacks are last in first out like a stack of pancakes

//stack with an array
var arrStack = [];

//inserts item into stack
console.log("Inserting I, Am, and Pig into array based stack");
arrStack.push("I");
arrStack.push("Am");
arrStack.push("Pig");
console.log(arrStack)
console.log();

//removes the last thing first
console.log("Last Item is Pig")
arrStack.pop();
console.log(arrStack);
console.log();

//implemented stack with nodes

//Node and Stack classes
class Node{
  constructor(val){
    this.val = val;
    this.next = null;
  }
}

class Stack{
  constructor(){
    this.start = null;
    this.end = null;
    this.size = 0;
  }

  push(val){
    var newNode = new Node(val)
    if(this.size === 0){
      this.start = newNode;
      this.end = newNode;
    }
    else{
      var temp = this.start;
      this.start = newNode;
      this.start.next = temp;
    }
    this.size++;
    return this.size;
  }

  pop(){
    if(this.size === 0){
      return null;
    }

    var startNode = this.start;
    
    if(this.length === 1){
      this.start = null;
      this.end = null;
    }
    else{
      this.start = this.start.next
    }
    this.size--;

    return startNode.val;

  }
}

//declaring stack
var stack = new Stack();

//pushing 4 items in stack and returns length at end 
console.log("Pushing The, Mouse, Is, Mickey in the stack");
stack.push("The");
stack.push("Mouse");
stack.push("Is");
stack.push("Mickey");
console.log(stack);
console.log();

//popping/removing last item in stack
console.log("Removing Mickey from stack");
console.log(stack.pop());
console.log(stack);
console.log();

//stack with an array
var q = [];

//pushing items in
console.log("Inserting I, Am, and Carrot into array based queue");
q.unshift("I");
q.unshift("Am");
q.unshift("Carrot");
console.log(q);
console.log();

//removing the first item out 
console.log("Removing I from queue");
q.pop();
console.log(q);
console.log();

//Queue class
class Queue{
  constructor(){
    this.start = null;
    this.end = null;
    this.length = 0;
  }

  enqueue(val){
    var newNode = new Node(val);
    if(this.length === 0){
      this.start = newNode;
      this.end = newNode;
    }
    else{
      this.end.next = newNode;
      this.end = newNode;
    }
    this.length++;
    return this.length;
  }

  dequeue(){
    if(this.length === 0){
      return null;
    }

    var removedNode = this.start;
    this.start = this.start.next;
    this.length--;

    if(this.length === 0){
      this.start = null;
      this.end = null;
    }

    return removedNode;
    
  }
}

//declaring queue
var queue = new Queue;

//pushing items in queue
console.log("Inserting Hi, I'm, and Steve in the queue")
queue.enqueue("Hi");
queue.enqueue("I'm");
queue.enqueue("Steve");
console.log(queue);
console.log();

//removing the first item in a queue
console.log("Removing Hi from the queue");
console.log(queue.dequeue());
console.log(queue);