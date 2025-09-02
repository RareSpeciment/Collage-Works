import java.util.Scanner;

public class Modul5_no4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan panjang kotak : ");
        double panjang = sc.nextDouble();
        
        System.out.print("Masukkan lebar kotak : ");
        double lebar = sc.nextDouble();
        
        System.out.print("Masukkan tinggi kotak : ");
        double tinggi = sc.nextDouble();
        
        System.out.print("Masukkan jumlah n : ");
        int n = sc.nextInt();
        
        // penyimpanan
        double[] temp = {panjang, lebar, tinggi};

        perbesarKotak(temp, n);

        double volume = hitungVolume(temp[0], temp[1], temp[2]);

        System.out.println("\nSetelah pembesaran : " + n);
        System.out.println("Panjang : " + temp[0]);
        System.out.println("Lebar : " + temp[1]);
        System.out.println("Tinggi : " + temp[2]);
        System.out.println("\nVolume kotak : " + volume);
        
        sc.close();
    }

    //P, L, T yang sedang di besarkan
    public static void perbesarKotak(double[] temp, int n) {
        temp[0] *= n;
        temp[1] *= n;
        temp[2] *= n;
    }

    //penghitungan setelah di besarkan
    public static double hitungVolume(double panjang, double lebar, double tinggi) {
        return panjang * lebar * tinggi;
    }
}
