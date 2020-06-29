//parent node index n and children at index 2n+1 or 2n+2
//or
//child node n and parent at index Math.floor((n-1)/2)

//o(log n) insertions and deletions because of how the array is structured^
//o(n) searching beacuse no particular strict order of elements just follow 1 rule : parent is always min/max of children
//consider using a bianry search tree if you want to search in o(log n time) 

class MaxBinaryHeap {
  constructor() {
    this.values = [];
  }
  Insert(value) {
    this.values.push(value)
    this.bubbleUp();
  }

  bubbleUp() {
    //gets start index and index value because we start inserting it at the end
    var index = this.values.length - 1;
    var indexValue = this.values[index];

    //dont want numbers in negative indices
    while (index > 0) {
      //gets the parent of the index and the value of the parent
      var parent = Math.floor((index - 1) / 2)
      var parentValue = this.values[parent];
      //if the index value is greater than parent value (max heap rule)
      //then swap
      if (indexValue > parentValue) {
        this.values[index] = parentValue;
        this.values[parent] = indexValue;
      }
      //new index is parent to prevent infinite loop and to keep track of newly swapped value index
      index = parent;
    }
    return this.values;
  }

  extractMax() {
    //gets the last value in the top position
    var returnedMax = this.values.shift();
    this.values.unshift(this.values[this.values.length - 1]);
    this.values.pop();
    //puts down the last value in the correct position
    this.bubbleDown();
    return returnedMax;
  }

  bubbleDown() {
    //we get the value we are bubbling down and index
    var index = 0;
    var indexValue = this.values[index];
    //get array length for shorter code
    var length = this.values.length;
    //while true since we will break manually
    while (true) {
      //gets the left and right child indices
      var leftChild = index * 2 + 1;
      var rightChild = index * 2 + 2;
      //we need to see which child to swap so define a swap here
      var swap = null;
      //defines the children values but we need to make sure that they actually have value in array
      var leftChildValue, rightChildValue;
      //left child check
      if(leftChild<length){
        leftChildValue = this.values[leftChild];
        if(leftChildValue>indexValue){
          swap = leftChild;
        }
      }
      //right child check
      if(rightChild<length){
        rightChildValue = this.values[rightChild];
        if(swap === null && rightChildValue>indexValue || swap !== null && rightChildValue > leftChildValue){
          swap = rightChild;
        }
      }
      //breaks if none of children greater than parent
      if(swap === null){
        break;
      }
      //if there is a swap we do it here
      var temp = this.values[index];
      this.values[index] = this.values[swap];
      this.values[swap] = temp;
      index = swap;
    }
  }
}

class MinBinaryHeap {
  constructor() {
    this.values = [];
  }

  Insert(value) {
    this.values.push(value);
    this.BubbleUp();
  }

  BubbleUp() {
    var index = this.values.length - 1;
    var indexValue = this.values[index];

    while (index > 0) {
      var parent = Math.floor((index - 1) / 2);
      var parentValue = this.values[parent];
      if (indexValue < parentValue) {
        this.values[index] = parentValue;
        this.values[parent] = indexValue;
      }
      index = parent;
    }
  }

    extractMin() {
    var returnedMax = this.values.shift();
    this.values.unshift(this.values[this.values.length - 1]);
    this.values.pop();
    this.bubbleDown();
    return returnedMax;
  }

  bubbleDown() {
    //we get the value we are bubbling down and index
    var index = 0;
    var indexValue = this.values[index];
    //get array length for shorter code
    var length = this.values.length;
    //while true since we will break manually
    while (true) {
      //gets the left and right child indices
      var leftChild = index * 2 + 1;
      var rightChild = index * 2 + 2;
      //we need to see which child to swap so define a swap here
      var swap = null;
      //defines the children values but we need to make sure that they actually have value in array
      var leftChildValue, rightChildValue;
      //left child check
      if(leftChild<length){
        leftChildValue = this.values[leftChild];
        if(leftChildValue<indexValue){
          swap = leftChild;
        }
      }
      //right child check
      if(rightChild<length){
        rightChildValue = this.values[rightChild];
        if(swap === null && rightChildValue<indexValue || swap !== null && rightChildValue < leftChildValue){
          swap = rightChild;
        }
      }
      //breaks if none of children greater than parent
      if(swap === null){
        break;
      }
      //if there is a swap we do it here
      var temp = this.values[index];
      this.values[index] = this.values[swap];
      this.values[swap] = temp;
      index = swap;
    }
  }
}

class Node{
  constructor(value,priority){
    this.value = value;
    this.priority = priority;
  }
}

class PriorityQueue{
  constructor(){
    this.values = [];
  }

  Enqueue(value, priority){
    var newNode = new Node(value,priority);
    this.values.push(newNode);
    this.bubbleUp();
  }

  bubbleUp(){
    var insertedIndex = this.values.length-1;
    var insertedValue = this.values[insertedIndex].priority;
    while(insertedIndex>0){
      var parentIndex = Math.floor((insertedIndex-1)/2);
      var parentValue = this.values[parentIndex].priority;
      if(parentValue>insertedValue){
        var temp = this.values[insertedIndex];
        var temp2 = this.values[parentIndex];
        this.values[insertedIndex] = temp2;
        this.values[parentIndex] = temp;
      }
      insertedIndex = parentIndex;
    }
  }

  Dequeue(){
    var removedNode = this.values.shift();
    this.values.unshift(this.values[this.values.length - 1]);
    this.values.pop();
    this.bubbleDown();
    return removedNode;
  }

  bubbleDown(){
    //gets the accidental index and value of it along with array length
    var accidentalIndex = 0;
    var accidentalValue = this.values[accidentalIndex].priority;
    var length = this.values.length;
    while(true){
      //defines children indices but not values
      var leftChildIndex = accidentalIndex*2+1;
      var rightChildIndex = accidentalIndex*2+2;
      var swap = null;
      //checks to see if indices valid
      var leftChildValue,rightChildValue; 
      if(leftChildIndex < length){
        leftChildValue = this.values[leftChildIndex].priority;
        if(leftChildValue<accidentalValue){
          swap = leftChildIndex;
        }
      }
      if(rightChildIndex < length){
        rightChildValue = this.values[rightChildIndex].priority;
        if(swap === null && rightChildValue<accidentalValue || swap !== null && rightChildValue < leftChildValue){
          swap = rightChildIndex;
        }
      }
      if(swap === null){
        break;
      }
      var temp1 = this.values[accidentalIndex];
      var temp2 = this.values[swap];
      this.values[accidentalIndex] = temp2;
      this.values[swap] = temp1;
      accidentalIndex = swap;
    }
  }
}

var maxHeap = new MaxBinaryHeap();
console.log("Inserting Values in MaxHeap");
maxHeap.Insert(41);
maxHeap.Insert(39);
maxHeap.Insert(33);
maxHeap.Insert(18);
maxHeap.Insert(27);
maxHeap.Insert(12);
maxHeap.Insert(55);
console.log(maxHeap);
console.log();

console.log("Deletes max in MaxHeap");
console.log(maxHeap.extractMax());
console.log(maxHeap);
console.log();

var minHeap = new MinBinaryHeap();
console.log("Inserting Values in MinHeap");
minHeap.Insert(41);
minHeap.Insert(39);
minHeap.Insert(33);
minHeap.Insert(18);
minHeap.Insert(27);
minHeap.Insert(12);
minHeap.Insert(55);
console.log(minHeap);
console.log();

console.log("Deletes min in MinHeap");
minHeap.extractMin();
console.log(minHeap);
console.log();

var priority = new PriorityQueue();
console.log("Adds nodes to priority queue with different priorities");
priority.Enqueue("Gunshot Wound",1);
priority.Enqueue("Fever",5);
priority.Enqueue("Exploded Head",0);
priority.Enqueue("Concussion",2);
priority.Enqueue("Drunk",3);
priority.Enqueue("Dead Tissue",4);
console.log(priority);
console.log();

console.log("Removes the most prioritized node from the priority queue");
priority.Dequeue();
console.log(priority);