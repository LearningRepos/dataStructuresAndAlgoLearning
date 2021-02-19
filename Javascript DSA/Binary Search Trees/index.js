class Node{
  constructor(value){
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class BinarySearchTree{
  constructor(){
    this.root = null;
  }

  insert(value){
    var newNode = new Node(value);

    if(this.root === null){
      this.root = newNode;
      return this;
    }

    var start = this.root;
    while(true){
      if(start.value === newNode.value){
        break;
      }
      if(start.value < newNode.value){
        if(start.right === null){
          start.right = newNode;
          break;
        }
        else{
          start = start.right;
        }
      }
      else{
        if(start.left === null){
          start.left = newNode;
          break
        }
        else{
          start = start.left;
        }
      }
    }
  }

  search(value){
    if(this.root === null){
      return undefined;
    }

    if(this.root.value === value){
      return true;
    }

    var searchNode = this.root;
    var count = 0;
    while(true){
      if(searchNode.right === null && searchNode.left === null && searchNode.value !== value){
        return false;
      }
      if(searchNode.right.value === value || searchNode.left.value === value){
        return true;
      }
      
      if(value > searchNode.value){
        console.log( "right swerve " +count);
        count++;
        searchNode = searchNode.right;
      }
      else{
        console.log( "left swerve " + count);
        count++;
        searchNode = searchNode.left;
      }
    }

  }
}



var tree = new BinarySearchTree();
//       50
//   25      75
// 15  35  65  85
tree.insert(50);
tree.insert(75);
tree.insert(25);
tree.insert(15);
tree.insert(85);
tree.insert(65);
tree.insert(35);
console.log(tree.root);
console.log();
console.log(tree.search(25));