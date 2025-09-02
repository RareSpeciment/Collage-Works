import java.util.Scanner;

public class mhstablearray {

    String NIM, nama;
    int nil1, nil2, nil3, nil4, nil5, nilUTS, nilUAS;
    double rQuis, nilAkhir;
    char nilMutu;

    public double rataQuis() {
        return (nil1 + nil2 + nil3 + nil4 + nil5) / 5.0;
    }

    public double angkaAkhir() {
        return (rQuis * 0.2) + (nilUTS * 0.3) + (nilUAS * 0.5);
    }

    public char nilaiMutu() {
        if (nilAkhir >= 80) {
            return 'A';
        } else if (nilAkhir >= 70) {
            return 'B';
        } else if (nilAkhir >= 60) {
            return 'C';
        } else if (nilAkhir >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jMhs = scan.nextInt();
        
        mhstablearray[] mhs = new mhstablearray[jMhs];
        
        for (int i = 0; i < jMhs; i++) {
            mhs[i] = new mhstablearray();
            scan.nextLine();
            System.out.print("Masukkan NIM mahasiswa " + (i + 1) + ": ");
            mhs[i].NIM = scan.nextLine();
            System.out.print("Masukkan nama mahasiswa " + (i + 1) + ": ");
            mhs[i].nama = scan.nextLine();
            
            System.out.print("Masukkan nilai Quiz 1: ");
            mhs[i].nil1 = scan.nextInt();
            System.out.print("Masukkan nilai Quiz 2: ");
            mhs[i].nil2 = scan.nextInt();
            System.out.print("Masukkan nilai Quiz 3: ");
            mhs[i].nil3 = scan.nextInt();
            System.out.print("Masukkan nilai Quiz 4: ");
            mhs[i].nil4 = scan.nextInt();
            System.out.print("Masukkan nilai Quiz 5: ");
            mhs[i].nil5 = scan.nextInt();
            
            System.out.print("Masukkan nilai UTS: ");
            mhs[i].nilUTS = scan.nextInt();
            System.out.print("Masukkan nilai UAS: ");
            mhs[i].nilUAS = scan.nextInt();
            
            mhs[i].rQuis = mhs[i].rataQuis();
            mhs[i].nilAkhir = mhs[i].angkaAkhir();
            mhs[i].nilMutu = mhs[i].nilaiMutu();
        }

        System.out.println("\nDaftar Nilai");
        System.out.println("----------------------------------------------------------");
        System.out.println("No.  NIM      Nama           Quis  UTS  UAS   NA   Mutu");
        System.out.println("----------------------------------------------------------");
        
        for (int i = 0; i < jMhs; i++) {
            System.out.println((i + 1) + "  " + mhs[i].NIM + "  " + mhs[i].nama + "  " + String.format("%.2f", mhs[i].rQuis) + "  " + mhs[i].nilUTS + "  " + mhs[i].nilUAS + "  " + String.format("%.2f", mhs[i].nilAkhir) + "  " + mhs[i].nilMutu);
        }

        
        for (int i = 0; i < jMhs - 1; i++) {
            for (int j = i + 1; j < jMhs; j++) {
                if (mhs[i].nilAkhir < mhs[j].nilAkhir) {
                    mhstablearray temp = mhs[i];
                    mhs[i] = mhs[j];
                    mhs[j] = temp;
                }
            }
        }

        System.out.println("\nJuara 1 : NIM " + mhs[0].NIM + " Nama " + mhs[0].nama + " NA " + mhs[0].nilAkhir);
        System.out.println("Juara 2 : NIM " + mhs[1].NIM + " Nama " + mhs[1].nama + " NA " + mhs[1].nilAkhir);

        scan.close();
    }
}
