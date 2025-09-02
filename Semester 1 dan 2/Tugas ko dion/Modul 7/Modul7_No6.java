import java.util.ArrayList;

class Mahasiswa {
    String NIM;
    String Nama;
    int[] Quiz;
    int[] Nilai;
    char NilaiHuruf;

    Mahasiswa(String NIM, String Nama, int[] Quiz, int UTS, int UAS) {
        this.NIM = NIM;
        this.Nama = Nama;
        this.Quiz = Quiz;

        int totalQuiz = 0;
        for (int q : Quiz) {
            totalQuiz += q;
        }
        int rata2Quiz = totalQuiz / Quiz.length;

        this.Nilai = new int[4];
        this.Nilai[0] = rata2Quiz;
        this.Nilai[1] = UTS;
        this.Nilai[2] = UAS;
        this.Nilai[3] = (rata2Quiz + UTS + UAS) / 3;

        this.NilaiHuruf = tentukanNilaiHuruf(this.Nilai[3]);
    }

    private char tentukanNilaiHuruf(int NA) {
        if (NA >= 80) return 'A';
        else if (NA >= 70) return 'B';
        else if (NA >= 60) return 'C';
        else if (NA >= 50) return 'D';
        else return 'E';
    }
}

class RekapNilai {
    ArrayList<Mahasiswa> daftarMahasiswa;

    RekapNilai() {
        this.daftarMahasiswa = new ArrayList<>();
    }

    public void tambahMahasiswa(Mahasiswa mhs) {
        daftarMahasiswa.add(mhs);
    }

    public void tampilkanDaftarNilai() {
        System.out.println("No\tNIM\tNama\tQuiz\tUTS\tUAS\tNA\tN Huruf");
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            Mahasiswa mhs = daftarMahasiswa.get(i);
            System.out.print((i + 1) + "\t" + mhs.NIM + "\t" + mhs.Nama + "\t");
            for (int q : mhs.Quiz) {
                System.out.print(q + " ");
            }
            System.out.println("\t" + mhs.Nilai[1] + "\t" + mhs.Nilai[2] + "\t" + mhs.Nilai[3] + "\t" + mhs.NilaiHuruf);
        }
    }

    public void tampilkanRekapNilai() {
        int[] rekap = new int[5];
        for (Mahasiswa mhs : daftarMahasiswa) {
            switch (mhs.NilaiHuruf) {
                case 'A': rekap[0]++; break;
                case 'B': rekap[1]++; break;
                case 'C': rekap[2]++; break;
                case 'D': rekap[3]++; break;
                case 'E': rekap[4]++; break;
            }
        }
        System.out.println("Nilai A : " + rekap[0] + " orang");
        System.out.println("Nilai B : " + rekap[1] + " orang");
        System.out.println("Nilai C : " + rekap[2] + " orang");
        System.out.println("Nilai D : " + rekap[3] + " orang");
        System.out.println("Nilai E : " + rekap[4] + " orang");
    }
}

public class Modul7_No6 {
    public static void main(String[] args) {
        RekapNilai rekapNilai = new RekapNilai();

        rekapNilai.tambahMahasiswa(new Mahasiswa("001", "Ali", new int[]{80, 85}, 70, 75));
        rekapNilai.tambahMahasiswa(new Mahasiswa("002", "Budi", new int[]{60, 65}, 55, 60));
        rekapNilai.tambahMahasiswa(new Mahasiswa("003", "Citra", new int[]{90, 95}, 85, 90));

        rekapNilai.tampilkanDaftarNilai();
        rekapNilai.tampilkanRekapNilai();
    }
}

//i cant