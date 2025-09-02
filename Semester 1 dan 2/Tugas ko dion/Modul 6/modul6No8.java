import java.util.Scanner;

public class modul6No8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] array = {1,2,2,2,3,3,4,6,6,8,8,9,12,12,12};

        System.out.println("Masukan Nilai Yang ingin di cari : ");
        int angka = sc.nextInt();

        int frek = frekuensi (array,angka);

        System.out.println("Hasil : " + angka + " : " + frek);

        sc.close();
    }

    public static int frekuensi (int[] array, int angka){
        int temp = 0;

        for (int i : array){
            if (i == angka){
                temp++;
            }
        }
        return temp;
    }
}
