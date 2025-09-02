package Belajar.Stack;
public class stck1 {
    static private int[] stack;
    static private int top;
    static private int capacity;

    //stack capacity
    public stck1(int size){
        capacity = size;
        stack = new int[capacity];
        top = -1;
    }

    //penambahan data dalam stack jika dia full maka dia akan memanggil isFull 
    //jika tidak maka menambahkan data kedalam stack
    public void push(int value){
        if (isFull()) {
            System.out.println("Stack is full");
        }else{
            stack[++top] = value;
        }
    }

    //untuk mengeluarkan data yang berada di stack
    public int pop(){
        if(top == -1){
            System.out.println("Stack kosong");
            return -1;
        }else{
            int value = stack[top];
            top = top - 1;
            return value;
        }
    }

    public static int peek(){
        if(top == -1){
            System.out.println("stack kosong");
            return -1;
        }else{
            return stack[top];
        }
    }

    //pengecekan apakah dia full apa tidak didalam stack tersebut
    public static boolean isFull(){
        return top == capacity - 1;
    }

    //pengecekan apakah dia kosong apa tidak
    public static boolean isEmpty(){
        return top == -1;
    }

    public static void print(){
        for (int i = 0; i <= top; i++) {
            System.out.println(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stck1 s = new stck1(2);

        // s.push(7);
        // s.push(14);
        // s.push(21);
        // print();

        // System.out.println("Stack paling atas : " + peek());
        // int value = s.pop();
        // System.out.println("elemen di - pop : " + value);
        // System.out.println("Stack yang paling atas sekarang : " + peek());
        // // s.push(20);
        // // print();
        // // //stack is full

        // // //mengeluarkan data yang paling atas dan memasukan data baru lagi
        // // s.pop();
        // // s.push(20);
        // // print();

        System.out.println("apakah kosong ? " + isEmpty());
        s.push(10);
        s.push(20);
        System.out.println("apakah penuh ? " + isFull());
        s.pop();
        System.out.println("apakah kosong ? " + isEmpty());
        System.out.println("apakah penuh ? " + isFull());
    }
}
