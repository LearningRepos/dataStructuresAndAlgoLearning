package JavaDSA.Recursion;

public class RecursionProblems {
  public int power(int base, int exponent) {
    if (exponent == 0) {
      return 1;
    } else {
      return base * power(base, exponent - 1);
    }
  }

  public int ArrayProduct(int[] array, int key) {
    int sum = 1;
    if (key == array.length) {
      return 1;
    } else {
      return sum * array[key] * ArrayProduct(array, key + 1);
    }
  }

  public int Fibbonachi(int number) {
    // 4 1 1 2 3
    int count = 0;
    if (number == 0) {
      return 0;
    }
    if (number == 1) {
      return 1;
    }
    return Fibbonachi(number - 1) + Fibbonachi(number - 2);
  }

}