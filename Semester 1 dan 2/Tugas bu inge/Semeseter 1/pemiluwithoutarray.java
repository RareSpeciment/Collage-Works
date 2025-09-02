import java.util.Scanner;

public class pemiluwithoutarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int calon1 = 0, calon2 = 0, calon3 = 0;
        int c = 0;

        while (c >= 0) {
            System.out.print("Masukan Pilihan Calon = ");
            c = sc.nextInt();

            if (c==1) calon1++;
            if (c==2) calon2++;
            if (c==3) calon3++;
        }

        System.out.println("Hasil Dari Pemilu 1 : " + calon1);
        System.out.println("Hasil Dari Pemilu 2 : " + calon2);
        System.out.println("Hasil Dari Pemilu 3 : " + calon3);

    sc.close();
    }
}
