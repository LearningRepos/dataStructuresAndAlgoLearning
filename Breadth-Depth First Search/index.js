//node class to connect everything together
class Node {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

//tree class with various methods
class Tree {

  constructor() {
    this.root = null;
  }

  insert(value) {
    var newNode = new Node(value);
    if (this.root === null) {
      this.root = newNode;
      return this;
    }

    var start = this.root;
    while (true) {
      if (start.value < value) {
        if (start.right === null) {
          start.right = newNode;
          break;
        } else {
          start = start.right;
        }

      }
      else {
        if (start.left === null) {
          start.left = newNode;
          break;
        }
        else {
          start = start.left;
        }
      }
    }
  }

  search(value) {
    if (value === this.root.value) {
      return true;
    }

    var start = this.root;
    while (true) {
      if (start.right === null && start.left === null && start.value !== value) {
        return false;
      }
      if (start.value < value) {
        start = start.right;
        if (start.value === value) {
          return true;
        }
      }
      else {
        start = start.left;
        if (start.value === value) {
          return true;
        }
      }
    }
  }

  bfs() {
    var start = this.root;
    var data = [];
    var queue = [];
    queue.push(start);
    while (queue.length) {
      start = queue.shift();
      data.push(start.value);
      if (start.left) {
        queue.push(start.left);
      }
      if (start.right) {
        queue.push(start.right)
      }
    }
    return data;
  }

  dfsPre() {
    var data = [];
    function traverse(node) {
      data.push(node.value);
      if (node.left) {
        traverse(node.left)
      }
      if (node.right) {
        traverse(node.right)
      }
    }
    traverse(this.root);
    return data;
  }

  dfsPost(){
    var data = [];
    function traverse(node){
      if(node.left){
        traverse(node.left);
      }
      if(node.right){
        traverse(node.right);
      }
      data.push(node.value);
    }
    traverse(this.root);
    return data;
  }

  dfsIn(){
    var data = [];
    function traverse(node){
      if(node.left){
        traverse(node.left);
      }
      data.push(node.value);
      if(node.right){
        traverse(node.right);
      }
    }
    traverse(this.root);
    return data;
  }
}

var tree = new Tree();
//       50
//   25      75
// 15  35  65  85

//inserting values
tree.insert(50);
tree.insert(75);
tree.insert(25);
tree.insert(15);
tree.insert(85);
tree.insert(65);
tree.insert(35);
console.log("Inserted Values"); 
console.log(tree);
console.log();

// //searching values
console.log("Searching for 85 " + tree.search(85));
console.log();

// //queue testing
// var testQueue = new Queue();
// testQueue.push(1);
// testQueue.push(2);
// testQueue.push(3);
// testQueue.pop();
// console.log(testQueue);
// testQueue.push(3);
// console.log();

//Breadth First Search
console.log("Breadth First Search");
console.log(tree.bfs());
console.log();

//Depth First Search PreOrder
console.log("Depth First Search PreOrder");
console.log(tree.dfsPre());
console.log();

//Depth First Search PostOrder
console.log("Depth First Search PostOrder");
console.log(tree.dfsPost());
console.log();

//Depth First Search InOrder
console.log("Depth First Search InOrder");
console.log(tree.dfsIn());
console.log();

