import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

class Saham {
    private String kode;
    private String emiten;
    private int jumlahSaham;

    public Saham() {
        this.kode = "";
        this.emiten = "";
        this.jumlahSaham = 0;
    }

    public Saham(String kode, String emiten, int jumlahSaham) {
        this.kode = kode;
        this.emiten = emiten;
        this.jumlahSaham = jumlahSaham;
    }


    public String getKode() {
        return kode;
    }
    public void setKode(String kode) {
        this.kode = kode;
    }


    public String getEmiten() {
        return emiten;
    }
    public void setEmiten(String emiten) {
        this.emiten = emiten;
    }


    public int getJumlahSaham() {
        return jumlahSaham;
    }
    public void setJumlahSaham(int jumlahSaham) {
        this.jumlahSaham = jumlahSaham;
    }

    public void printDetail() {
        System.out.println("kode : " + kode + " emiten : " + emiten + " jumlah Saham : " + jumlahSaham);
    }
}

public class ReadTextFile {
    public static void main(String[] args) throws IOException {
        readText("C:\\Users\\ACER GAMING\\OneDrive\\Dokumen\\Tugas pak Yoyok\\Modul 1\\saham.txt");
    }

    public static void readText(String path) throws IOException {
        try (Scanner sc = new Scanner(new File(path))) {
            sc.useDelimiter("\t"); // Use tab as delimiter since your file uses tabs

            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] parts = data.split("\t"); // Memisahkan dengan TAB

                if (parts.length == 3) { // Memastikan ada 3 bagian
                    String kode = parts[0];
                    String emiten = parts[1];
                    int jumlahSaham = Integer.parseInt(parts[2]);

                    Saham saham = new Saham(kode, emiten, jumlahSaham);
                    saham.printDetail();
                } else {
                    System.out.println("Format data tidak valid: " + data);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Terjadi kesalahan: File tidak ditemukan - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Kesalahan format angka: " + e.getMessage());
        }
    }
}