class WeightedGraph{
  constructor(){
    this.adjacencyList = {};
  }
  addVertex(vertex){
    if(!this.adjacencyList[vertex]){
      this.adjacencyList[vertex] = [];
    }
  }
  addEdge(vertex1,vertex2,weight){
    this.adjacencyList[vertex1].push({node:vertex2, weight});
    this.adjacencyList[vertex2].push({node:vertex1}, weight);
  }
  Dijsktra(start,finish){
    var node = new PriorityQueue();
    var distances = {};
    var previous = {};
    var smallest;
    var path =[];
    for(var vertex in this.adjacencyList){
      if(vertex === start){
        distances[vertex] = 0;
        node.enqueue(vertex,0);
      }else{
        distances[vertex] = Infinity;
        node.enqueue(vertex,Infinity);
      }
      previous[vertex] = null;
    }

    while(node.values.length){
      smallest = node.dequeue().val;
      if(smallest === finish){
        while(previous[smallest]){
          path.push(smallest);
          smallest = previous[smallest];
        }
        break;
      }
      if(smallest || distances[smallest] !== Infinity){
        for(var neighbor in this.adjacencyList[smallest]){
          var nextNode = this.adjacencyList[smallest][neighbor];
          var candidate = distances[smallest] + nextNode.weight;
          var nextNeighbor = nextNode.node;
          if(candidate<distances[nextNode.node]){
            distances[nextNeighbor] = candidate;
            previous[nextNeighbor] = smallest;
            node.enqueue(nextNeighbor, candidate);
          } 
        }
      }
    }
    return path.concat(smallest).reverse(); 

  }
  
}

class PriorityQueue {
  constructor(){
    this.values = [];
  }
  enqueue(val, priority) {
    this.values.push({val, priority});
    this.sort();
  };
  dequeue() {
    return this.values.shift();
  };
  sort() {
    this.values.sort((a, b) => a.priority - b.priority);
  };
}

var graph = new WeightedGraph();
graph.addVertex("A");
graph.addVertex("B");
graph.addVertex("C");
graph.addVertex("D");
graph.addVertex("E");
graph.addVertex("F");

graph.addEdge("A","B", 4);
graph.addEdge("A","C", 2);
graph.addEdge("B","E", 3);
graph.addEdge("C","D", 2);
graph.addEdge("C","F", 4);
graph.addEdge("D","E", 3);
graph.addEdge("D","F", 1);
graph.addEdge("E","F", 1);

graph.Dijsktra("A","E")