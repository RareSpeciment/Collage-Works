import java.util.Scanner;
import java.util.Arrays;

public class modul6No7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan jumlah nilai: ");
        int n = sc.nextInt();
        
        int[] array = new int[n];

        System.out.println("Masukkan nnilai array :");

        for (int i = 0; i < n; i++) {
            System.out.print("nilai " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        // Mengurutkan array
        Arrays.sort(array);

        // nilai tertinggi dan terendah
        int maksimum = array[n - 1] - array[0];

        // nilai kedua dan terendah
        int minim = array[1] - array[0];

        // Menampilkan hasil
        System.out.println("Selisih maksimum: " + maksimum);
        System.out.println("Selisih minimum: " + minim);

        sc.close();
    }
}
