/**
 * Name: Mihir Achyuta
 * Lab Number: 5
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a BST and a BSTNode ADT containing money objects and to perform various traversals on the BST tree
 * along with allowing the user to insert, delete, and search nodes in the BST.
 **/

public class money extends currency {
    //String attributes for the currency note name and the currency coin name
    private String currencyNoteName;
    private String currencyCoinName;

    //default constructor with no parameters passed
    public money() {
        this.currencyNoteName = "Dollar";
        this.currencyCoinName = "Cent";
    }

    //constructor with only the currency note value and coin value passed
    //passes currency parameters to currency object and default values for money object
    public money(int currencyNoteValue, int currencyCoinValue) {
        super(currencyNoteValue, currencyCoinValue);
        this.currencyNoteName = "Dollar";
        this.currencyCoinName = "Cent";
    }

    /**
     * These functions get the note name and coin name string attributes
     * Pre:
     * no input
     * Post:
     * returns a string with the currency note name or the currency coin name depending on the getter function
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm getCurrencyNote/CoinName()
     *      return currencyNote/CoinName
     **/

    //getters for note name and coin name
    public String getCurrencyNoteName() {
        return currencyNoteName;
    }

    public String getCurrencyCoinName() {
        return currencyCoinName;
    }

    /**
     * This function prints a detailed version of the money object
     * Pre:
     * no input
     * Post:
     * returns nothing as it is void but prints a line in the format : currencyNoteValue currencyNoteName currencyCoinValue currencyCoinName
     **/

    // @formatter:off
    /**
     * Pseudocode:
     * Algorithm printCurrency()
     *      print currencyNoteValue + currencyNoteName  + currencyCoinValue + currencyCoinName
     **/

    //prints details for a money object and overrides the currency print
    @Override
    public void printCurrency() {
        System.out.println(getCurrencyNoteValue() + " " + getCurrencyNoteName() + " " + getCurrencyCoinValue() + " " + getCurrencyCoinName());
    }
}