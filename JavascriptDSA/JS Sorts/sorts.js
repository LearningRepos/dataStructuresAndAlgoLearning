//relevant recursion examples of factorials and fibonacci
//factorial
function Factorial(number) {
  if (number === 1) {
    return 1;
  }
  return number * Factorial(number - 1);
}
console.log("4 Factorial")
console.log(Factorial(4));
//fibonacci
function Fibonacci(number) {
  if (number === 0) {
    return 0;
  }
  if (number === 1 || number === 2) {
    return 1;
  }
  return Fibonacci(number - 1) + Fibonacci(number - 2);
}
console.log("Fibonacci of 11th term");
console.log(Fibonacci(11));

var TestArray = [1, 2, 3, 4, 5];
//Binary Search in JavaScript
function BinarySearch(array, value) {
  var Leftmost = 0;
  var Rightmost = array.length - 1;
  while (Leftmost <= Rightmost) {
    var Midpoint = Math.floor((Leftmost + Rightmost) / 2);
    if (array[Midpoint] === value) {
      console.log(Midpoint);
      break;
    }
    else if (array[Midpoint] > value) {
      Rightmost = Midpoint - 1;
    }
    else if (array[Midpoint] < value) {
      Leftmost = Midpoint + 1;
    }
  }
}
console.log("Binary Search looking for 5");
BinarySearch(TestArray, 5);

var Testarray = [5, 4, 3, 2, 1];
//Bubble Sort in JavaScript
function BubbleSort(array) {
  for (var i = 0; i < array.length - 1; i++) {
    for (var j = 0; j < array.length - 1; j++) {
      if (array[j] > array[j + 1]) {
        var temp = array[j];
        array[j] = array[j + 1];
        array[j + 1] = temp;
      }
    }
  }
}
BubbleSort(Testarray);
console.log("Bubble Sort")
console.log(Testarray);

var Testarray = [5, 4, 3, 2, 1];
//Selection Sort in JavaScript
function SelectionSort(array) {
  for (var i = 0; i < array.length - 1; i++) {
    var min = i;
    for (var j = i + 1; j < array.length; j++) {
      if (array[j] < array[min]) {
        min = j;
      }
    }
    var temp = array[i];
    array[i] = array[min];
    array[min] = temp;
  }
}
SelectionSort(Testarray);
console.log("Selection Sort")
console.log(Testarray);

var Testarray = [5, 4, 3, 2, 1];
//Insertion Sort in Javascript
function InsertionSort(array) {
  for (var i = 1; i < array.length; i++) {
    for (var j = 0; j < i; j++) {
      if (array[i] < array[j]) {
        var temp = array[j];
        array[j] = array[i];
        array[i] = temp;
      }
    }
  }
}
InsertionSort(Testarray);
console.log("Insertion Sort");
console.log(Testarray);

//Merge Sort In JavaScript
function Merge(array1, array2) {
  var array = [];
  var i = 0;
  var j = 0;
  var k = 0;

  while (i < array1.length && j < array2.length) {
    if (array1[i] <= array2[j]) {
      array[k] = array1[i];
      k++;
      i++;
    }
    else if (array1[i] > array2[j]) {
      array[k] = array2[j];
      k++;
      j++;
    }
  }

  while (i < array1.length) {
    array[k] = array1[i];
    k++;
    i++;
  }

  while (j < array2.length) {
    array[k] = array2[j];
    k++;
    j++;
  }

  return array;
}

function MergeSort(array) {
  if (array.length <= 1) {
    return array;
  }
  var mid = Math.floor(array.length / 2);
  var leftArray = MergeSort(array.slice(0, mid));
  var rightArray = MergeSort(array.slice(mid, array.length));
  return Merge(leftArray, rightArray);
}
array = [5, 1, 432, 12, 65, 35];
mergedArray = MergeSort(array);
console.log("Merge Sort");
console.log(mergedArray);

//Quick Sort in JavaScript
var Testarray = [35, 1, 432, 12, 34];
function Pivot(array, start, end) {
  var pivotValue = array[start];
  var pivotIndex = start;
  for (var i = 1; i <= end; i++) {
    if (array[i] < pivotValue) {
      pivotIndex++;
      var temp = array[pivotIndex];
      array[pivotIndex] = array[i];
      array[i] = temp;
    }
  }
  var altTemp = array[start];
  array[start] = array[pivotIndex];
  array[pivotIndex] = altTemp;
  return pivotIndex;
}

function QuickSort(array, start, end) {
  if (start < end) {
    var pivotIndex = Pivot(array, start, end);
    QuickSort(array, start, pivotIndex - 1);
    QuickSort(array, pivotIndex + 1, end);
  }
  return array
}
console.log("Quick Sort")
console.log(QuickSort(Testarray, 0, Testarray.length - 1));

//Radix Sort in Java Script
var Testarray = [35, 1, 432, 12, 34];
function getDigit(number, place) {
  return Math.floor(Math.abs(number) / Math.pow(10, place)) % 10;
}

function digitCount(number) {
  var x = Math.abs(number) + "";
  return x.length;
}

function mostDigits(array) {
  var max = -1;
  for (var i = 0; i < array.length; i++) {
    if (digitCount(array[i]) > max) {
      max = digitCount(array[i]);
    }
  }
  return max;
}

function RadixSort(array) {
  var max = mostDigits(array);
  for (var i = 0; i < max; i++) {
    var buckets = Array.from({ length: 10 }, () => []);
    for (var j = 0; j < array.length; j++) {
      var digit = getDigit(array[j], i);
      buckets[digit].push(array[j]);
    }
    array = [].concat(...buckets);
  }
  return array
}
console.log("Radix Sort");
var sortedArray = RadixSort(Testarray);
console.log(sortedArray);

