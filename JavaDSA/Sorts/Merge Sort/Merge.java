import java.util.Arrays; 
public class Merge {

  public static int[] Merge(int[] array1, int[] array2){
    int[] mergedArray = new int[array1.length + array2.length]; //array length of 7
    int i = 0;//index of array1
    int j = 0;//index of array2
    int k = 0;//separate index for merged array adding

    while(i<array1.length && j< array2.length){ //fills up at least 1 subarray
      if(array1[i] < array2[j]){
        mergedArray[k] = array1[i];
        k++;
        i++;
      }
      else if(array1[i] > array2[j]){
        mergedArray[k] = array2[j];
        k++;
        j++;
      }
    }
    //fills the other array up now
    while(i<array1.length){
      mergedArray[k] = array1[i];
      k++;
      i++;
    }
    while(j<array2.length){
      mergedArray[k] = array2[j];
      k++;
      j++;
    }
    return mergedArray;
  }

  public static int[] MergeSort(int[] array){
    if(array.length <= 1){
      return array;
    }
    int midpoint = array.length/2;
    //breaks array apart and returns each individual piece of array then merges it at the end
    int[] LeftArray = MergeSort(Arrays.copyOfRange(array, 0, midpoint));
    int[] RightArray = MergeSort(Arrays.copyOfRange(array, midpoint, array.length));
    return Merge(LeftArray,RightArray);
  }

  public static void main(String[] args) {
    int[] array = {10,24,76,73,72,59};
    int[] MergedArray = MergeSort(array);
    //implementation of Merge Sort
    for(int i =0; i<MergedArray.length; i++){
      System.out.println(MergedArray[i]);
    }
  }
}