package TugasBiasa;
import java.util.Scanner;

public class Threearray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mat[][] = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
        
        int [] [] [] golongan = new int [3] [3] [3];

        for (int a = 0; a < 3; a++){
            for(int b = 0; b < 3; b++){
                for(int c = 0; c < 3; c++){
                    System.out.print("Masukan Golongan : ");
                    golongan [a] [b] [c] = sc.nextInt();
                }
            }
        }

        for (int a = 0; a < 3; a++){
            System.out.println("asal " + (a + 1));
            for(int b = 0; b < 3; b++){
                for(int c = 0; c < 3; c++){
                    System.out.print(golongan[a][b][c] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
