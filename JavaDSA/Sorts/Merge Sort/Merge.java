import java.util.Arrays;

public class Merge {
  public static void main(String args[]) {
    int[] array = { 1, 3, 9, 7, 4, 8 };
    int[] newArray = mergesort(array);
    System.out.println(Arrays.toString(newArray));
  }

  public static int[] mergesort(int[] arr) {
    if (arr.length <= 1) {
      return arr;
    }
    int[] leftSplit = mergesort(Arrays.copyOfRange(arr, 0, arr.length / 2));
    int[] rightSplit = mergesort(Arrays.copyOfRange(arr, arr.length / 2, arr.length));
    return merge(leftSplit, rightSplit);
  }

  public static int[] merge(int[] leftArr, int[] rightArr) {
    int[] newArray = new int[leftArr.length + rightArr.length];
    int newArrayIndex = 0;
    int leftArrayIndex = 0;
    int rightArrayIndex = 0;

    while (leftArrayIndex < leftArr.length && rightArrayIndex < rightArr.length) {
      if (leftArr[leftArrayIndex] < rightArr[rightArrayIndex]) {
        newArray[newArrayIndex] = leftArr[leftArrayIndex];
        newArrayIndex++;
        leftArrayIndex++;
      } else {
        newArray[newArrayIndex] = rightArr[rightArrayIndex];
        newArrayIndex++;
        rightArrayIndex++;
      }
    }

    if (leftArrayIndex < leftArr.length) {
      for (int i = leftArrayIndex; i < leftArr.length; i++) {
        newArray[newArrayIndex] = leftArr[leftArrayIndex];
        newArrayIndex++;
        leftArrayIndex++;
      }
    } else {
      for (int i = rightArrayIndex; i < rightArr.length; i++) {
        newArray[newArrayIndex] = rightArr[rightArrayIndex];
        newArrayIndex++;
        rightArrayIndex++;
      }
    }
    return newArray;
  }
}