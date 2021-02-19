public class Insert {
  //Insertion sort takes the element after index 0 and compares it to the sorted array before
  //Once compared it is put in its exact sorted place and moves on to the next element
  //Time complexity O(n^2) because of nested loops
  public static void Insertion(int[] arr){
    for(int i = 1; i<arr.length; i++){
      for(int j = 0; j<i; j++){
        if(arr[j]>arr[i]){
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {5,4,3,2,1};
    Insertion(array);

    //Prints out sorted array 1 2 3 4 5
    for(int i =0; i<array.length; i++){
      System.out.print(array[i]);
    }
  }

}