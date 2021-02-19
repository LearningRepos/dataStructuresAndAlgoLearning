//definitions:
//graphs are a bunch of nodes and connections
//possible use cases are maps and similarities between items
//vertices are nodes and edges are connections between nodes
//types of graphs:
//undirected graphs have no direction and connections everywhere
//directed graphs have visible direction
//unweighted graphs have no values associated with edges so each edge same distance
//weighted graphs have values assosiciated with edges so different distances
//how to keep track of connections:
//adjancency matrix is 1 big matrix modeling all possible connections T/F between vertices
//adjancency list 
//time/space complexities:
//adjacency list good at adding vertex/edge o(1) and decent at removing vertices/edges,querying, and storing o(e) or o(v+e)
//less space , faster searching, but harder to find specific edge
//adjacency matrix good at adding/removing edges and querying o(1) and bad at adding vertices, removing vertices, and storage o(n^2) because u add/remove a ton of rows if vertices are introduced
//more space, more overall searching time but easier to find specific edge

class Graph {
  constructor() {
    //object adjacency list that stores vertices as arrays and edges as array values
    this.adjacencyList = {};
  }

  //adding a new "node" and putting an empty aray in it
  addVertex(vertex) {
    if (!this.adjacencyList[vertex]) {
      this.adjacencyList[vertex] = [];
    }
  }

  //connecting 2 vertices together and adding the opposite value inside the vertex array
  addEdge(vertex1, vertex2) {
    if (this.adjacencyList[vertex1]) {
      this.adjacencyList[vertex2].push(vertex1);
    }
    if (this.adjacencyList[vertex2]) {
      this.adjacencyList[vertex1].push(vertex2);
    }
    return this;
  }

  //removing a connection/edge from both vertex arrays
  removeEdge(vertex1, vertex2) {
    if (this.adjacencyList[vertex1].includes(vertex2)) {
      var indexV1 = this.adjacencyList[vertex2].indexOf(vertex1);
      this.adjacencyList[vertex2].splice(indexV1,1);
      var indexV2 = this.adjacencyList[vertex1].indexOf(vertex2);
      this.adjacencyList[vertex1].splice(indexV2,1);
    }
    else {
      return "One or more vertices not connected";
    }
  }

  //completely removes the vertex and all instances
  removeVertex(vertex){
    delete this.adjacencyList[vertex];
    for(var i in this.adjacencyList){
      var potentialIndex = this.adjacencyList[i].indexOf(vertex);
      if(potentialIndex !== -1){
        this.adjacencyList[i].splice(potentialIndex,1);
      }
    }
  }
}

//creating and adding vertices
var testGraph = new Graph();
testGraph.addVertex("Aspen");
testGraph.addVertex("Dallas");
testGraph.addVertex("Tokyo");
console.log("Adding Vertices");
console.log(testGraph);
console.log();

//adding edges/connections between vertices
console.log("Adding Edges");
testGraph.addEdge("Dallas", "Aspen");
testGraph.addEdge("Aspen","Tokyo");
console.log(testGraph.addEdge("Dallas", "Tokyo"));
console.log();

//removing a certain edge/connection from the graph
console.log("Removing the edge between Aspen and Dallas");
testGraph.removeEdge("Aspen","Dallas");
console.log(testGraph);
console.log();

//completely removing the Dallas Vertex
console.log("Removing Dallas Completely")
testGraph.removeVertex("Dallas");
console.log(testGraph)
