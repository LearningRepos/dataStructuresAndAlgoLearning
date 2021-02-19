import java.util.ArrayList;
import java. util. Collection;
import java.util.Collections;

public class Selection {
  //Selections sort SELECTS the minimum in the array and swaps it to the beginning
  //Unlike bubble sort you are directly comparing i and j in this case unlike bubble sort which uses the outer loop to bubble each value to its respective position
  //Complexity still O(n^2) because of nested for loops
  //One mistake that I made was that I was only using the inner loop to compare without using the the outer for loop to compare also 
  //I also tried doing some weird stuff with array[min] which didnt work out 
  //All i need is i and the min INDEX in which at the end of the inner for loop I can swap
  public static void Selection(int[] arr){
    for(int i =0; i<arr.length-1; i++){
      int min = i;
      for(int j = i+1; j<arr.length; j++){
        if(arr[j] < arr[min]){
          min = j;
        }
      }
      if(min != i){
        int temp = arr[i];
        arr[i] = arr[min];
        arr[min] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {5,4,3,2,1};

    Selection(array);
    

    //prints out updated sorted elements 1,2,3,4,5
    for(int i =0; i<array.length; i++){
      System.out.print(array[i]);
    }

  }
}