import java.util.Scanner;

public class pilkadanoarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukan Total Vote : ");
        int vote = sc.nextInt();

        int a = 0 ,b = 0 ,c = 0;

        do{
            System.out.print("Masukan Vote : ");
            int pilka = sc.nextInt();

            switch (pilka) {
                case 1:
                    a++;
                break;
                
                case 2:
                    b++;
                break;
                
                case 3:
                    c++;
                break;
            
                default:
                    System.out.println("Wrong input");
                break;
            }

            vote--;

        }while(vote > 0);

        System.out.println("Hasil Pemilu:");
        System.out.println("Pilihan 1: " + a + " suara");
        System.out.println("Pilihan 2: " + b + " suara");
        System.out.println("Pilihan 3: " + c + " suara");

    }
}