package Belajar.Queue;
public class quewe {
    static private int[] queue;
    static private int front;
    static private int rear;
    static private int capacity;

    public quewe(int size){
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void unqueue(int value){
        if (isFull()) {
            System.out.println("Queue Penuh");
        }else{
            rear++;
            queue[rear] = value;
            System.out.println("Unqueue : " + value);
        }
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue kosong");
            return -1;
        }else{
            int value = queue[front];
            front++;
            System.out.println("Dequeue : " + value);
            return value;
        }
    }
    
    public static boolean isFull(){
        return rear == capacity - 1;
    }

    public static boolean isEmpty(){
        return front > rear;
    }

    public static void main(String[] args) {
        quewe q = new quewe(3);

        q.unqueue(10);
        q.unqueue(20);
        q.unqueue(30);
        q.unqueue(40);

        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }
}
