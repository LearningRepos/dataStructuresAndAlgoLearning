/**
 * Name: Mihir Achyuta
 * Lab Number: 5
 * Purpose of the Assignment:
 * -The purpose of this assignment is to implement a BST and a BSTNode ADT containing money objects and to perform various traversals on the BST tree
 * along with allowing the user to insert, delete, and search nodes in the BST.
 **/

import java.io.IOException;
import java.util.*;

public class lab5main {
    public static void main(String[] args) throws IOException {
        money[] originalMoney = {
                new money(57, 12), new money(23, 44), new money(87, 43),
                new money(68, 99), new money(111, 22), new money(44, 55),
                new money(77, 77), new money(18, 36), new money(543, 21),
                new money(20, 21), new money(345, 67), new money(36, 18),
                new money(48, 48), new money(101, 0), new money(11, 0),
                new money(21, 0), new money(51, 0), new money(1, 0),
                new money(251, 0), new money(151, 0),
        };
        BST moneyTree = new BST();
        Scanner inputScanner = new Scanner(System.in);

        for (money m : originalMoney) moneyTree.insert(new BSTNode(m));
        printAllTraversals(moneyTree);

        System.out.println("Please enter commands (add/delete/search/traverse/exit) for the binary search tree: ");
        System.out.println("Commands must be entered in this form aside from exit/traverse: command_name decimal_number");
        System.out.println();
        while (true) {
            System.out.println("Please enter command (add/delete/search/traverse/exit) in form: command_name decimal_number");
            String[] result = inputScanner.nextLine().split(" ");

            if (result[0].equals("exit")) {
                System.out.println("Exiting Program and Printing traversals: ");
                printAllTraversals(moneyTree);
                System.out.println();
                break;
            } else if (result[0].equals("traverse")) {
                System.out.println("Printing traversals: ");
                printAllTraversals(moneyTree);
                System.out.println();
            } else if ((result[0].equals("add") || result[0].equals("delete") || result[0].equals("search")) && result.length == 2) {
                System.out.println("Performing command " + result[0] + " on the BST");

                String stringifiedDecimal = result[1];
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
                        if (result[0].equals("add")) moneyTree.insert(new BSTNode(new money(noteValue, coinValue)));
                        else if (result[0].equals("delete"))
                            moneyTree.delete(new BSTNode(new money(noteValue, coinValue)));
                        else if (result[0].equals("search")) {
                            BSTNode resultNode = moneyTree.search(new BSTNode(new money(noteValue, coinValue)));

                            if (resultNode == null) System.out.println("Node not found in tree");
                            else System.out.println("Node found in tree");
                        }
                    } else {
                        System.out.println("Note value and Coin value cannot have negative values");
                    }
                } catch (Exception e) {
                    //if decimal number not entered correctly, string wont parse correctly and exception thrown
                    //if currency is negative then exception thrown
                    System.out.println("Please enter a valid decimal number as " + stringifiedDecimal + " is invalid");
                }

                System.out.println("Performed command " + result[0] + " on the BST");
                System.out.println();
            }
        }
    }

    public static void printAllTraversals(BST moneyTree) throws IOException {
        moneyTree.bfs();
        moneyTree.inOrder();
        moneyTree.preOrder();
        moneyTree.postOrder();
    }
}
