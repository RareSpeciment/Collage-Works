import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RaffaelDavidYauson {
    public static class Saham {
        String kode;
        String emiten;
        int jmlh_lot_saham;

        public Saham(String kode, String emiten, int jmlh_lot_saham) {
            this.kode = kode;
            this.emiten = emiten;
            this.jmlh_lot_saham = jmlh_lot_saham;
        }

        public String toString() {
            return "Kode : " + kode + ", emiten: " + emiten + ", jmlh_lot_saham : " + jmlh_lot_saham;
        }
    }

    public static class Node {
        Saham saham;
        Node next;
        Node prev;

        public Node() { // default constructor
        }

        public Node(Saham saham) {
            this.saham = saham;
            this.next = null;
            this.prev = null;
        }

        public Saham getSaham() {
            return saham;
        }

        public void setNext(Node next) { // set reference ke node berikut
            this.next = next;
        }

        public Node getNext() { // get reference ke node berikutnya
            return next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        public Node getPrev(){
            return prev;
        }
    }

    class doublyLinkedList {
        private static Node head = null;
        private static Node tail = null;

        public static void add(Saham saham) {
            Node newNode = new Node(saham);
            if (tail != null){
                tail.setNext(newNode);
                newNode.setPrev(tail);
            }
            tail = newNode;
            if(head == null){
                head = newNode;
            }
        }

        public static Node search(String kode) {
            Node temp = head;

            while (temp != null) {
                if (temp.getSaham().kode.equals(kode)) {
                    return temp;
                }
                temp = temp.getNext();
            }
            return null;
        }

        /**
         * Menghapus Saham tertentu berdasarkan kode saham
         */
        public static boolean delete(String kode) {
            if (head == null)
                return false;

            if (head.getSaham().kode.equals(kode)) {
                head = head.next;
                return true;
            }

            Node temp = head;
            while (temp.next != null) {
                if (temp.next.getSaham().kode.equals(kode)) {
                    temp.setNext(temp.next.getNext());
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }

        public static void displayListSaham() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.getSaham() + "\t");
                temp = temp.getNext();
            }
            System.out.println();
        }

        public static void displayListbackwards() {
            Node trav = tail;
            while (trav != null) {
                System.out.println(trav.getSaham() + "\t");
                trav = trav.getPrev();
            }
            System.out.println();
        }

        public static void readSaham(String loc_file) {
            try {
                File file = new File(loc_file);
                Scanner sc = new Scanner(file);
                sc.useDelimiter("[\t\r\n]+");

                while (sc.hasNext()) {
                    try {
                        String kode = sc.next();
                        String emiten = sc.next();
                        int jmlh_lot_saham = sc.nextInt();

                        Saham saham = new Saham(kode, emiten, jmlh_lot_saham);
                        add(saham);
                    } catch (Exception e) {
                        System.out.println("Error reading data : " + e.getMessage());
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("File tidak ditemukan: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            readSaham("C:\\Users\\ACER GAMING\\OneDrive\\Dokumen\\Tugas pak Yoyok\\Modul5\\saham.txt");
            displayListbackwards();
        }
    }
}