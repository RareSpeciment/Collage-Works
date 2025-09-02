package Modul2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Saham {
    private String kode;
    private String emiten;
    private int jumlahLot;

    public Saham() {
        this.kode = "";
        this.emiten = "";
        this.jumlahLot = 0;
    }

    public Saham(String kode, String emiten, int jumlahLot) {
        this.kode = kode;
        this.emiten = emiten;
        this.jumlahLot = jumlahLot;
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


    public int getJumlahLot() {
        return jumlahLot;
    }
    public void setJumlahSaham(int jumlahLot) {
        this.jumlahLot = jumlahLot;
    }

    public void printDetail() {
        System.out.println("Kode: " + kode + " | Emiten: " + emiten + " | Jumlah Lot: " + jumlahLot);
    }
}

public class ArraySaham {
    //A
    private Saham[] daftarSaham = new Saham[20]; // Array dengan ukuran tetap 20
    private int jumlahLot = 0;

    //B
    public void bacaDariFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine() && jumlahLot < 20) {
                String[] data = sc.nextLine().split("\t"); // Memisahkan data berdasarkan spasi
                if (data.length == 3) {
                    daftarSaham[jumlahLot++] = new Saham(data[0], data[1], Integer.parseInt(data[2]));
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan: " + e.getMessage());
        }
    }

    //C
    // Method untuk mencetak semua saham dalam array
    public void cetakSemuaSaham() {
        for (int i = 0; i < jumlahLot; i++) {
            daftarSaham[i].printDetail();
        }
    }

    //D
    // Method untuk mencari emiten saham berdasarkan indeks dalam array
    public String cariSahamBerdasarkanIndeks(int indeks) {
        if (indeks >= 0 && indeks < jumlahLot) {
            return daftarSaham[indeks].getEmiten();
        }
        return "Indeks tidak valid";
    }

    //E
    // Method untuk mencari indeks saham berdasarkan kode saham
    public int cariSahamBerdasarkanKode(String kode) {
        for (int i = 0; i < jumlahLot; i++) {
            if (daftarSaham[i].getKode().equalsIgnoreCase(kode)) {
                return i;
            }
        }
        return -1; // Jika tidak ditemukan
    }

    //F
    // Method untuk menambahkan saham baru ke dalam array (jika tidak duplikat)
    public void tambahSaham(Saham saham) {
        if (jumlahLot >= 20) {
            System.out.println("Array saham sudah penuh.");
            return;
        }
        for (int i = 0; i < jumlahLot; i++) {
            if (daftarSaham[i].getKode().equalsIgnoreCase(saham.getKode())) {
                System.out.println("Saham dengan kode " + saham.getKode() + " sudah ada.");
                return;
            }
        }
        daftarSaham[jumlahLot++] = saham;
    }

    //G
    // Method untuk menghapus saham jika jumlah lot-nya nol
    public void hapusSahamJikaLotNol(String kode) {
        for (int i = 0; i < jumlahLot; i++) {
            if (daftarSaham[i].getKode().equalsIgnoreCase(kode) && daftarSaham[i].getJumlahLot() == 0) {
                for (int j = i; j < jumlahLot - 1; j++) {
                    daftarSaham[j] = daftarSaham[j + 1];
                }
                daftarSaham[--jumlahLot] = null;
                break;
            }
        }
    }

    //H
    // Method untuk mencari saham dengan jumlah lot terbesar
    public Saham sahamDenganLotTerbesar() {
        Saham max = daftarSaham[0];
        for (int i = 1; i < jumlahLot; i++) {
            if (daftarSaham[i].getJumlahLot() > max.getJumlahLot()) {
                max = daftarSaham[i];
            }
        }
        return max;
    }

    //I
    // Method untuk mencari saham dengan jumlah lot terkecil
    public Saham sahamDenganLotTerkecil() {
        Saham min = daftarSaham[0];
        for (int i = 1; i < jumlahLot; i++) {
            if (daftarSaham[i].getJumlahLot() < min.getJumlahLot()) {
                min = daftarSaham[i];
            }
        }
        return min;
    }

    //J
    // Method untuk menghitung total jumlah lot dari semua saham dalam array
    public int totalJumlahLot() {
        int total = 0;
        for (int i = 0; i < jumlahLot; i++) {
            total += daftarSaham[i].getJumlahLot();
        }
        return total;
    }
    public static void main(String[] args) {

        //B
        ArraySaham arraySaham = new ArraySaham();
        arraySaham.bacaDariFile("C:\\Users\\ACER GAMING\\OneDrive\\Dokumen\\Tugas pak Yoyok\\Modul2\\saham.txt");
        

        //C
        // Mencetak seluruh saham
        arraySaham.cetakSemuaSaham();

        //D
        // Menampilkan emiten saham pada indeks ke-3
        System.out.println("Emiten pada indeks ke-3: " + arraySaham.cariSahamBerdasarkanIndeks(3));

        //E
        // Mencari indeks saham berdasarkan kode
        System.out.println("Index saham EXCL: " + arraySaham.cariSahamBerdasarkanKode("EXCL"));
        System.out.println("Index saham DEAL: " + arraySaham.cariSahamBerdasarkanKode("DEAL"));

        //F & G


        //H & I
        // Menampilkan saham dengan jumlah lot terbesar dan terkecil
        System.out.println("Saham dengan lot terbesar: " + arraySaham.sahamDenganLotTerbesar().getEmiten());
        System.out.println("Saham dengan lot terkecil: " + arraySaham.sahamDenganLotTerkecil().getEmiten());

        //J
        // Menampilkan total jumlah lot semua saham
        System.out.println("Total jumlah lot semua saham: " + arraySaham.totalJumlahLot());
   }
}

//idk what im doing right now