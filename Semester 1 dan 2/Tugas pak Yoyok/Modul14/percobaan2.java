package Modul14;

public class percobaan2 {
    static class node{
        private int data;

        public node(int data) {this.data = data;}
        public void setData(int data) {this.data = data;}
        public int getData() {return data;}
    }

    static class Heap{
        private node[] heapArray;
        private int MaxSize;
        private int currentSize;
        
        public Heap(int MaxSize){
            this.MaxSize = MaxSize;
            heapArray = new node[MaxSize];
            currentSize = 0;
        }

        public boolean isFull(){
            return currentSize == MaxSize;
        }

        public boolean isEmpty(){
            return currentSize == 0;
        }

        public boolean insert(node newNode){
            if(heapArray == null || isFull()){
                return false;
            } else {
                heapArray[currentSize] = newNode;
                trikleUp(currentSize++);
                return true;

            }
        }

        public node remove(){
            node root = heapArray[0];
            heapArray[0] = heapArray[--currentSize];
            trikleDown(0);
            return root;
        }

        public void trikleUp(int index){
            int parentIndex;
            node bottom = heapArray[index];

            while (index > 0) {
                parentIndex = (index - 1) / 2;
                if (heapArray[parentIndex].getData() >= bottom.getData()) {
                    break;
                }
                heapArray[index] = heapArray[parentIndex];
                index = parentIndex;
            }
            heapArray[index] = bottom;
        }

        public void trikleDown(int index){
            int largerChild;
            node top = heapArray[index];

            while (index < currentSize / 2) {
                int leftChild = 2 * index + 1;
                int rightChild = leftChild + 1;

                if (rightChild < currentSize && heapArray[leftChild].getData() < heapArray[rightChild].getData()) {
                    largerChild = rightChild;
                } else {
                    largerChild = leftChild;
                }

                if (top.getData() >= heapArray[largerChild].getData()) {
                    break;
                }

                heapArray[index] = heapArray[largerChild];
                index = largerChild;
            }
            heapArray[index] = top;
        }

        public void displayHeap(){
            System.out.println("Heap Array: ");
            for(int i = 0; i < currentSize; i++){
                if(heapArray[i] != null){
                    System.out.print(heapArray[i].getData() + " ");
                } else {
                    System.out.print("-- ");
                }
            }
            System.out.println();

            int nBlanks = 32;
            int itemPerRow = 1;
            int column = 0;
            int j = 0;
            String dots = "...............................";
            System.out.println(dots + dots);

            while (currentSize > 0) {
                if(column ==0){
                    for(int k = 0; k < nBlanks; k++){
                        System.out.print(" ");
                    }
                }
                System.out.print(heapArray[j].getData());
                if(++j == currentSize) {
                    break;
                }
                if(++column == itemPerRow) {
                    nBlanks /= 2;
                    itemPerRow *= 2;
                    column = 0;
                    System.out.println();
                } else {
                    for(int k = 0; k < nBlanks * 2 - 2; k++){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("\n" + dots + dots);
        }
    
    }
    public static void main(String[] args) {
        int maxSize = 31;
        Heap h = new Heap(maxSize);
        h.insert(new node(70));
        h.insert(new node(40));
        h.insert(new node(50));
        h.insert(new node(20));
        h.insert(new node(60));
        h.insert(new node(100));
        h.insert(new node(80));
        h.insert(new node(30));
        h.insert(new node(10));
        h.insert(new node(90));
        h.insert(new node(35));
    }
}
