import java.util.Scanner;
import java.util.Random;

public class Quiz2_No4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int n = 0;
        System.out.println("masukan total array : ");
        n = sc.nextInt();
        int [] nomors = new int[n];
        
        for(int i = 0; i < n; i++){
            nomors[i] = rand.nextInt(200);
        }

        System.out.println("Unsorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(nomors[i] + " ");
        }

        System.out.println();

        for(int i = 0; i < nomors.length - 1; i++){
            int min = i;
            for (int j = i+1; j < nomors.length; j++){
                if (nomors[j] < nomors[min]) {
                    min = j;
                }
            }

            int temp = nomors[i];
            nomors[i] = nomors[min];
            nomors[min] = temp;
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(nomors[i] + " ");
        }
    }
}
