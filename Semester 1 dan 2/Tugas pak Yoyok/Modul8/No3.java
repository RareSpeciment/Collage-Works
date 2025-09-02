public class No3 {
    public static class Node {
        char value;
        Node next;
    
        public Node(char value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class SinglyLinkedList {
        private Node head;
    
        public void push(char value) {
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    
        public char pop() {
            if (isEmpty()) throw new RuntimeException("Stack kosong");
            char value = head.value;
            head = head.next;
            return value;
        }
    
        public char peek() {
            if (isEmpty()) throw new RuntimeException("Stack kosong");
            return head.value;
        }
    
        public boolean isEmpty() {
            return head == null;
        }
    }

    public class InfixToPostfix {
        public static int precedence(char operator) {
            return switch (operator) {
                case '+', '-' -> 1;
                case '*', '/' -> 2;
                default -> -1;
            };
        }
    
        public static String convert(String expression) {
            SinglyLinkedList stack = new SinglyLinkedList();
            StringBuilder result = new StringBuilder();
    
            for (char ch : expression.toCharArray()) {
                if (Character.isDigit(ch)) {
                    result.append(ch);
                } else if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        result.append(stack.pop());
                    }
                    stack.pop(); // buang '('
                } else if ("+-*/".indexOf(ch) != -1) {
                    while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                        result.append(stack.pop());
                    }
                    stack.push(ch);
                }
            }
    
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
    
            return result.toString();
        }
    }

    public class Main {
        public static void main(String[] args) {
            String[] ekspresi = { 
                "3*5+2*7", 
            "(3+5)*(2-7)", 
            "((3+5)*2)-7", 
            "3+5*(2-7/(1+6))" 
        };
    
            for (String exp : ekspresi) {
                System.out.println("Infix: " + exp);
                System.out.println("Postfix: " + InfixToPostfix.convert(exp));
                System.out.println();
            }
        }
    }    
}
