package Modul14;
import java.util.ArrayList;

public class percobaan3 {
    static class node {
        private int data;
        public node(int data) { this.data = data; }
        public void setData(int data) { this.data = data; }
        public int getData() { return data; }
    }

    private ArrayList<node> heapArray = new ArrayList<>();

    public boolean isEmpty() {
        return heapArray.isEmpty();
    }

    public boolean insert(node newNode) {
        heapArray.add(newNode);
        trikleUp(heapArray.size() - 1);
        return true;
    }

    public node remove() {
        if (heapArray.isEmpty()) return null;
        node root = heapArray.get(0);
        node last = heapArray.remove(heapArray.size() - 1);
        if (!heapArray.isEmpty()) {
            heapArray.set(0, last);
            trikleDown(0);
        }
        return root;
    }

    public void trikleUp(int index) {
        int parentIndex;
        node bottom = heapArray.get(index);
        while (index > 0) {
            parentIndex = (index - 1) / 2;
            if (heapArray.get(parentIndex).getData() >= bottom.getData()) break;
            heapArray.set(index, heapArray.get(parentIndex));
            index = parentIndex;
        }
        heapArray.set(index, bottom);
    }

    public void trikleDown(int index) {
        int largerChild;
        node top = heapArray.get(index);
        int size = heapArray.size();
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < size && heapArray.get(leftChild).getData() < heapArray.get(rightChild).getData()) {
                largerChild = rightChild;
            } else {
                largerChild = leftChild;
            }
            if (top.getData() >= heapArray.get(largerChild).getData()) break;
            heapArray.set(index, heapArray.get(largerChild));
            index = largerChild;
        }
        heapArray.set(index, top);
    }

    public void displayHeap() {
        System.out.println("Heap Array: ");
        for (int i = 0; i < heapArray.size(); i++) {
            System.out.print(heapArray.get(i).getData() + " ");
        }
        System.out.println();
    }
}