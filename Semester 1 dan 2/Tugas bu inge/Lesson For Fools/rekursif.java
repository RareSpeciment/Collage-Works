import java.util.Scanner;

public class rekursif {
    static Scanner sc = new Scanner(System.in);

    //Math Rekursif Factorial
    public static int fact(int n){
        if (n == 0){
            return 1;
        }else{
            return n * fact (n - 1);
        }
    }


    //Fibonacci
    public static int Fibonacci(int n){
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }else{
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }


    //perpangkatan
    public static int pangkat(int n, int b){
        if(b == 0){
            return 1;
        }else{
            return n * pangkat(n,(b-1));
        }
    }


    //penjumblahan deret
    public static int deret(int n){
        if (n == 0){
            return 0;
        }else{
            return n + deret(n-1);
        }
    }


    //prima aktif
    public static boolean prima(int n,int div){
        if (n <= 1){
            return false;
        }
        if (div == 1){
            return true;
        }
        if (n % div == 0){
            return false;
        }
        return prima(n,div-1);
    }

    public static void input2(){
        System.out.print("Masukan Input A untuk Math : ");
        int input = sc.nextInt();


        //untuk prima
        System.out.print("Masukan Input B untuk Math divisor : ");
        int divisor = sc.nextInt();

        //untuk perpangkatan
        // System.out.print("Masukan Input B untuk Math perpangkatan : ");
        // int pangkat = sc.nextInt();


        // System.out.println("Factorial of " + input + " : " + fact(input));
        // System.out.print("hasil Fibbonaci dari " + input + " : "+ Fibonacci(input));
        // System.out.print("hasil Pangkat dari " + input + " : "+ pangkat(input,pangkat));
        // System.out.print("hasil Fibbonaci dari " + input + " : "+ deret(input));
        System.out.print("hasil prima dari " + input + " : "+ prima(input,divisor));
    }



    //-------------------------------------------------------------------------------//
    //--------------------------------Tower Of Hanoi---------------------------------//
    //-------------------------------------------------------------------------------//

    //tower of hanoi tutor
    static void toh (int n, char a, char b, char c){
        if (n == 1){
            System.out.println("Take disk 1 from rod " +  a + " to rod " + b);
            return;
        }

        toh(n-1,a,c,b);
        System.out.println("Take disk " + n + " from rod " +  a + " to rod " + b);
        toh(n-1,c,b,a);
    }

    public static void input(){
        System.out.print("Masukan Input N untuk toh : ");
        int N = sc.nextInt();

        toh(N,'A','B','C');
    }

    public static void main(String[] args) {
        // input();
        input2();
    }
}
