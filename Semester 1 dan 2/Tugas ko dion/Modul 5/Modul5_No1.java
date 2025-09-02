import java.util.Scanner;
public class Modul5_No1 {
    
    //persegi dan persegi panjang
    public static int hasil(int A, int B){
        int total = A * B;
        return total;
    }

    //Bulat
    public static double proses(double B){
        double total = 2 * 3.14 * B * B;
        return total;
    }

    //segitiga
    public static int sn(int A, int B){
        int total = 2 * A * B;
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //panjang, Lebar, Tinggi, sisi, ruas.
        //persegi
        System.out.print("Masukan Sisi untuk persegi: ");
        int sisi1 = sc.nextInt();
        System.out.print("Masukan Sisi untuk persegi: ");
        int sisi2 = sc.nextInt();

        int persegi = hasil (sisi1,sisi2);
        System.out.println("Hasil persegi : " + persegi);

        System.out.println();

        //persegi panjang
        System.out.print("Masukan Panjang : ");
        int Ppersegi = sc.nextInt();        
        System.out.print("Masukan Lebar : ");
        int lPersegi = sc.nextInt();

        int persegipanjang = hasil(Ppersegi,lPersegi);
        System.out.println("Hasil persegi panjang : " + persegipanjang);

        System.out.println();

        //Lingkaran
        System.out.print("Masukan Ruas Lingkaran : ");
        int ruas = sc.nextInt();        

        double lingkaran = proses(ruas);
        System.out.println("Hasil lingkaran : " + lingkaran);

        System.out.println();

        //Segitiga
        System.out.print("Masukan alas Segitiga : ");
        int alas = sc.nextInt();        
        System.out.print("Masukan tinggi segitiga : ");
        int tinggi = sc.nextInt();

        int segitiga = sn(alas,tinggi);
        System.out.println("Hasil segitiga : " + segitiga);

        sc.close();
    }
}