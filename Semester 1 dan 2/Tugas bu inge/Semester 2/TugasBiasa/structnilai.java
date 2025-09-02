package TugasBiasa;
import java.util.Scanner;

class SMatKul {
    String kodeMK, namaMK;
    int SKS, banyakNilai;
    int[] nilai = new int[5];
    float[] bobotNilai = new float[5];
    float AA;
    char NA;
}

class SMhs {
    String nim, nama;
    int ambilSKS;
    SMatKul[] MK = new SMatKul[10]; // Maks 10 MK
    float IP;
}

public class structnilai {
    static Scanner sc = new Scanner(System.in);

    public static float hitungAngkaAkhir(SMatKul mk) {
        int total = 0, count = 0;
        for (int i = 0; i < mk.banyakNilai; i++) {
            total += mk.nilai[i];
            count++;
        }
        return count == 0 ? 0 : (float) total / count;
    }

    public static char konversiHuruf(float nilai) {
        if (nilai >= 80) return 'A';
        if (nilai >= 70) return 'B';
        if (nilai >= 60) return 'C';
        if (nilai >= 50) return 'D';
        return 'E';
    }

    public static float hitungIP(SMhs mhs) {
        float totalNilai = 0;
        int totalSKS = 0;
        for (int i = 0; i < mhs.ambilSKS; i++) {
            float angkaAkhir = hitungAngkaAkhir(mhs.MK[i]);
            mhs.MK[i].AA = angkaAkhir;
            mhs.MK[i].NA = konversiHuruf(angkaAkhir);
            totalNilai += angkaAkhir * mhs.MK[i].SKS;
            totalSKS += mhs.MK[i].SKS;
        }
        return totalSKS == 0 ? 0 : totalNilai / totalSKS;
    }

    public static void main(String[] args) {
        SMhs [] mhs = new SMhs [2];

        for (int i = 0; i < 2; i++){
            mhs[i] = new SMhs();
            System.out.println("Masukan Nim : ");
            mhs[i].nim = sc.nextLine();
            System.out.println("Masukan Nama : ");
            mhs[i].nama = sc.nextLine();
            System.out.println("Masukan Total SKS : ");
            mhs[i].ambilSKS = sc.nextInt();

            for(int j = 0; j < mhs[i].ambilSKS; j++){
                mhs[i].MK[j] = new SMatKul();
                System.out.print("Kode MK: ");
                mhs[i].MK[j].kodeMK = sc.next();
                System.out.print("Nama MK: ");
                mhs[i].MK[j].namaMK = sc.next();
                System.out.print("SKS: ");
                mhs[i].MK[j].SKS = sc.nextInt();
                System.out.print("Jumlah Nilai yang tersedia: ");
                mhs[i].MK[j].banyakNilai = sc.nextInt();
                for (int k = 0; k < mhs[i].MK[j].banyakNilai; k++) {
                    System.out.print("Nilai " + (k + 1) + ": ");
                    mhs[i].MK[j].nilai[k] = sc.nextInt();
                }
            }
            mhs[i].IP = hitungIP(mhs[i]);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("\nNIM: " + mhs[i].nim);
            System.out.println("Nama: " + mhs[i].nama);
            System.out.println("Kode MK\tNama MK\tNilai 1\tNilai 2\tNilai 3\tNilai 4\tNilai 5\tAngka Akhir\tHuruf");
            for (int j = 0; j < mhs[i].ambilSKS; j++) {
                SMatKul mk = mhs[i].MK[j];
                System.out.print(mk.kodeMK + "\t" + mk.namaMK + "\t");
                for (int k = 0; k < 5; k++) {
                    System.out.print((k < mk.banyakNilai ? mk.nilai[k] : "-") + "\t");
                }
                System.out.println(mk.AA + "\t" + mk.NA);
            }
            System.out.println("IP: " + mhs[i].IP);
        }
    }
}