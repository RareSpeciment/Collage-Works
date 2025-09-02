import java.util.*;

class MataKuliah {
    String kode;
    String nama;
    int sks;

    MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nama = nama;
        this.sks = sks;
    }
}

class Mahasiswa {
    String nim;
    String nama;
    String[] nilai;
    double ip;

    Mahasiswa(String nim, String nama, String[] nilai) {
        this.nim = nim;
        this.nama = nama;
        this.nilai = nilai;
    }

    void hitungIP(List<MataKuliah> matkulList) {
        int totalSKS = 0;
        double totalBobot = 0.0;

        for (int i = 0; i < nilai.length; i++) {
            String grade = nilai[i];
            int sks = matkulList.get(i).sks;
            double bobot = konversiNilai(grade);

            totalBobot += bobot * sks;
            totalSKS += sks;
        }

        this.ip = totalBobot / totalSKS;
    }

    double konversiNilai(String grade) {
        return switch (grade) {
            case "A" -> 4.0;
            case "A-" -> 3.7;
            case "B+" -> 3.4;
            case "B" -> 3.0;
            case "B-" -> 2.7;
            case "C+" -> 2.4;
            case "C" -> 2.0;
            case "D" -> 1.0;
            default -> 0.0; // E atau nilai tidak valid
        };
    }
}

public class gpakalkulasi {
    public static void main(String[] args) {
        // Daftar mata kuliah
        List<MataKuliah> matkulList = new ArrayList<>();
        matkulList.add(new MataKuliah("IF-1P3", "Desain Web", 2));
        matkulList.add(new MataKuliah("IF-104", "Algoritma dan Pemrograman", 4));
        matkulList.add(new MataKuliah("IF-1P4", "Prak. Algoritma dan Pemrograman", 1));
        matkulList.add(new MataKuliah("IF-105", "Pengantar Teknologi Informasi", 3));
        matkulList.add(new MataKuliah("KU-101", "Agama", 2));
        matkulList.add(new MataKuliah("KU-102", "English I", 2));
        matkulList.add(new MataKuliah("KU-103", "Core Skills and Character", 2));
        matkulList.add(new MataKuliah("KU-104", "Kalkulus I", 2));

        // Daftar mahasiswa
        List<Mahasiswa> mahasiswaList = new ArrayList<>();

        // Input data mahasiswa dari penggun
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Nilai (pisahkan dengan spasi, contoh: A A- B+ C): ");
        String[] nilai = scanner.nextLine().split(" ");
        mahasiswaList.add(new Mahasiswa(nim, nama, nilai));

        // Hitung IP dan tampilkan hasil
        System.out.println("NIM       Nama            Nilai (MK1-MK8)                                   IP");
        for (Mahasiswa m : mahasiswaList) {
            m.hitungIP(matkulList);
            System.out.println(m.nim + " " + m.nama + " " + Arrays.toString(m.nilai) + " " + String.format("%.2f", m.ip));
        }
    }
}
