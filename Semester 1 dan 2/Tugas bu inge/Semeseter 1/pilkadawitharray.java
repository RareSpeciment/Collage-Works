import java.util.Scanner;

public class pilkadawitharray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukan vote : ");
        int votes = sc.nextInt();

        int[]vote=new int[3];

        for(int i =1; i < votes; i++){
            System.out.print("Masukan Vote anda : ");
            int pilka = sc.nextInt();

            switch (pilka) {
                case 1:
                    vote[0]++;
                break;
                
                case 2:
                    vote[1]++;
                break;
                
                case 3:
                    vote[2]++;
                break;
            
                default:
                    System.out.println("Wrong input");
                    i--;    
                continue;
            }

            System.out.println("Hasil Pemilu:");
            System.out.println("Pilihan 1: " + vote[0] + " suara");
            System.out.println("Pilihan 2: " + vote[1] + " suara");
            System.out.println("Pilihan 3: " + vote[2] + " suara");
    
        }
    }
}
