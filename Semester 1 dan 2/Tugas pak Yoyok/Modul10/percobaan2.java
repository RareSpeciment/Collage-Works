package Modul10;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class percobaan2 {
    private Map<String, Saham> daftarSaham;

    private static class Saham {
        private String kode;
        private String emiten;
        private int jumlahLot;

        public Saham(String kode, String emiten, int jumlahLot) {
            this.kode = kode;
            this.emiten = emiten;
            this.jumlahLot = jumlahLot;
        }

        @Override
        public String toString() {
            return "Kode: " + kode + 
                   "\nEmiten: " + emiten + 
                   "\nJumlah Lot: " + jumlahLot;
        }
    }

    public percobaan2() {
        daftarSaham = new HashMap<>();
        bacaDataDariFile("saham.txt");
    }

    private void bacaDataDariFile(String namaFile) {
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String kode = parts[0].trim();
                    String emiten = parts[1].trim();
                    int jumlahLot = Integer.parseInt(parts[2].trim());
                    daftarSaham.put(kode, new Saham(kode, emiten, jumlahLot));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format jumlah lot tidak valid: " + e.getMessage());
        }
    }

    public Saham cariSaham(String kode) {
        return daftarSaham.get(kode.toUpperCase());
    }

    public boolean tambahSaham(String kode, String emiten, int jumlahLot) {
        kode = kode.toUpperCase();
        if (!daftarSaham.containsKey(kode)) {
            daftarSaham.put(kode, new Saham(kode, emiten, jumlahLot));
            return true;
        }
        return false;
    }

    public boolean ubahJumlahLot(String kode, int jumlahLotBaru) {
        Saham saham = daftarSaham.get(kode.toUpperCase());
        if (saham != null) {
            saham.jumlahLot = jumlahLotBaru;
            return true;
        }
        return false;
    }

    // d. Menghapus KoleksiSaham jika jumlah lot = 0
    public boolean hapusSaham(String kode) {
        Saham saham = daftarSaham.get(kode.toUpperCase());
        if (saham != null && saham.jumlahLot == 0) {
            daftarSaham.remove(kode.toUpperCase());
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        percobaan2 koleksi = new percobaan2();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("\n=== MENU KOLEKSI SAHAM ===");
            System.out.println("1. Cari Saham");
            System.out.println("2. Tambah Saham");
            System.out.println("3. Ubah Jumlah Lot");
            System.out.println("4. Hapus Saham (jika lot=0)");
            System.out.println("5. Tampilkan Semua Saham");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan kode saham: ");
                    String kodeCari = scanner.nextLine();
                    Saham hasilCari = koleksi.cariSaham(kodeCari);
                    System.out.println(hasilCari != null ? hasilCari : "Saham tidak ditemukan");
                    break;
                    
                case 2:
                    System.out.print("Masukkan kode saham: ");
                    String kodeBaru = scanner.nextLine();
                    System.out.print("Masukkan nama emiten: ");
                    String emiten = scanner.nextLine();
                    System.out.print("Masukkan jumlah lot: ");
                    int lot = scanner.nextInt();
                    scanner.nextLine();
                    if (koleksi.tambahSaham(kodeBaru, emiten, lot)) {
                        System.out.println("Saham berhasil ditambahkan");
                    } else {
                        System.out.println("Kode saham sudah ada");
                    }
                    break;
                    
                case 3:
                    System.out.print("Masukkan kode saham: ");
                    String kodeUbah = scanner.nextLine();
                    System.out.print("Masukkan jumlah lot baru: ");
                    int lotBaru = scanner.nextInt();
                    scanner.nextLine();
                    if (koleksi.ubahJumlahLot(kodeUbah, lotBaru)) {
                        System.out.println("Jumlah lot berhasil diubah");
                    } else {
                        System.out.println("Saham tidak ditemukan");
                    }
                    break;
                    
                case 4:
                    System.out.print("Masukkan kode saham: ");
                    String kodeHapus = scanner.nextLine();
                    if (koleksi.hapusSaham(kodeHapus)) {
                        System.out.println("Saham berhasil dihapus");
                    } else {
                        System.out.println("Saham tidak ditemukan atau jumlah lot tidak nol");
                    }
                    break;
                    
                case 5:
                    System.out.println("\nDaftar Semua Saham:");
                    koleksi.daftarSaham.values().forEach(System.out::println);
                    break;
                    
                case 6:
                    System.out.println("Keluar dari program");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
    }
}