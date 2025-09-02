package TugasBiasa;
import java.util.Scanner;

class NodeTail {
    String nim;
    String nama;
    NodeTail next;
}

public class LinkedListAddLast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodeTail head = null;
        NodeTail tail = null;  // Menyimpan referensi ke node terakhir
        
        System.out.println("NIM: (0 = berhenti)");
        String nim = scanner.next();
        
        while (!nim.equals("0")) {
            System.out.println("Nama: ");
            String nama = scanner.next();
            
            // Membuat node baru
            NodeTail newNode = new NodeTail();
            newNode.nim = nim;
            newNode.nama = nama;
            newNode.next = null;  // Node baru akan menjadi yang terakhir
            
            // Menambahkan node di akhir (add last)
            if (head == null) {
                // Jika linked list kosong, node pertama menjadi head dan tail
                head = newNode;
                tail = newNode;
            } else {
                // Jika linked list tidak kosong, sambungkan tail dengan node baru
                tail.next = newNode;
                tail = newNode;  // Update tail ke node baru
            }
            
            System.out.println("NIM: (0 = berhenti)");
            nim = scanner.next();
        }
        
        // Menampilkan isi linked list
        NodeTail current = head;
        System.out.println("Linked list add last");
        while (current != null) {
            System.out.println(current.nim + " " + current.nama);
            current = current.next;
        }
    }
}
