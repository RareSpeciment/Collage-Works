import java.util.Arrays;
import java.util.Scanner;

public class modul6No1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[10];

        System.out.println("Masukkan 10 angka:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Total angka " + (i + 1) + ": ");
            data[i] = scanner.nextInt();
        }

        
        int terbesar = terbesar(data);
        int terkecil = terkecil(data);
        double rataRata = ratarata(data);
        double median = nilaitengah(data);


        System.out.println("\nHasil Statistik:");
        System.out.println("Rata-rata: " + rataRata);
        System.out.println("Median: " + median);
        System.out.println("Nilai Terbesar: " + terbesar);
        System.out.println("Nilai Terkecil: " + terkecil);
        tampilkanModus(data);

        scanner.close();
    }


    //nilai terbesar
    public static int terbesar(int[] data) {
        int terbesar = data[0];

        for (int num : data) {
            if (num > terbesar) {
                terbesar = num;
            }
        }
        return terbesar;
    }

    //nilai terkecil 
    public static int terkecil(int[] data) {
        int terkecil = data[0];

        for (int num : data) {
            if (num < terkecil) {
                terkecil = num;
            }
        }
        return terkecil;
    }


    //rata
    public static double ratarata(int[] data) {
        int total = 0;

        for (int num : data) {
            total += num;
        }
        return total / (double) data.length;
    }

    //median
    public static double nilaitengah(int[] data) {
        Arrays.sort(data);
        int n = data.length;

        if (n % 2 == 0) {
            return (data[n / 2 - 1] + data[n / 2]) / 2.0;
        } else {
            return data[n / 2];
        }
    }

    //modus
    public static void tampilkanModus(int[] data) {
        int maxCount = 0;
        int modus = 0;

        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j] == data[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                modus = data[i];
            }
        }
        
        if (maxCount > 1) {
            System.out.println("Modus: " + modus);
        } else {
            System.out.println("Tidak ada modus (semua angka unik).");
        }
    }
}
