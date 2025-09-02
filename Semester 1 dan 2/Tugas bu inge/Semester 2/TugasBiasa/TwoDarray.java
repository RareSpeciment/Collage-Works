package TugasBiasa;
import java.util.Scanner;


public class TwoDarray {
    int totalA;
    int totalB;
    int totalC;
    int perGolongan; int totalPerGolongan;
    int total;

    //function untuk mentotalkan jumblah golongan di setiap asal
    public static int totalAll(int a, int b, int c){
        return a + b + c;
    }

    //function total pergolongan
    public static int totalPerGolongan(int[][] golongan, int kolom) {
        int total = 0;
        for (int i = 0; i < golongan.length; i++) {
            total += golongan[i][kolom];
        }
        return total;
    }

    //function total per asal
    public static int totalPerAsal(int[][] golongan, int baris) {
        int total = 0;
        for (int j = 0; j < golongan[baris].length; j++) {
            total += golongan[baris][j];
        }
        return total;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] [] golongan = new int [3] [3];
        int [] [] pendapatan = new int [3] [3];
        int [] harga = {13500, 21500, 27500};


        //input
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print("Masukan Golongan : ");
                golongan [i] [j] = sc.nextInt();
            }
        }System.out.println();


        //perhitungan harga sekalian ngeprint total golongan dari setiap asal
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(golongan[i][j] + " ");
                pendapatan [i][j] = golongan [i][j] * harga[j];
            }
            System.out.println();
        }System.out.println();


        //print pendapatan
        for (int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(pendapatan[i][j] + " ");
            }
            System.out.println();
        }System.out.println();

        //pusing pala tanpa comment//
        //--------------------------------------------------------------------------------------------//

        
        //awal function
        TwoDarray ttl = new TwoDarray();
        for (int i = 0; i < 3; i++){
            ttl.totalA += golongan [i] [0];
            ttl.totalB += golongan [i] [1];
            ttl.totalC += golongan [i] [2];

            ttl.total = totalAll(ttl.totalA, ttl.totalB, ttl.totalC);
        }


        //memasukan total per golongan kedalam function
        for (int j = 0; j < 3; j++) {
            System.out.println("Golongan " + (j + 1) + ": " + totalPerGolongan(golongan, j));
        }System.out.println();


        //memasukan total dari per asal kedalam function
        for (int i = 0; i < 3; i++) {
            System.out.println("Asal " + (i + 1) + ": " + totalPerAsal(golongan, i));
        }System.out.println();


        //print all
        System.out.println("Total Semua Golongan : "+ ttl.total);
    }
}