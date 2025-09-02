package Belajar.LinkedList;
public class LList1 {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static class LinkedListManual{
        static Node head = null;

        void addFirst(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
            }else{
                newNode.next = head;
                head = newNode;
            }
        }

        void addLast(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
            }else{
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
        }

        void deleteFirst(){
            if(head == null){
                System.out.println("Data kosong");
            }else{
                head = head.next;
            }
        }

        void deleteLast(){
            if(head == null){
                System.out.println("Data Kosong");
            }else{
                if (head.next == null) {
                    head = null;
                }else{
                    Node current = head;
                    while (current.next.next != null) {
                        current = current.next;
                    }
                    current.next = null;
                }
            }
        }

        void deletebyValue(int value){
            if(head == null){
                System.out.println("Data kosong");
            }else{
                if (head.data == value) {
                    head = head.next;
                }else{
                    Node current = head;
                    Node prev = null;
                    while(current.data != value && current.next != null) {
                        prev = current;
                        current = current.next;
                    }
                    if(current.data == value){
                        prev.next = current.next;
                    }else{
                        System.out.println("Data tidak ditemukan");
                    }
                }
            }
        }

        void printlist(){
            Node current = head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println("It's already null");
        }
    }
    public static void main(String[] args) {
        LinkedListManual list = new LinkedListManual();
        list.addFirst(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.printlist();
        list.deleteLast();
        list.printlist();
        list.deletebyValue(20);
        list.printlist();
    }
}