package Modul9;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Singly Linked List
class SinglyLinkedList {
    Node head;
    Node tail;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int removeLast() {
        if (head == null) {
            return -1;
        }
        if (head == tail) {
            int data = head.data;
            head = tail = null;
            return data;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        int data = tail.data;
        tail = current;
        tail.next = null;
        return data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Stack class
class Stack {
    SinglyLinkedList list = new SinglyLinkedList();

    public void push(int data) {
        list.add(data);
    }

    public int pop() {
        return list.removeLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void printStack() {
        list.printList();
    }
}

// Main Arithmetic class
public class percobaan3 {
    Stack theStack = new Stack();
    Stack postfixStack = new Stack();

    public int getPrecedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    public void toPostfix(String infix) {
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isDigit(ch)) {
                postfixStack.push(ch - '0'); // push angka
            } else if (ch == '(') {
                theStack.push((int) ch);
            } else if (ch == ')') {
                while (!theStack.isEmpty() && theStack.list.tail.data != '(') {
                    postfixStack.push(theStack.pop());
                }
                theStack.pop(); // pop '('
            } else { // operator
                while (!theStack.isEmpty() &&
                       getPrecedence((char) theStack.list.tail.data) >= getPrecedence(ch)) {
                    postfixStack.push(theStack.pop());
                }
                theStack.push((int) ch);
            }
        }

        while (!theStack.isEmpty()) {
            postfixStack.push(theStack.pop());
        }
    }

    public int evaluatePostfix() {
        Stack evalStack = new Stack();

        // Copy isi postfixStack ke array biar urut
        java.util.Stack<Integer> tempStack = new java.util.Stack<>();
        while (!postfixStack.isEmpty()) {
            tempStack.push(postfixStack.pop());
        }

        // Baca dari array
        while (!tempStack.isEmpty()) {
            int token = tempStack.pop();
            if (token >= 0 && token <= 9) { // angka
                evalStack.push(token);
            } else { // operator
                int b = evalStack.pop();
                int a = evalStack.pop();
                int result = 0;
                switch ((char) token) {
                    case '+':
                        result = a + b;
                        break;
                    case '-':
                        result = a - b;
                        break;
                    case '*':
                        result = a * b;
                        break;
                    case '/':
                        result = a / b;
                        break;
                    case '^':
                        result = (int) Math.pow(a, b);
                        break;
                }
                evalStack.push(result);
            }
        }
        return evalStack.pop();
    }

    public static void main(String[] args) {
        percobaan3 op = new percobaan3();
        String input = "3+5*(2-7/(1+6))";
        System.out.println("Input Infix : " + input);

        op.toPostfix(input);
        System.out.print("Postfix     : ");
        op.postfixStack.printStack();

        int result = op.evaluatePostfix();
        System.out.println("Hasil Evaluasi : " + result);
    }
}
