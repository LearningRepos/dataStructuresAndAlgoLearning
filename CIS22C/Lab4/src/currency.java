/**
 * Name: Mihir Achyuta
 * Lab Number: 4
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a Linked List, Stack, and Queue with money objects and LinkedNodes and perform
 * various operations on each of these data structures
 **/

public abstract class currency {
    //integer attributes for whole part/currency note value and fractional part/currency coin value
    private int currencyNoteValue;
    private int currencyCoinValue;

    //default constructor with no parameters passed
    public currency() {
        this.currencyNoteValue = 5;
        this.currencyCoinValue = 50;
    }

    //constructor with all parameters passed
    public currency(int currencyNoteValue, int currencyCoinValue) {
        this.currencyNoteValue = currencyNoteValue;
        this.currencyCoinValue = currencyCoinValue;
    }

    /**
     * These functions get the note value and coin value integer attributes
     * Pre:
     * no input
     * Post:
     * returns a int with the currency note value or the currency coin value depending on the getter function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm getCurrencyNote/CoinValue()
     *      return currencyValue/CoinValue
     **/

    //getters for currencyNoteValue and currencyCoinValue
    public int getCurrencyNoteValue() {
        return currencyNoteValue;
    }

    public int getCurrencyCoinValue() {
        return currencyCoinValue;
    }

    /**
     * These functions set the note value and coin value integer attributes
     * Pre:
     * newCurrencyNote/CoinValue - a positive integer(enforced when called in other methods)
     * Post:
     * updates the currencyNote/Coin value with the provided value and returns nothing as it is void
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm getCurrencyNote/CoinValue()
     *      return currencyValue/CoinValue
     **/

    //setters for currencyNoteValue and currencyCoinValue
    public void setCurrencyNoteValue(int newCurrencyNoteValue) {
        currencyNoteValue = newCurrencyNoteValue;
    }

    public void setCurrencyCoinValue(int newCurrencyCoinValue) {
        currencyCoinValue = newCurrencyCoinValue;
    }

    /**
     * This function adds one currency from the other and retains the result for the original object
     * Pre:
     * addedCurrency - the other currency object being subtracted
     * Post:
     * returns nothing as it is void but prints the long form of the updated currency
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm subtractCurrency(addedCurrency)
     *      setNoteValue = noteValue + addedCurrencyNoteValue
     *      setCoinValue = coinValue + addedCurrencyCoinValue
     *
     *      if(coinValue > 100)
     *          setNoteValue = noteValue + coinValue/100
     *          setCoinValue = coinValue % 100
     *
     *      print currency
     **/

    //adding two objects of the same currency
    public void addCurrency(currency addedCurrency) {
        //initially adds the currencies together
        setCurrencyNoteValue(getCurrencyNoteValue() + addedCurrency.getCurrencyNoteValue());
        setCurrencyCoinValue(getCurrencyCoinValue() + addedCurrency.getCurrencyCoinValue());

        //if the coin value greater than 100 then add the excess to a dollar
        if (getCurrencyCoinValue() >= 100) {
            setCurrencyNoteValue(getCurrencyNoteValue() + getCurrencyCoinValue() / 100);
            setCurrencyCoinValue(getCurrencyCoinValue() % 100);
        }

        printCurrency();
    }

    /**
     * This function subtracts one currency from the other and retains the result for the original object
     * Pre:
     * subtractCurrency - the other currency object being subtracted
     * Post:
     * returns nothing as it is void but prints the long form of the updated currency
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm subtractCurrency(subtractCurrency)
     *      currentNoteValue and currentCoinValue by getter
     *
     *      currentNoteValue -= subtractCurrencyNoteValue
     *      currentCoinValue -= subtractCurrencyCoinValue
     *
     *      if(currentNoteValue <0) throw exception
     *      else if(currentCoinValue < 0)
     *          currentNoteValue -= 1
     *          currentCoinValue = 100 + currentCoinValue
     *
     *          if(currentNoteValue <0) throw exception
     *
     *      set new note and coin values
     *      print currency
     **/

    //subtracts objects of the same currency
    public void subtractCurrency(currency subtractCurrency) throws Exception {
        int currentNoteValue = getCurrencyNoteValue();
        int currentCoinValue = getCurrencyCoinValue();

        currentNoteValue -= subtractCurrency.getCurrencyNoteValue();
        currentCoinValue -= subtractCurrency.getCurrencyCoinValue();

        if (currentNoteValue < 0) {
            throw new Exception("Note value and Coin value cannot have negative values");
        } else if (currentCoinValue < 0) {
            currentNoteValue -= 1;
            currentCoinValue = 100 + currentCoinValue;

            if (currentNoteValue < 0) throw new Exception("Note value and Coin value cannot have negative values");
        }

        setCurrencyNoteValue(currentNoteValue);
        setCurrencyCoinValue(currentCoinValue);

        printCurrency();
    }

    /**
     * This function compares 2 currencies to see if they are equal
     * Pre:
     * comparedCurrency - the other currency object being compared
     * Post:
     * returns nothing as it is void but prints a line in the format : currency1NoteValue currency1NoteName currency1CoinValue currency1CoinName is equal/not equal to currency2NoteValue currency2NoteName currency2CoinValue currency2CoinName
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm isCurrencyEqual(comparedCurrency)
     *      currencyEqual = false
     *
     *      if(currencyNoteValue == comparedCurrencyNoteValue)
     *          if(currencyCoinValue == comparedCurrencyCoinValue) isEqual = true
     *
     *      printCurrency
     *      if(isEqual) print is equal to
     *      else print is not equal to
     *      print comparedCurrency
     **/

    //comparing two objects of the same currency to see if they are equal
    public void areCurrencyEqual(currency comparedCurrency) {
        boolean currencyEqual = false;

        if (getCurrencyNoteValue() == comparedCurrency.getCurrencyNoteValue()) {
            if (getCurrencyCoinValue() == comparedCurrency.getCurrencyCoinValue()) {
                currencyEqual = true;
            }
        }

        printCurrency();
        System.out.println(currencyEqual ? "is equal to " : "is not equal to ");
        comparedCurrency.printCurrency();
    }

    /**
     * This function compares 2 currencies to see which one is greater
     * Pre:
     * comparedCurrency - the other currency object being compared
     * Post:
     * returns nothing as it is void but prints a line in the format : currency1NoteValue currency1NoteName currency1CoinValue currency1CoinName greater/less/equal than currency2NoteValue currency2NoteName currency2CoinValue currency2CoinName
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm isCurrencyGreater(comparedCurrency)
     *      currencyGreater = false
     *      isEqual = false
     *
     *      if(currencyNoteValue > comparedCurrencyNoteValue) currencyGreater = true
     *      else if (currencyNoteValue > comparedCurrencyNoteValue)
     *          if(currencyCoinValue > comparedCurrencyCoinValue) currencyGreater = true
     *          if(currencyCoinValue == comparedCurrencyCoinValue) isEqual = true
     *
     *      printCurrency
     *      if(isEqual) print equal
     *      if(currencyGreater) print greater than
     *      else print less than
     *      print comparedCurrency
     **/

    //comparing two objects of the same currency to see which one is greater
    public void isCurrencyGreater(currency comparedCurrency) {
        boolean currencyGreater = false;
        boolean isEqual = false;

        if (getCurrencyNoteValue() > comparedCurrency.getCurrencyNoteValue()) {
            currencyGreater = true;
        } else if (getCurrencyNoteValue() == comparedCurrency.getCurrencyNoteValue()) {
            if (getCurrencyCoinValue() > comparedCurrency.getCurrencyCoinValue()) {
                currencyGreater = true;
            }
            if (getCurrencyCoinValue() == comparedCurrency.getCurrencyCoinValue()) {
                isEqual = true;
            }
        }

        printCurrency();
        if (isEqual) {
            System.out.println("is equal to");
        } else {
            System.out.println(currencyGreater ? "is greater than " : "is less than ");
        }
        comparedCurrency.printCurrency();
    }

    /**
     * This function prints a detailed version of the currency object
     * Pre:
     * no input
     * Post:
     * returns nothing as it is void but prints a line in the format : currencyNoteValue currencyCoinValue
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm printCurrency()
     *      print currencyNoteValue currencyCoinValue
     **/

    //prints details for a currency object
    public void printCurrency() {
        System.out.println(getCurrencyNoteValue() + " " + getCurrencyCoinValue());
    }
}
