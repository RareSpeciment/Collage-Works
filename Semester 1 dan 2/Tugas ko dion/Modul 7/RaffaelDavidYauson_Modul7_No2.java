// Class Alamat
class Alamat {
    String jalan;
    String kota;
    String provinsi;

    public Alamat(String jalan, String kota, String provinsi) {
        this.jalan = jalan;
        this.kota = kota;
        this.provinsi = provinsi;
    }

    public String toString() {
        return jalan + ", " + kota + ", " + provinsi;
    }
}

class Penghasilan {
    double gaji;
    double tunjanganTransport;
    double tunjanganMakan;

    public Penghasilan(double gaji, double tunjanganTransport, double tunjanganMakan) {
        this.gaji = gaji;
        this.tunjanganTransport = tunjanganTransport;
        this.tunjanganMakan = tunjanganMakan;
    }

    public String toString() {
        return "Gaji: " + gaji + ", Transport: " + tunjanganTransport + ", Makan: " + tunjanganMakan;
    }
}

class Karyawan {
    String nama;
    String jabatan;
    Alamat alamat;
    Penghasilan penghasilan;

    public Karyawan(String nama, String jabatan, Alamat alamat, Penghasilan penghasilan) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.alamat = alamat;
        this.penghasilan = penghasilan;
    }

    public String toString() {
        return "Nama: " + nama + ", Jabatan: " + jabatan + ", Alamat: " + alamat + ", Penghasilan: " + penghasilan;
    }
}

public class RaffaelDavidYauson_Modul7_No2 {
    public static void main(String[] args) {
        Alamat alamat1 = new Alamat("BRUH", "BRUH", "BRUH");
        Penghasilan penghasilan1 = new Penghasilan(5000000, 100000, 200000);

        Alamat alamat2 = new Alamat("BRUH", "BRUH", "BRUH");
        Penghasilan penghasilan2 = new Penghasilan(6000000, 150000, 250000);

        Alamat alamat3 = new Alamat("Strawberry Raya", "palangkaraya", "kalimantan");
        Penghasilan penghasilan3 = new Penghasilan(7000000, 200000, 300000);

        // Membuat objek Karyawan
        Karyawan karyawan1 = new Karyawan("walahi", "karyawan", alamat1, penghasilan1);
        Karyawan karyawan2 = new Karyawan("Raffael", "karyawan", alamat2, penghasilan2);
        Karyawan karyawan3 = new Karyawan("andi", "karyawan", alamat3, penghasilan3);

        Karyawan[] karyawanArray = { karyawan1, karyawan2, karyawan3 };
        
        for (Karyawan karyawan : karyawanArray) {
            System.out.println(karyawan);
        }
    }
}
