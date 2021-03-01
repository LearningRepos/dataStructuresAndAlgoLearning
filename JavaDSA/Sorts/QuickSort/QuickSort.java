package JavaDSA.Sorts.QuickSort;

public class QuickSort {
  public static void main(String args[]) {
    int[] array = { 1102, 4205, 1417, 8731, 3567, 4551, 3847, 1134, 1711, 1099, 2069, 2914, 5773, 9267, 1048, 7675,
        2563, 5434, 1427, 8735, 3451, 6488, 2815, 3410, 701, 1821, 8874, 5037, 7938, 83, 7772, 1916, 362, 6514, 2065,
        4833, 6445, 1869, 4867, 1610, 4592, 6797, 3665, 576, 7289, 5851, 7744, 8816, 8419, 2223 };
    quicksort(array, 0, array.length - 1);

    // checks to see if sorted correctly(nothing printed if sorted)
    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1]) {
        System.out.println("Not sorted");
      }
    }
  }

  public static void quicksort(int[] arr, int left, int right) {
    if (left < right) {
      System.out.println(left + " " + right);
      int newPivot = pivot(arr, left, right);
      quicksort(arr, left, newPivot - 1);
      quicksort(arr, newPivot + 1, right);
    }
  }

  public static int pivot(int[] arr, int left, int right) {
    int pivotIndex = right;
    boolean greaterThanPivot = false;
    boolean lessThanPivot = false;
    while (left <= right) {
      if (greaterThanPivot && lessThanPivot) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
        greaterThanPivot = false;
        lessThanPivot = false;
      }
      if (arr[left] > arr[pivotIndex]) {
        greaterThanPivot = true;
      } else {
        left++;
      }
      if (arr[right] < arr[pivotIndex]) {
        lessThanPivot = true;
      } else {
        right--;
      }
    }
    int temp = arr[left];
    arr[left] = arr[pivotIndex];
    arr[pivotIndex] = temp;
    return left;
  }
}