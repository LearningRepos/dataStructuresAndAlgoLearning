/**
 * Name: Mihir Achyuta
 * Lab Number: 2
 * Purpose of the Assignment:
 * - The purpose of the assignment is to demonstrate using classes, inheritance, and polymorphism by using
 * various objects that are either base classes or inherited classes and storing them in a way(array) that
 * allows different forms(currency array of money objects) and then performing operations on them.
 **/

import java.util.*;

public class lab2main {
    public static void main(String[] args) throws Exception {
        //initial variables with scanner for input and the declared currency array of size 5
        Scanner inputScanner = new Scanner(System.in);
        currency[] currencyArray = new currency[5];

        //asks the user for 5 decimal numbers and inputs each one into the currency array
        //the note will be in dollars and the coin will be in cents
        System.out.println("Please enter 5 decimal numbers to be input");
        for (int i = 0; i < currencyArray.length; i++) {

            //gets the stringified decimal and the place where the decimal is located
            //if there is no decimal point then exception thrown OR if there is no note/coin value then exception thrown OR if there are other special characters aside from numbers then exception thrown
            //numbers that would fail: 123(must be 123.0), .2(must be 0.2), 2.(must be 2.0), ee4.4(no letters only numbers)
            try {
                String stringifiedDecimal = inputScanner.next();
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
                if(!stringifiedDecimal.contains("-")){
                    currencyArray[i] = new money(noteValue, coinValue);
                }
                else{
                    throw new Exception("Note value and Coin value cannot have negative values");
                }
            } catch (Exception e) {
                //if decimal number not entered correctly, string wont parse correctly and exception thrown
                //if currency is negative then exception thrown
                throw new Exception(e);
            }
        }

        //if all 5 decimal numbers are properly inputted then we will print them all
        System.out.println("Printing contents of objects:");
        for (int i = 0; i < currencyArray.length; i++) {
            currencyArray[i].printCurrency();
        }
        System.out.println();

        //adds the first money object to the second and prints the updated result
        System.out.println("Will add");
        currencyArray[0].printCurrency();
        System.out.println("And");
        currencyArray[1].printCurrency();
        System.out.println("Results:");
        currencyArray[0].addCurrency(currencyArray[1]);
        System.out.println();

        //subtracts the first money object from the third and prints the updated result
        System.out.println("Will subtract");
        currencyArray[0].printCurrency();
        System.out.println("And");
        currencyArray[2].printCurrency();
        System.out.println("Results:");
        currencyArray[0].subtractCurrency(currencyArray[2]);
        System.out.println();

        //compares the first money object to the fourth and prints if it is equal
        System.out.println("Comparing To See If Equal");
        currencyArray[0].printCurrency();
        System.out.println("And");
        currencyArray[3].printCurrency();
        System.out.println("Results:");
        currencyArray[0].areCurrencyEqual(currencyArray[3]);
        System.out.println();

        //compares the first money object to the fifth and prints which object value is greater
        System.out.println("Comparing To See If Greater");
        currencyArray[0].printCurrency();
        System.out.println("And");
        currencyArray[4].printCurrency();
        System.out.println("Results:");
        currencyArray[0].isCurrencyGreater(currencyArray[4]);
        System.out.println();
    }
}
