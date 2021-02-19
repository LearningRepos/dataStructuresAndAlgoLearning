//dynamic programming is solving a problem split into simpler subproblems individually
//in order to use, problem must have overlapping subproblems and optimal substructure
//overlapping subproblems are repeated problems that are solved many times(fibbonacchi)
//losts of repetitive data
//optimal substructure are optimal solutions can be produced by optimal subproblem solutions

//regular recursive fibbonacchi
function fibb(n) {
  if (n === 1 || n === 2) {
    return 1;
  }
  return fibb(n - 1) + fibb(n - 2);
}

console.log(fibb(10))
console.log();

//memoized solution stores previous values and calls on them when needed
function fibe(n, memo = []) {
  if (memo[n] !== undefined) return memo[n]
  if (n <= 2) return 1;
  memo[n] = fibe(n - 1, memo) + fibe(n - 2, memo);
  return fibe(n - 1, memo) + fibe(n - 2, memo);
}
console.log(fibe(100));
console.log();

//tabulated solution gets all the values at the time of the program and uses them
function fibTab(n){
  if(n===1 || n===2){
    return 1;
  }
  var fibArray = [0,1,1];
  for(var i =3; i<=n; i++){
    fibArray[i] = fibArray[i-1] + fibArray[i-2];
  }
  return fibArray[n];
}
console.log(fibTab(4));
