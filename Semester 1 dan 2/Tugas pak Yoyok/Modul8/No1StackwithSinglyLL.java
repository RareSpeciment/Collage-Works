public class No1StackwithSinglyLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    class Stack {
        Node first = null;

        public Stack(){
            first = null;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public void push(int data) {
            Node newNode = new Node(data);
            if (first == null) {
                first = newNode;
            } else {
                newNode.next = first;
                first = newNode;
            }
        }

        public Node pop() {
            return removeFirst();
        }

        public void clear() {
            first = null;
        }

        public int peek() {
            if (first == null) {
                return -1; // or throw an exception
            } else {
                return first.data;
            }
        }

        public Node getFirst() {
            return first;
        }
    
        public Node removeFirst() {
            if (first == null) {
                return null;
            } else {
                Node temp = first;
                first = first.next;
                return temp;
            }
        }

        public boolean print() {
            if (first == null) {
                return true; // stack is empty
            } else {
                Node current = first;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
                return false; // stack is not empty
            }
        }
    }
    public static void main(String[] args) {
        Stack stack = new No1StackwithSinglyLL().new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        //melihat full satck
        System.out.println("Stack contents: ");
        System.out.println("Stack created. Is empty? " + stack.print());

        //melihat isi stack paling atas
        System.out.println("Top element is: " + stack.peek()); // 30

        //mengeluarkan sebuah elemen dari stack
        System.out.println("Popped element is: " + stack.pop().data); // 30
        System.out.println("Top element is: " + stack.peek()); // 20

        //clear stack
        stack.clear();
        System.out.println("Stack cleared. Is empty? " + stack.isEmpty());
    }
}
