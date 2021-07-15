/**
 * Name: Mihir Achyuta
 * Lab Number: 3
 * Purpose of the Assignment:
 * -The purpose of this assignment is to sort a primitive currency array filled with money objects
 * recursively with insertion sort.
 * What has been changed in currency/money class: the name block to update for lab 3
 **/

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class lab3main {
    public static void main(String[] args) throws IOException {
        //initial variables with unknown array size, maximum array size allowed, and scanner for input
        int arraySize = -1;
        int SORT_MAX_SIZE = 16;
        FileWriter myWriter = new FileWriter("output");
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
        currency[] currencyArray = new currency[arraySize];
        int arrayPointer = 0;

        //asks user for decimal numbers to create money objects
        System.out.println("Please enter the decimal numbers for the array elements");
        System.out.println("Numbers must have a decimal point and numbers before/after decimal points. Ex: 0.5, 5.0, 5.33132");
        while (arrayPointer < currencyArray.length) {
            String stringifiedDecimal = inputScanner.next();
            try {
                int decimalIndex = stringifiedDecimal.indexOf(".");
                int noteValue = Integer.parseInt(stringifiedDecimal.substring(0, decimalIndex));
                int coinValue;

                //if the decimal value length after decimal greater than 2(0.543 ex.) we will trim the number to 2 places max(0.54)
                //if the decimal value length after decimal equal to 1(0.1) we will add another zero to represent current currency(0.10)
                //else parse normally
                if (stringifiedDecimal.substring(decimalIndex + 1).length() > 2) {
                    coinValue = Integer.parseInt(stringifiedDecimal.substring(decimalIndex + 1, decimalIndex + 3));
                } else if (stringifiedDecimal.substring(decimalIndex + 1).length() == 1) {
                    coinValue = Integer.parseInt(stringifiedDecimal.substring(decimalIndex + 1, decimalIndex + 2) + "0");
                } else {
                    coinValue = Integer.parseInt(stringifiedDecimal.substring(decimalIndex + 1));
                }

                //cant have any negative currency value
                if (!stringifiedDecimal.contains("-")) {
                    currencyArray[arrayPointer] = new money(noteValue, coinValue);
                    arrayPointer++;
                } else {
                    throw new Exception("Note value and Coin value cannot have negative values");
                }
            } catch (Exception e) {
                //if decimal number not entered correctly, string wont parse correctly and exception thrown
                //if currency is negative then exception thrown
                System.out.println("Please enter a valid decimal number as " + stringifiedDecimal + " is invalid");
            }
        }

        RecurInsSort(currencyArray, currencyArray.length, 1, myWriter);
    }

    /**
     * This function performs an insertion sort that is recursive on an array of currency objects
     * Pre:
     * arr - array of currency objects
     * size - length of array
     * arrayIndex - the index of when to "bubble down" the nth element for the insertion sort
     * myWriter -
     * **/

    // @formatter:off
    /**
     * Psuedocode:
     * algorithm RecurInsSort(arr, size, arrayIndex, myWriter)
     *      if arrayIndex = arr.length return
     *
     *      int currIndex = arrayIndex
     *      while(currIndex > 0 and array currIndex note < array currIndex -1 note OR
     *          array currIndex note == array currIndex -1 note AND array currIndex coin < array currIndex -1 coin)
     *          temp = array currIndex
     *          swap array currIndex and array currIndex -1
     *          assign array currIndex to temp
     *          decrementCurrIndex
     *
     *      loop over currency
     *          print to file long form of currency details
     *          print to terminal long form of currency details
     *      flush file and separate line for formatting
     *
     *       RecurInsSort(arr, size, arrayIndex + 1, myWriter)
     * **/
    public static void RecurInsSort(currency[] arr, int size, int arrayIndex, FileWriter myWriter) throws IOException {
        if (arrayIndex == arr.length) {
            return;
        }

        int currIndex = arrayIndex;
        while (currIndex > 0 && (
                arr[currIndex].getCurrencyNoteValue() < arr[currIndex - 1].getCurrencyNoteValue() ||
                        arr[currIndex].getCurrencyNoteValue() == arr[currIndex - 1].getCurrencyNoteValue() &&
                                arr[currIndex].getCurrencyCoinValue() < arr[currIndex - 1].getCurrencyCoinValue()
        )
        ) {
            currency temp = arr[currIndex];
            arr[currIndex] = arr[currIndex - 1];
            arr[currIndex - 1] = temp;
            currIndex--;
        }

        for (currency c : arr) {
            myWriter.write(c.getCurrencyNoteValue() + " Dollar " + c.getCurrencyCoinValue() + " Cent");
            myWriter.write(System.getProperty("line.separator"));
            c.printCurrency();
        }
        myWriter.write(System.getProperty("line.separator"));
        myWriter.flush();
        System.out.println();

        RecurInsSort(arr, size, arrayIndex + 1, myWriter);
    }
}