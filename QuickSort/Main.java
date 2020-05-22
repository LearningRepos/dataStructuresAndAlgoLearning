import java.util.Arrays;
class Main {
  //pivot switches numbers around that are less than pivot value and returns pivot value
  public static int pivot(int[] array, int start, int end){
    int pivotSwapIndex = start;
    int pivotValue = array[start];
    
    for(int i =start+1; i<=end; i++){
      if(array[i]<pivotValue){
        pivotSwapIndex++;
        int temp = array[i];
        array[i] = array[pivotSwapIndex];
        array[pivotSwapIndex] = temp;
      }
    }
    int temp = array[start];
    array[start] = array[pivotSwapIndex];
    array[pivotSwapIndex] = temp;
    
    return pivotSwapIndex;
  }

  //quicksort usually O(nlogn) time but if the pivot is an extreme and array almost sorted/sorted then its o log n time since barely any pivot movements happen
  public static int[] QuickSort(int[] array, int left, int right){
    if(left<right){
      //calls pivot on 1st element
      int pivot = pivot(array,left, right);
      //then pivot is still 1st element but now array length is pivot -1
      QuickSort(array,left,pivot-1);
      //pivot not first element but add 1 to first element now
      QuickSort(array,pivot+1,right);
    }
    return array;
  }

  public static void main(String[] args) {
    int[] array = {4,6,9,1,2,5};
    //need end parameter to be array.length-1 or else out of bounds error
    QuickSort(array, 0, array.length-1);
    System.out.println("Quick Sort");
    for(int i =0; i<array.length; i++){
      System.out.print(array[i] + " ");
    }
  }
}