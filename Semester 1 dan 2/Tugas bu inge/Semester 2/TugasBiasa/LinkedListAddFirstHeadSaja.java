package TugasBiasa;

import java.util.Scanner;

/**
 *
 * @author Inge Martina
 */
class NodeHeadSaja{
    String nim;
    String nama;
    NodeHeadSaja next;
    
} 
public class LinkedListAddFirstHeadSaja {
   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NodeHeadSaja head = null;
        
        System.out.println("NIM: (0 = berhenti)");
        String nim = scanner.next();
        while (!nim.equals("0")){
            System.out.println("Nama: ");
            String nama = scanner.next();
            NodeHeadSaja newNode = new NodeHeadSaja();
            newNode.nim = nim;
            newNode.nama = nama;
           
            // menyambung
            newNode.next = head;
            head = newNode;
            // menyambung
            
            System.out.println("NIM: (0 = berhenti)");
            nim = scanner.next();
        }
        
        NodeHeadSaja current = head;
        System.out.println("Linked list add first HEAD SAJA");
        while (current != null){
            System.out.println(current.nim+" "+current.nama);
            current = current.next;
        }
        
    }
}
