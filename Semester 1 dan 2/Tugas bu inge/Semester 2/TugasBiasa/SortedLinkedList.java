package TugasBiasa;
import java.util.Scanner;

class Node {
    String nim;
    String nama;
    Node next;

    // Constructor untuk node baru
    public Node(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
    }
}

public class SortedLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node head = null;

        // Menambahkan data ke dalam sorted linked list
        System.out.println("Masukkan NIM (0 = berhenti): ");
        String nim = scanner.next();
        
        while (!nim.equals("0")) {
            System.out.println("Masukkan Nama: ");
            String nama = scanner.next();

            // Menambahkan elemen ke dalam sorted linked list
            head = insertSorted(head, nim, nama);

            // Tanyakan lagi untuk memasukkan data berikutnya
            System.out.println("Masukkan NIM (0 = berhenti): ");
            nim = scanner.next();
        }

        // Menampilkan isi linked list
        System.out.println("Isi Sorted Linked List: ");
        printList(head);
    }

    // Fungsi untuk menyisipkan node pada posisi yang sesuai dalam sorted linked list
    public static Node insertSorted(Node head, String nim, String nama) {
        Node newNode = new Node(nim, nama);

        // Kasus 1: Jika linked list kosong atau node baru harus menjadi head
        if (head == null || Integer.parseInt(nim) < Integer.parseInt(head.nim)) {
            newNode.next = head;
            head = newNode;
        } else {
            // Kasus 2: Menyisipkan node pada posisi yang benar di tengah atau akhir
            Node current = head;
            while (current.next != null && Integer.parseInt(nim) > Integer.parseInt(current.next.nim)) {
                current = current.next;
            }

            // Menyisipkan node baru setelah node current
            newNode.next = current.next;
            current.next = newNode;
        }

        return head;
    }

    // Fungsi untuk menampilkan isi linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.nim + " " + current.nama);
            current = current.next;
        }
    }
}
