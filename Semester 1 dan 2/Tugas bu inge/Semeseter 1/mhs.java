import java.util.Scanner;

public class mhs {

    int nil1, nil2, nil3 , nil4, nil5, nilUTS, nilUAS;
    double rQuis, nilAkhir;
    char nilMutu;
    
    public static double rataQuis(int nilai1, int nilai2, int nilai3, int nilai4, int nilai5) {
        int total = (nilai1 + nilai2 + nilai3 + nilai4 + nilai5) / 5;

        return total;
    }

    public static double angkaAkhir(double rataQuis, int UTS, int UAS) {
        double total1 = (rataQuis * 0.2) + (UTS * 0.3) + (UAS * 0.5);

        return total1;
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
        
        System.out.print("Masukkan nilai Quiz 1: ");
        int nil1 = sc.nextInt();
        System.out.print("Masukkan nilai Quiz 2: ");
        int nil2 = sc.nextInt();
        System.out.print("Masukkan nilai Quiz 3: ");
        int nil3 = sc.nextInt();
        System.out.print("Masukkan nilai Quiz 4: ");
        int nil4 = sc.nextInt();
        System.out.print("Masukkan nilai Quiz 5: ");
        int nil5 = sc.nextInt();
        System.out.print("Masukkan nilai UTS: ");
        int nilUTS = sc.nextInt();
        System.out.print("Masukkan nilai UAS: ");
        int nilUAS = sc.nextInt();
        
        mhs Mhs = new mhs();
        Mhs.nil1 = nil1;
        Mhs.nil2 = nil2;
        Mhs.nil3 = nil3;
        Mhs.nil4 = nil4;
        Mhs.nil5 = nil5;
        Mhs.nilUTS = nilUTS;
        Mhs.nilUAS = nilUAS;

        Mhs.rQuis = rataQuis(Mhs.nil1, Mhs.nil2, Mhs.nil3, Mhs.nil4, Mhs.nil5);
        Mhs.nilAkhir = angkaAkhir(Mhs.rQuis, Mhs.nilUTS, Mhs.nilUAS);
        Mhs.nilMutu = nilaiMutu(Mhs.nilAkhir);

        System.out.println("Nilai akhir Quiz : " + Mhs.rQuis + " Nilai akhir : " + Mhs.nilAkhir + " Nilai mutu : " + Mhs.nilMutu); 

        sc.close();
    }
}
