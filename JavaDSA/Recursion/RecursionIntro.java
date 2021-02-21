package JavaDSA.Recursion;

public class RecursionIntro {
  public void CountDown(int number) {
    System.out.print(number + " ");
    if (number > 0) {
      number--;
      CountDown(number);
    }
  }

  public int SumRange(int number) {
    if (number == 0) {
      return 1;
    }
    return number + SumRange(number - 1);
  }

  public int IterativeFactorial(int number) {
    int product = 1;
    for (int i = 1; i <= number; i++) {
      product *= i;
    }
    return product;
  }

  public int RecursiveFactorial(int number) {
    if (number == 0) {
      return 1;
    } else {
      return number * RecursiveFactorial(number - 1);
    }
  }

}