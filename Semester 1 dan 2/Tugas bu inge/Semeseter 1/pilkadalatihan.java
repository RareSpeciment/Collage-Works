import java.util.Scanner;

public class pilkadalatihan {
    public static void main(String[] args) {

        //numbers
        Scanner sc = new Scanner(System.in);

        int votein = 0;
        int a = 0;
        int b = 0;
        int c = 0;

        System.out.println("Masukan Vote in: ");
        votein = sc.nextInt();a = sc.nextInt();b = sc.nextInt();c = sc.nextInt();

        System.out.println("Hasil masukan");
        System.out.println("Hasilnya adalah: " + "Hasil votein :" + votein +" Hasil a :" + a + " Hasil b :" + b +" Hasil c :" + c);


        System.out.println("Masukan banyak array: ");
        int n = sc.nextInt();

        int d[] = new int[n];
        for(int i = 0; i < n; i++){
            System.out.println("Masukan d["+(i)+"]:");
            d[i] = sc.nextInt();
        }

        System.out.println("Hasil masukan pakai array");
        for(int i = 0; i < n; i++){
            System.out.println("d["+(i)+"]:" + d[i]);
        }
    }
}
