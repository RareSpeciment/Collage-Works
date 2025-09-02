import java.util.Scanner;

public class quizb_1124028_RaffaelDavidYauson_No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A;
        int faktor = 1;
        char input;

        do{    
            faktor = 1;
            System.out.println("Enter a number: ");
            A = sc.nextInt();
            
            for(int i = 1; i <= A; i++)
            {
                faktor *= i;
            }
            System.out.println("!" + A + "= " + faktor);
            System.out.println();
            
            System.out.println("Ulang ??: (Y) OR (N) ");
            input = sc.next().charAt(0);

        }while (input == 'Y' || input == 'y');
    }
}
