class Node{
  constructor(val){
    this.val = val;
    this.next = null;
    this.previous = null;
  }
}

class DoublyLinkedList{
  constructor(){
    this.head = null;
    this.tail = null;
    this.length = 0;
  }

  loop(){
    var headNode = this.head;
    for(var i =0; i<this.length; i++){
        console.log(headNode.val);
        headNode = headNode.next;
    }
  }

  push(val){
    var newNode = new Node(val);
    if(this.length === 0){
      this.head = newNode;
      this.tail = newNode;
    }
    else{
      this.tail.next = newNode;
      newNode.previous = this.tail;
      this.tail = newNode;
    }
    this.length++;
  }

  pop(){

    if(this.length === 0){
      return undefined;
    }

    var tailNode = this.tail;

    if(this.length === 1){
      this.head = null;
      this.tail = null;
    }
    else{
      this.tail = this.tail.previous;
      this.tail.next = null;
      tailNode.previous = null;
    }

    this.length--;
    return tailNode;
  }

  unshift(val){
    var newNode = new Node(val);
    if(this.length === 0){
      this.head = newNode;
      this.tail = newNode;
    }
    else{
      newNode.next = this.head;
      this.head.previous = newNode;
      this.head = newNode;
    }
    this.length++;
  }

  shift(){
    if(this.length === 0){
      return undefined;
    }

    var removedNode = this.head;

    if(this.length === 1){
      this.head = null;
      this.tail = null;
    }
    else{
      this.head = this.head.next;
      this.head.previous = null;
      removedNode.next = null;
    }

    this.length--;
    return removedNode;
  }

  get(index){
    if(index<0 || index>=this.length){
      return null;
    }

    if(index <= this.length/2){
      var curNode = this.head;
      for(var i =0; i<index; i++){
        curNode = curNode.next;
      }
      return curNode;
    }

    else{
      var curNode = this.tail;
      for(var i =this.length; i>index; i--){
        console.log(curNode);
        curNode = curNode.previous;
      }
      return curNode;
    }
  }

  set(index,value){
    if(index<0 || index>this.length){
      return null;
    }

    var setNode = this.get(index);
    setNode.val = value;
  }

  insert(index,value){

     if(index<0 || index>this.length){
      return null;
    }
    if(index === 0){
      this.unshift(value);
    }
    else if(index === this.length){
      this.push(value);
    }
    else{
      var preNode = this.get(index-1);
      var node = new Node(value);
      var postNode = preNode.next;

      //left node connection
      preNode.next = node;
      node.previous = preNode;

      //right node connection
      node.next = postNode;
      postNode.previous = node;

      this.length++;
    }

  }

  delete(index){
    if(index<0 || index>=this.length){
      return null;
    }

    if(index === 0){
      this.shift();
    }
    else if(index === this.length-1){
      this.pop();
    }
    else{
      var removedNode = this.get(index);
      var previousNode = removedNode.previous;
      var postNode = removedNode.next

      //severing left
      previousNode.next = null;
      removedNode.previous = null;

      //severing right;
      postNode.previous = null;
      removedNode.next = null;

      //joining nodes
      previousNode.next = postNode;
      postNode.previous = previousNode; 
      this.length--;
    }
  }

}

//creates doubly linked list
var list = new DoublyLinkedList;

//pushes items into DoublyLinkedList
console.log("Pushing 5 Items")
list.push("I");
list.push("Am");
list.push("Sloth");
list.push("Boi");
list.push("Nice");
list.loop();
console.log();

// //pops item in DoublyLinkedList at end
console.log("Removing Nice")
list.pop();
list.loop();
console.log();

// //shifts item in DoublyLinkedList at end
console.log("Removing I")
list.shift();
list.loop();
console.log();

// //unshifts value in DoublyLinkedList at the start
console.log("Adding I")
list.unshift("I");
list.loop();
console.log();

// //gets a certain value in the DoublyLinkedList
console.log("Getting Sloth")
console.log(list.get(2));
console.log();

// //sets a certain index in DoublyLinkedList
console.log("Changing Am to Was");
list.set(1,"Was");
list.loop();
console.log();

// //inserts a value in the DoublyLinkedList
console.log("Inserting Big at Index 3");
list.insert(3,"Big");
list.loop();
console.log();

// //deletes a value in the DoublyLinkedList
console.log("Deleting Was");
list.delete(1);
list.loop();



