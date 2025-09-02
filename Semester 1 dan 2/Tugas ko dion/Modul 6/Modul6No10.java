import java.util.Scanner;

public class Modul6No10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = {4,7,8,12,11,5,4,5,7,8,2};

        System.out.print("Masukan batas minim: ");
        int bawah = sc.nextInt();

        System.out.print("Masukan batas max: ");
        int atas = sc.nextInt();

        int hasil = hitungan (array,bawah,atas);

        System.out.println("Hasilnya adalah : " + hasil);

        sc.close();
    }

    public static int hitungan (int [] array, int minim, int max){
        int jumlah = 0;

        for (int i : array){
            if (i >= minim && i <= max)
            jumlah+=i;
        }
        return jumlah;
    }
}
