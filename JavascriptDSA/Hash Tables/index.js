//hash tables store key value pairs
//fast for finding, adding, and removing values
//hash functions are 1 way so you can hash but usually not unhash
//making ur hash function must be fast,deterministic, and distribute values uniformly

//if there is a collision (multiple values in same spot)
//can do seperate chaining which is nested values 
//or linear probing which searches for the next available spot 

//o(1) insertion deletion and accessing depending on how fast hash function is

class HashTable {
  constructor(size = 53) {
    this.keyMap = new Array(size);
  }

  hash(key) {
    let total = 0;
    let WEIRD_PRIME = 31;
    for (let i = 0; i < Math.min(key.length, 100); i++) {
      let char = key[i];
      let value = char.charCodeAt(0) - 96
      total = (total * WEIRD_PRIME + value) % this.keyMap.length;
    }
    return total;
  }
  set(key, value) {
    var hashedKey = this.hash(key);
    if(this.keyMap[hashedKey] === undefined){
      this.keyMap[hashedKey] = [];
    }
    this.keyMap[hashedKey].push([key,value]);
  }
  get(key) {
    var hashedKey = this.hash(key)
    if(this.keyMap[hashedKey]){
      for(var i =0; i<this.keyMap[hashedKey].length; i++){
        if(this.keyMap[hashedKey][i][0] === key){
          return this.keyMap[hashedKey][i];
        }
      }
      return "Not Found"
    }
    else{
      return "Not Found"
    }
  }

  keys(){
    var keyArray = [];
    for(var i=0; i<this.keyMap.length; i++){
      if(this.keyMap[i] !== undefined){
        keyArray.push(this.keyMap[i][0][0]);
      }
    }
    return keyArray;
  }

  values(){
    var valueArray = [];
    for(var i=0; i<this.keyMap.length; i++){
      if(this.keyMap[i] !== undefined){
        valueArray.push(this.keyMap[i][0][1]);
      }
    }
    return valueArray;
  }
}

let ht = new HashTable();
ht.set("maroon","#800000");
ht.set("yellow","#FFFF00");
ht.set("olive","#808000");
ht.set("salmon","#FA8072");
ht.set("lightcoral","#F08080");
ht.set("mediumvioletred","#C71585");
ht.set("plum","#DDA0DD");

console.log(ht.get("plum"));
console.log();

console.log(ht.keys());
console.log();

console.log(ht.values());
console.log();