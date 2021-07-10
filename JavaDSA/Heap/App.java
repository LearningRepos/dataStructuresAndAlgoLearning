import com.sun.source.tree.Tree;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(100);
        h.insert(40);
        h.insert(50);
        h.insert(10);
        h.insert(15);
        h.insert(50);
        h.insert(40);
        h.extractMax();
        h.extractMax();
        System.out.println(h.elements);
    }

    public static class Heap {
        //arraylist of heap elements
        List<Integer> elements = new ArrayList<>();

        public int insert(int value) {
            //adds the value to the heap and keeps track of the element index
            elements.add(value);
            int elementIndex = elements.size() - 1;

            //while the parent is less than the child then swap
            while (elements.get(elementIndex) > elements.get((elementIndex - 1) / 2)) {
                Collections.swap(elements, elementIndex, (elementIndex - 1) / 2);
                elementIndex = (elementIndex - 1) / 2;
            }
            return value;
        }

        public int extractMax() {
            //gets the max element and swaps it with the lowest element and deletes the original low element
            int maxElement = elements.get(0);
            int elementIndex = 0;
            elements.set(0, elements.get(elements.size() - 1));
            elements.remove(elements.size() - 1);
            if(elements.isEmpty()) return maxElement;

            while (true) {
                //initialize the left and right numbers
                int leftNumber = Integer.MIN_VALUE;
                int rightNumber = Integer.MIN_VALUE;

                //if the elements exist in the arraylist assign them
                if (elementIndex * 2 + 1 <= elements.size() - 1) {
                    leftNumber = elements.get(elementIndex * 2 + 1);
                }
                if (elementIndex * 2 + 2 <= elements.size() - 1) {
                    rightNumber = elements.get(elementIndex * 2 + 2);
                }

                //if the element is greater than both elements then it is in the correct place
                if(elements.get(elementIndex) > rightNumber && elements.get(elementIndex) > leftNumber){
                    break;
                } else {
                    //check which number is greater and swap it with the current element
                    if (rightNumber >= leftNumber) {
                        Collections.swap(elements, elementIndex, elementIndex * 2 + 2);
                        elementIndex = elementIndex * 2 + 2;
                    } else {
                        Collections.swap(elements, elementIndex, elementIndex * 2 + 1);
                        elementIndex = elementIndex * 2 + 1;
                    }
                }
            }

            return maxElement;
        }
    }
}
