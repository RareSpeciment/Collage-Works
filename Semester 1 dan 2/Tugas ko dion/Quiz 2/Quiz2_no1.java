import java.util.Scanner;

public class Quiz2_no1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] n = new int[10];
        int totalTempat = 10;
        int total;
        
        n[9] = 1;

        Quiz2_no1 walawe = new Quiz2_no1();

        for (int i = 0; i < totalTempat; i++){
            System.out.print("Masukan air gak tau lah 1 buat balok 0 buat air tolong vote " + (i + 1) + " : ");
            n[i] = sc.nextInt();
        }

        total = walahi(n[0] , n[1] , n[2] , n[3] , n[4] , n[5] , n[6] , n[7] , n[8] , n[9] , totalTempat);

        System.out.println("Air yang bisa di tampung adalah : " + total);

        sc.close();
    }

    public static int walahi (int n0 , int n1 , int n2 , int n3 , int n4 , int n5 , int n6 , int n7 , int n8 , int n9 , int balok){
        int haiya = 0;
    
        haiya = balok - (n0 + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9);
    
        return haiya;
    }
}