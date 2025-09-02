import java.util.Scanner;

public class pemilu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] calon = new int[3];
        int halo = 3;
        int c = 0;

        while (c > -1 || c < -1) {
            System.out.print("Masukan Pilihan Calon = ");
            c = sc.nextInt();

            try {
                calon [c - 1]++;
            }catch (ArrayIndexOutOfBoundsException e) {
                break;
            }  
        }

        for(int i = 0; i < halo; i++){
            System.out.println("Hasil Dari Pemilu " + calon[i]);
        }
    sc.close();
    }
}
