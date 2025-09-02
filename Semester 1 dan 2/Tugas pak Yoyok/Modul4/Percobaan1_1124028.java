package Modul4;

public class Percobaan1_1124028 {\
    class Node{
        int data;
        Node next;

        public Node(){
        }

        public Node (int data){
            this.data = data;
            this.next = null;
        }

        public void setData(int data){
            this.data = data;
        }

        public int getData(int data){
            return data;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public Node getNext(){
            return next;
        }
    }
    public static void main(String[] args) {
        addFirts(new Node(5));
    }
}
