package TugasBiasa;
import java.util.Scanner;

public class mhsarraylol {
    static int [][][] mhs = new int [5][10][2];

    public static int mhsPerProdi(int a){
        int total = 0;

        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2; j++){
                total += mhs[a][i][j];
            }
        }

        return total;
    }

    public static int mhsPerAngkatan(int b){
        int total = 0;
        if (b < 0 || b >= 10) { //supaya tidak outbounds
            System.out.println("Error: Indeks angkatan di luar batas! (" + b + ")");
            return 0;
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 2; j++){
                total += mhs[i][b][j];
            }
        }

        return total;
    }

    public static int mhsPerAngkatanPerJK(int b, int c){
        int total = 0;

        for (int i = 0; i < 5; i++){
            total += mhs[i][b][c];
        }

        return total;
    }

    public static int mhsPerProdiPerJK(int a, int c){
        int total = 0;

        for (int i = 0; i < 10; i++){
            total += mhs[a][i][c];
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        for (int a = 0; a < 5; a++){
            for(int b = 0; b < 10; b++){
                for(int c = 0; c < 2; c++){
                    System.out.print("Masukan mhs : " + (c == 0 ? "Laki-laki : " : "Perempuan : "));
                    mhs [a][b][c] = sc.nextInt();
                }
            }
        }

        for (int a = 0; a < 5; a++){
            System.out.println("prodi : " + (a + 1));
            for(int b = 0; b < 10; b++){
                System.out.println("Angkatan : " + (b + 1));
                for(int c = 0; c < 2; c++){
                    System.out.print((c == 0 ? "L:" : "P:") + mhs[a][b][c] + "\t");
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

        for (int i = 0; i < 5; i++){
            System.out.println("Total mahasiswa Prodi " + (i + 1) + ": " + mhsPerProdi(i));
            System.out.println("Laki-laki: " + mhsPerProdiPerJK(i, 0) + ", Perempuan: " + mhsPerProdiPerJK(i, 1));
            System.out.println();
        }

        for (int i = 0; i < 10; i++){
            System.out.println("Total mahasiswa per angkatan " + (i + 1) + ": " + mhsPerAngkatan(i));
            System.out.println("Angkatan " + (i + 1) + ": L:" + mhsPerAngkatanPerJK(i, 0) + " P:" + mhsPerAngkatanPerJK(i, 1));
            System.out.println();
        }
    }
}