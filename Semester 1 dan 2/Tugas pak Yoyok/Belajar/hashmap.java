package Belajar;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class hashmap {
    private Map<String, Saham> daftarsaham;

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

    public hashmap(){
        daftarsaham = new HashMap<>();
    }

    private void bacadatadarifile(String namaFile){
        try (BufferedReader reader = new BufferedReader(new FileReader(namaFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 3) {
                    String kode = parts[0].trim();
                    String emiten = parts[1].trim();
                    int jumlahLot = Integer.parseInt(parts[2].trim());
                    daftarsaham.put(kode, new Saham(kode, emiten, jumlahLot));
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Format jumlah lot tidak valid: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        
    }
}
