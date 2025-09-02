import java.util.Scanner;

public class penrcobaanarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][][] hallo = new int [1][3][10];
        int [][] halo = new int [1][5];
        int [] ha = {321,563,123};
        int p = 0;
        
        for (int i = 0; i < 3; i++){
            System.out.println(ha[i]);
        }

        while (p < 3) {
            System.out.println(ha[p]);
            System.out.println(p);
            p++;
        }

        //array kedua
        for(int i = 0; i < 1; i++){
            for(int j = 0 ; j < 5; j++){
                System.out.println("masukan file di folder 1s");
                halo[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 1; i++){
            for(int j = 0 ; j < 5; j++){
                System.out.println(halo[i][j]);
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < i + 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
