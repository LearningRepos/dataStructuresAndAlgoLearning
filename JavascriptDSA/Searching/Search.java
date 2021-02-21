package JavascriptDSA.Searching;

public class Search {
  // Linear search worst case time complexity O(n) last element and best case O(1)
  // 1st element and avg O(n) complexity
  // Iterates through unsorted values from 0 to array.length-1 till value if found
  // true if value found and false if value isnt found
  // no problems with this because its literally traversing through an array
  public static boolean Linear(int[] array, int value) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        return true;
      }
    }
    return false;
  }

  // Binary search worst time complexity O(logn) bc fewer comparisons than linear
  // search and O(1) best time complexity
  // Uses a midpoint and compares the midpoint value to the intended value and
  // adjusts left and right bounds based on comparisons
  // true if value found and false if value isnt found
  // I had a few problems with my code which included not adding 1 to left or
  // subtracting 1 from right because we already know that array[mid] isnt the
  // value so no need to include it in our bounds
  // left should be equal to right in while loop bc (L+R)/2 where left = right is
  // essentially checking the last element or first element of the array or worst
  // case scenario
  // accidentally assigned left and right to array[mid] (array value) instead of
  // mid (array index)
  public static boolean Binary(int[] array, int value) {
    int left = 0;
    int right = array.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (value == array[mid]) {
        return true;
      } else if (array[mid] < value) {
        left = mid + 1;
      } else if (array[mid] > value) {
        right = mid - 1;
      }
    }
    return false;
  }

  public static int StringSearch(String longWord, String shortWord) {
    int count = 0;
    for (int i = 0; i < longWord.length(); i++) {
      for (int j = 0; j < shortWord.length(); j++) {
        // weeds out unsimilar characters
        if (!longWord.substring(i, i + 1).equals(shortWord.substring(j, j + 1))) {
          break;
        }
        // Testing to see if all the remaining similar characters survive
        // System.out.println(longWord.substring(i,i+1) + " " +
        // shortWord.substring(j,j+1));

        // adds 1 to i manually beacuse you're still in the j loop and making
        // comparisons
        if (longWord.substring(i, i + 1).equals(shortWord.substring(j, j + 1))) {
          i++;
        }
        // if j is at the end character and survives then we increment the count by 1
        // and break to stop the loops and reinitialize i
        if (j == shortWord.length() - 1) {
          count++;
          break;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    // Linear search implementation
    int[] unsortedArray1 = { 3, 4, 6, 5, 2, 44 };
    int value1 = 5;
    // returns true
    // System.out.println(Linear(unsortedArray1,value1));

    // Binary search implementation (array must be sorted)
    int[] sortedArray = { 1, 2, 3, 4, 5 };
    int value = 5;
    // returns true
    // System.out.println(Binary(sortedArray, value));

    // String search implementation O(n^2) version
    System.out.println(StringSearch("lorie loled the lolsin my cosines itss0funnylol", "lol"));

  }
}
