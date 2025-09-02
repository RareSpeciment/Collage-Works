package TugasBiasa;
import java.util.Scanner;

public class Tdarraytwo {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] [] [] golongan = new int [3] [5] [5];

        for (int a = 0; a < 3; a++){
            for(int b = 0; b < 5; b++){
                for(int c = 0; c < 5; c++){
                    System.out.print("Masukan Golongan : ");
                    golongan [a] [b] [c] = sc.nextInt();
                }
            }
        }

        for (int a = 0; a < 3; a++){
            System.out.println("golongan " + (a + 1));
            for(int b = 0; b < 5; b++){
                for(int c = 0; c < 5; c++){
                    System.out.print(golongan[a][b][c] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
