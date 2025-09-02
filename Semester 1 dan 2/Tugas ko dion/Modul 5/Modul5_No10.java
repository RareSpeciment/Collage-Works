import java.util.Random;
import java.util.Scanner;

public class Modul5_No10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int resoles = 4000, mie = 15000, sosis = 8000, indomie = 6000, eskrim = 5000 ,total = 0;

        Random rand = new Random();
        int randomNumber = rand.nextInt(9999);

        while(true){
            System.out.println("Menu Danus");
            System.out.println("0. Total");
            System.out.println("1. Resoles");
            System.out.println("2. Mie Ayam");
            System.out.println("3. Sosis");
            System.out.println("4. Indomie");
            System.out.println("5. Es Cream");
            System.out.print("Silahakn pilih No : ");
            int pilihan = sc.nextInt();

            if(pilihan == 0){
                System.out.println("----------Total----------");
                System.out.println("TS_" + randomNumber);
                System.out.println("Biaya yang harus dibayar adalah : " + total);
                System.out.println("-------------------------");

                break;
            }

            switch (pilihan) {
                case 1:
                    total += resoles;
                    System.out.println("Biaya sekarang : " + total);
                break;

                case 2:
                    total += mie;
                    System.out.println("Biaya sekarang : " + total);
                break;

                case 3:
                    total += sosis;
                    System.out.println("Biaya sekarang : " + total);
                break;

                case 4:
                    total += indomie;
                    System.out.println("Biaya sekarang : " + total); 
                break;

                case 5:
                    total += eskrim;
                    System.out.println("Biaya sekarang : " + total);
                 break;

                default:
                    System.out.println("Menu invalid");
                continue;
            }
        }
        sc.close();
    }
}