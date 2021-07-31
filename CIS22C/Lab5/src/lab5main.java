import java.io.IOException;

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

        for(money m : originalMoney) moneyTree.insert(new BSTNode(m));
        printAllTraversals(moneyTree);
    }

    public static void printAllTraversals(BST moneyTree) throws IOException {
        moneyTree.bfs();
        moneyTree.inOrder();
        moneyTree.preOrder();
        moneyTree.postOrder();
    }
}
