public class lab4main {
    public static void main(String[] args){
        LinkedList l = new LinkedList();
        l.addToList(new LinkedNode(new money(1,2)));
        l.addToList(new LinkedNode(new money(10,20)));
        l.addToList(new LinkedNode(new money(100,200)));
        System.out.println(l.deleteFromList(new LinkedNode(new money(10,20))));

        l.printList();
    }
}
