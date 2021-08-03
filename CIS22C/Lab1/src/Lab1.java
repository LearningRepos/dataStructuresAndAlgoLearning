/**
 * Name: Mihir Achyuta
 * Lab Number: 1
 * Purpose of the Assignment:
 * - The purpose of this assignment is to demonstrate if all the numbers in an array are prime.
 * - However I had to show this iteratively with loops and recursively without loops.
 * - The iteration is shown with the function IsArrayPrimeIter and the recursion function is shown as IsArrayPrimeRecur
 * with the helper function to do the actual recursion as IsPrimeRecur
 **/

import java.util.*;

public class Lab1 {
    public static void main(String[] args) throws InterruptedException {
        //initial variables with unknown array size, maximum array size allowed, and scanner for input
        int arraySize = -1;
        int SORT_MAX_SIZE = 16;
        Scanner inputScanner = new Scanner(System.in);

        //asks the user to enter a valid input or else they will be asked again to enter a valid input
        System.out.println("Please enter the number for the size of the array:");
        System.out.println("The number must be between 1 and 16 inclusive");
        while (arraySize == -1) {
            int sizeInput = inputScanner.nextInt();

            //displays message that entered number is invalid else assigns the array size to the input
            if (sizeInput < 1 || sizeInput > SORT_MAX_SIZE) {
                System.out.println("Number " + sizeInput + " is invalid");
                System.out.println("Please enter a number between 1 and 16 inclusive");
            } else {
                arraySize = sizeInput;
            }
        }

        //creates the array based on the user input size
        int[] numberArray = new int[arraySize];
        int arrayPointer = 0;

        //gets the user input of array elements and checks each element if it is between 1 and 9999
        //if an invalid number inputted, then all other numbers will be inputted and the user
        //will be prompted to reenter a valid number(s)
        while (arrayPointer < numberArray.length) {
            int arrayElement = inputScanner.nextInt();

            if (arrayElement < 1 || arrayElement > 9999) {
                System.out.println("Number " + arrayElement + " is invalid");
                System.out.println("Please enter a number between 1 and 9999 inclusive");
                System.out.println("All other valid numbers have been inputted");
            } else {
                numberArray[arrayPointer] = arrayElement;
                arrayPointer++;
            }
        }

        //enters, runs, and leaves the iteration function
        boolean isPrimeIter = IsArrayPrimeIter(numberArray, arraySize);

        if (isPrimeIter) {
            System.out.println("Prime Array using iteration");
        } else {
            System.out.println("Not a Prime Array using iteration");
        }
        System.out.println();
        Thread.sleep(1000);

        //enters, runs, and leaves the recursion function
        boolean isPrimeRecur = IsArrayPrimeRecur(numberArray, arraySize);

        if (isPrimeRecur) {
            System.out.println("Prime Array using recursion");
        } else {
            System.out.println("Not a Prime Array using recursion");
        }
        System.out.println();
        Thread.sleep(5000);
    }

    /**
     * This function checks if all the elements in the array are prime using iteration
     * Pre:
     * arr - an array with integers of size 1-9999 inclusive
     * size - the array size of 1-16 inclusive
     * Post:
     * returns true if all the elements in the array are prime and false if all the elements in the array are not prime
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm IsArrayPrimeIter(arr, size)
     *      print entering
     *      for i =0 to size
     *          get the num for array[i]
     *          if(num == 1) return false
     *          if(num == 2 or num ==3) continue
     *          for j=2 to num/2
     *              if (num%j == 0)
     *                  print leaving
     *                  return false
     *      print leaving
     *      return true
     **/
    public static boolean IsArrayPrimeIter(int[] arr, int size) {
        System.out.println("Entering IsArrayPrimeIter...");
        for (int i = 0; i < size; i++) {
            int numToTest = arr[i];

            //1 is not a prime number
            if (numToTest == 1) {
                return false;
            }
            //2 and 3 are prime numbers but they are less than the minimum factor when divided by 2
            //so we make an exception for them and continue on in the program
            else if (numToTest == 2 || numToTest == 3) {
                continue;
            }

            //we loop from 2 to numToTest/2 since any number(aside from the number itself) after half the number is not divisible by the number
            for (int j = 2; j <= numToTest / 2; j++) {
                //if a factor is detected then the array is not all prime
                if (numToTest % j == 0) {
                    System.out.println("Leaving IsArrayPrimeIter...");
                    return false;
                }
            }
        }

        System.out.println("Leaving IsArrayPrimeIter...");
        return true;
    }

    /**
     * This function checks if all the elements in the array are prime using recursion
     * Pre:
     * int[] arr - an array with integers of size 1-9999 inclusive
     * int size - the array size of 1-16 inclusive
     * Post:
     * returns true if all the elements in the array are prime and false if all the elements in the array are not prime
     **/

    // @formatter:off
    /**
     * Pseudocode:
     *
     * Algorithm IsArrayPrimeRecur(arr, size)
     *      print entering
     *      isPrime = IsPrimeRecur(arr, size, 0, arr[0], 2)
     *      print leaving
     *
     *      return isPrime
     **/
    public static boolean IsArrayPrimeRecur(int[] arr, int size) {
        System.out.println("Entering IsArrayPrimeRecur...");
        //uses the helper recursion function IsPrimeRecur to do the actual recursion and returns the boolean result
        //start at index 0, array value at index 0, and the minimum possible factor 2
        boolean isArrayPrime = IsPrimeRecur(arr, size, 0, arr[0], 2);
        System.out.println("Leaving IsArrayPrimeRecur...");

        return isArrayPrime;
    }

    /**
     * This helper function checks if a specific indexed element in the array is divisible by a possible factor and then
     * checks if there are any cases where you can figure out if a number is prime or not AND also check if the array is prime(explained in pseudocode and comments) recursively.
     * Pre:
     * int[] arr - an array with integers of size 1-9999 inclusive
     * int size - the array size of 1-16 inclusive
     * int index - the current index of the array which the program is evaluating
     * int value - the value of the indexed element(above variable) in the array
     * int possibleFactor - the current factor in which the program will check if the value is divisible by the factor of minimum 2(if it is then the number is prime)
     * Post:
     * returns true if all the elements in the array are prime and false if all the elements in the array are not prime
     **/

    // @formatter:off
    /**
     * Algorithm IsPrimeRecur(arr, size, index, value, possibleFactor)
     *      print entering
     *      if(index == size) return true
     *      else if(value == 1) return false
     *      else if(value == 2 or value == 3)
     *          if(index + 1 == size)
     *              print leaving
     *              return true
     *          return IsPrimeRecur(arr, size, index + 1, arr[index + 1], 2);
     *      else if(possibleFactor>value/2)
     *          if(index + 1 == size)
     *              print leaving
     *              return true
     *          return IsPrimeRecur(arr, size, index + 1, arr[index + 1], 2);
     *      else if(value % possibleFactor == 0)
     *          print leaving
     *          return false
     *      else
     *          return IsPrimeRecur(arr, size, index, arr[index], possibleFactor + 1);
     **/
    public static boolean IsPrimeRecur(int[] arr, int size, int index, int value, int possibleFactor) {
        System.out.println("Entering IsPrimeRecur...");
        //if the index is equal to size then the function has tested all array values from index 0 to n-1
        //there are no possible factors for all these numbers in the array so the array is prime
        if (index == size) {
            System.out.println("Leaving IsPrimeRecur...");
            return true;
        }
        //1 is not a prime number so exit
        else if (value == 1) {
            System.out.println("Leaving IsPrimeRecur...");
            return false;
        }
        //2 and 3 are prime numbers so check if the index + 1 is equal to size
        //if it is then the function has tested all array values from index 0 to n-1
        //else increase the index and set the new array value to the updated index
        else if (value == 2 || value == 3) {
            if (index + 1 == size) {
                System.out.println("Leaving IsPrimeRecur...");
                return true;
            }
            return IsPrimeRecur(arr, size, index + 1, arr[index + 1], 2);
        }
        //any number(aside from the number itself) after half the number is not divisible by the number
        //so check if the index + 1 is equal to size else increase the index and set the new array value to the updated index
        else if (possibleFactor > value / 2) {
            if (index + 1 == size) {
                System.out.println("Leaving IsPrimeRecur...");
                return true;
            }
            return IsPrimeRecur(arr, size, index + 1, arr[index + 1], 2);
        }
        //if the current array value divided by the possible factor is 0 then the value has a factor so the number is not prime
        //so the array is not prime
        else if (value % possibleFactor == 0) {
            System.out.println("Leaving IsPrimeRecur...");
            return false;
        }
        //if there is no factor or the possible factor is less than value/2, then add 1 to the possible factor
        else {
            return IsPrimeRecur(arr, size, index, arr[index], possibleFactor + 1);
        }
    }
}
