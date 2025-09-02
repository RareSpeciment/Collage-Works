import java.util.Scanner;

public class mhsarray {

    int[] quizScores = new int[5];
    int nilUTS, nilUAS, totalmhs;
    double rQuis, nilAkhir;
    char nilMutu;

    public static double rataQuis(int[] quizScores) {
        int total = 0;
        for (int score : quizScores) {
            total += score;
        }
        return total / 5.0;
    }

    public static double angkaAkhir(double rataQuis, int UTS, int UAS) {
        return (rataQuis * 0.2) + (UTS * 0.3) + (UAS * 0.5);
    }

    public static char nilaiMutu(double angkaAkhir) {
        if (angkaAkhir >= 80) {
            return 'A';
        } else if (angkaAkhir >= 70) {
            return 'B';
        } else if (angkaAkhir >= 60) {
            return 'C';
        } else if (angkaAkhir >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        mhsarray Mhs = new mhsarray();
        System.out.print("Masukan total mahasiswa " );
        Mhs.totalmhs = sc.nextInt();

        for (int a = 0; a < Mhs.totalmhs; a++){

            for (int i = 0; i < Mhs.quizScores.length; i++) {
                System.out.print("Masukkan nilai Quiz " + (i + 1) + ": ");
                Mhs.quizScores[i] = sc.nextInt();
            }

            System.out.print("Masukkan nilai UTS: ");
            Mhs.nilUTS = sc.nextInt();
            System.out.print("Masukkan nilai UAS: ");
            Mhs.nilUAS = sc.nextInt();

            Mhs.rQuis = rataQuis(Mhs.quizScores);
            Mhs.nilAkhir = angkaAkhir(Mhs.rQuis, Mhs.nilUTS, Mhs.nilUAS);
            Mhs.nilMutu = nilaiMutu(Mhs.nilAkhir);

            System.out.println("Nilai rata-rata Quiz: " + Mhs.rQuis);
            System.out.println("Nilai akhir: " + Mhs.nilAkhir);
            System.out.println("Nilai mutu: " + Mhs.nilMutu);
    }
        sc.close();
    }
}
