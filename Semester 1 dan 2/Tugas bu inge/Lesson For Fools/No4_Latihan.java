import java.util.Scanner;

public class No4_Latihan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int awal = 0;
        int tujuan = 0;
        double bunga = 0;

        System.out.println("masukan dana awal :");
        awal = sc.nextInt();

        System.out.println("masukan dana tujuan :");
        tujuan = sc.nextInt();
        
        do{
            bunga += awal * 0.25;
        }while(bunga <= tujuan);
        System.out.println("Biaya sudah terkumpulkan, wakatunya beli komputer " + bunga);
    }
}
