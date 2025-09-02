import java.util.Scanner;

public class segitiga {
        public static int triangle(int n) {
            int fact = 0;
            int total = 0;

            if (n < 0){
                fact = 0;
            }else{
                fact = triangle(n - 1) + n;

                for (int i = 0; i < n; i++){
                    System.out.print("[ "+ n + " ]");
                    total += fact;
                }
                System.out.print(total);
                System.out.println();
            }
            return fact;
        }

        public static int getInput() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Masukkan angka : ");
            return sc.nextInt();
        }

        public static void main(String[] args) {
            triangle(getInput());
        }
    }
