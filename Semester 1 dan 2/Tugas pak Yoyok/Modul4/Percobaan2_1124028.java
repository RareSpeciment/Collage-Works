package Modul4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Percobaan2_1124028 {
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
        Saham saham; // data berisi detail tiap saham
        Node next; // reference/pointer ke node berikutnya atau null

        public Node() { // default constructor
        }

        public Node(Saham saham) {
            this.saham = saham;
            this.next = null;
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
    }
    
    class OrderedSinglyLinkedList {
        private static Node head = null;

        /**
         * Menambahkan Node baru
         * Perhatikan bahwa penemabahan Node baru harus tetap menjaga urutan dari
         * OrderedSinglyLinkedList. Anda dapat menggunakan method compareTo() pada
         * class String untuk membandingkan dua buah String.
         */
        public static void add(Saham saham) {
            Node newNode = new Node(saham);

            if (head == null) {
                newNode.setNext(head);
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                newNode.setNext(temp.next);
                temp.setNext(newNode);
            }
        }

        /**
         * Mencari Saham tertentu berdasarkan kode saham
         */
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

        /**
         * Menampilkan semua Saham yang ada di Singly Linked List
         */
        public static void displayListSaham() {
            Node temp = head;
            while (temp != null) {
                System.out.println(temp.getSaham() + "\t");
                temp = temp.getNext();
            }
            System.out.println();
        }

        /**
         * Buatlah sebuah Singly Linked List dengan menggunakan objek Saham dimana
         * data Saham dapat Anda ambil dari file Saham.txt.
         * loc_file adalah Lokasi dimana file Saham.txt berada.
         */
        public static void readSaham(String loc_file) {
            try {
                File file = new File(loc_file);
                Scanner sc = new Scanner(file);
                sc.useDelimiter("[\t\r\n]+");

                while (sc.hasNext()) {
                    try{
                        String kode = sc.next();
                        String emiten = sc.next();
                        int jmlh_lot_saham = sc.nextInt();

                        Saham saham = new Saham(kode, emiten, jmlh_lot_saham);
                        add(saham);
                    }catch (Exception e){
                        System.out.println("Error reading data : " + e.getMessage());
                    }
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("File tidak ditemukan: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            readSaham("C:\\Users\\ACER GAMING\\OneDrive\\Dokumen\\Tugas pak Yoyok\\Modul4\\saham.txt");
            displayListSaham();
            
            //pertama mencari
            String carikodeA = "EXCL";
            Node result = search(carikodeA);

            if(result != null){
                System.out.println("Saham ditemukan ! " + result.getSaham());
            }else{
                System.out.println("Saham tidak ditemukan");
            }

            //kedua dalam mencari
            String carikodeB = "DEAL";
            result = search(carikodeB);

            if(result != null){
                System.out.println("Saham ditemukan ! " + result.getSaham());
            }else{
                System.out.println("Saham tidak ditemukan");
            }

            //pertama dalam menghapus
            String hapusKodeA = "ABBA";
            if (delete(hapusKodeA)) {
                System.out.println("Saham dengan kode " + hapusKodeA + " berhasil dihapus.");
            } else {
                System.out.println("Saham dengan kode " + hapusKodeA + " tidak ditemukan.");
            }

            //kedua dalam menghapus
            String hapusKodeB = "DMND";
            if (delete(hapusKodeB)) {
                System.out.println("Saham dengan kode " + hapusKodeB + " berhasil dihapus.");
            } else {
                System.out.println("Saham dengan kode " + hapusKodeB + " tidak ditemukan.");
            }



            add(new Saham("WLLG", "BANK Udin Janaideh", 100));
            System.out.println("Daftar Saham setelah penambahan:");
            displayListSaham();
        }
    }
}