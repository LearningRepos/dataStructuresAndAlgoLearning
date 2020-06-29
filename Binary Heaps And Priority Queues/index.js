//parent node index n and children at index 2n+1 or 2n+2
//or
//child node n and parent at index Math.floor((n-1)/2)

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

var maxHeap = new MaxBinaryHeap();
maxHeap.Insert(41);
maxHeap.Insert(39);
maxHeap.Insert(33);
maxHeap.Insert(18);
maxHeap.Insert(27);
maxHeap.Insert(12);
maxHeap.Insert(55);
console.log(maxHeap);
console.log();

console.log(maxHeap.extractMax());
console.log(maxHeap);
console.log();

var minHeap = new MinBinaryHeap();
minHeap.Insert(41);
minHeap.Insert(39);
minHeap.Insert(33);
minHeap.Insert(18);
minHeap.Insert(27);
minHeap.Insert(12);
minHeap.Insert(55);
console.log(minHeap);
console.log();

minHeap.extractMin();
console.log(minHeap);



