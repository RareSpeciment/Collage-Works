import java.util.Scanner;

public class gajah{
    int umur,pilihan;
    double total;
    double test;

    public static double dapatDiskon(int angka){
        double diskon = 0;
    
        if(angka >= 0 && angka <= 6){
            diskon = 0.05;
        }if(angka >= 7){
            diskon = 0.25;
        }if(angka >= 13){
            diskon = 0.0;
        }if(angka >= 60){
            diskon = 0.5;
        }
    
        return diskon;
    }
    
    public static int pilih (int A){
        int harga = 0;
        if (A == 1){
            harga = 280000;
        }if (A == 2){
            harga = 600000;
        }if (A == 3){
            harga = 215000;
        }if (A == 4){
            harga = 475000;
        }
    
        return harga;
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int umur = 0;
        int harga = 0;
        int pilihan = 0;
        double diskon = 0;

        System.out.println("1. tujuan 1 - Rp280.000");
        System.out.println("2. tujuan 2 - Rp600.000");
        System.out.println("3. tujuan 3 - Rp215.000");
        System.out.println("4. tujuan 4 - Rp475.000");
        System.out.print("Masukan Pilihan anda : ");
        pilihan = sc.nextInt();

        System.out.println("Masukan umur Mu : ");
        umur = sc.nextInt();

        gajah orang = new gajah();

        harga = pilih(pilihan);
        diskon = dapatDiskon(umur);
        orang.total = harga - (harga * dapatDiskon(umur));
        orang.test = dapatDiskon(umur);

        System.out.println("Biaya yang harus dibayar adalah: Rp" + orang.total + " Diskon yang di dapat " + orang.test);

        sc.close();
    }
}