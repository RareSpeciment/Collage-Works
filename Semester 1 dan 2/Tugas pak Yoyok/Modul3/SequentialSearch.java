import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Saham {
    String kode;
    String nama;
    int nilai;

    public Saham(String kode, String nama, int nilai) {
        this.kode = kode;
        this.nama = nama;
        this.nilai = nilai;
    }

    public String printSaham() {
        return "Kode: " + kode + ", Nama: " + nama + ", Nilai: " + nilai;
    }
}

public class SequentialSearch {
    static Saham[] arrSaham = new Saham[20]; 
    static int nElems = 0; 

    public static void createArraySaham() {
        try {
            File file = new File("C:\\Users\\ACER GAMING\\OneDrive\\Dokumen\\Tugas pak Yoyok\\Modul3\\saham.txt"); // Buka file saham.txt
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine() && nElems < arrSaham.length) {
                String line = scanner.nextLine();
                String[] data = line.split("\t");

                
                if (data.length == 3) {
                    String kode = data[0];
                    String nama = data[1];
                    int nilai = Integer.parseInt(data[2]);

                    arrSaham[nElems] = new Saham(kode, nama, nilai);
                    nElems++;
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan!");
        }
    }

    public static int search(int head, String kode) {
        if (head >= nElems) {
            return -1;
        }
        if (arrSaham[head].kode.equals(kode)) {
            return head;
        }
        return search(head + 1, kode);
    }

    public static void displaySaham(int index) {
        if (index >= 0 && index < nElems) {
            System.out.println(arrSaham[index].printSaham());
        } else {
            System.out.println("Saham tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        createArraySaham();

        String[] kodeSahamDicari = {"HOPE", "RELI", "AAPT"};
        for (String kode : kodeSahamDicari) {
            int index = search(0, kode);
            displaySaham(index);
        }
    }
}
