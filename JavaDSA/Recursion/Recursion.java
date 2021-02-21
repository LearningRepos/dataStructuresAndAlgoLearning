package JavaDSA.Recursion;

public class Recursion {
  public static void main(String[] args) {
    RecursionIntro ri = new RecursionIntro();
    // counts down from 10 to 0 with recursion
    System.out.println("CountDown");
    ri.CountDown(10);
    System.out.println();
    System.out.println();

    // finds n + (n-1) + (n-2) ... using recursion till number reaches 1
    System.out.println("SumRange");
    System.out.println(ri.SumRange(10));
    System.out.println();

    // finds factorials iteratively
    System.out.println("Iterative Factorial");
    System.out.println(ri.IterativeFactorial(4));
    System.out.println();

    // finds factorials recursively
    System.out.println("Recursive Factorial");
    System.out.println(ri.RecursiveFactorial(4));
    System.out.println();

    RecursionProblems rp = new RecursionProblems();
    // finds powers recursively
    System.out.println("Power");
    System.out.println(rp.power(2, 3));
    System.out.println();

    // finds product of array recursively
    int[] array = { 1, 2, 3, 10 };
    System.out.println("Product of Array");
    System.out.println(rp.ArrayProduct(array, 0));
    System.out.println();

    // finds fibonacchi of number
    System.out.println("Fibonacchi");
    System.out.println(rp.Fibbonachi(10));
  }
}