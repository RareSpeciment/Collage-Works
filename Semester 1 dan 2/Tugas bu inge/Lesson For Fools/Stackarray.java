public class Stackarray {
    private int maxSize;
    private int[] stack;
    private int top;

    public Stackarray(int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean push(int data){
        if (top == maxSize - 1) {
            System.out.println("Stack is full");
            return false;
        } else {
            stack[++top] = data;
            return true;
        }
    }

    public int pop(){
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top--];
        }
    }

    public int peek(){
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return stack[top];
        }
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public void printStack(){
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }   
    }

    public static void main(String[] args) {
        Stackarray stack = new Stackarray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: 30 20 10 
        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 30
        stack.pop();
        stack.printStack(); // Output: 20 10 
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? false
        System.out.println("Is stack full? " + stack.isFull()); // Output: Is stack full? false
        stack.push(40); 
        stack.printStack();
    }
}
