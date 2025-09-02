package TugasBiasa;
import java.util.Scanner;

public class rekrusifpower {
    int n = 0;
    int A = 0;
    int B = 0;
    int C = 0;
    static int basis;
    static int pangkat;
    
    
    public static int RPower(int basis, int pangkat){
        if (pangkat == 0){return (1);}else{
            return(basis * RPower(basis,(pangkat-1)));
        }
    }

    public static int Multiplication(int angka1, int angka2){
        if (angka1 == 0){return (0);}else{
            return(angka1 + Multiplication((angka2 - 1),angka1));
        }
    }

    public static int Fac(int n){
        if (n == 0){return (1);}else{
            return(n * Fac(n-1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rekrusifpower n = new rekrusifpower();

        System.out.println("Masukan NIlai N : ");
        basis = sc.nextInt();
        System.out.println("masukan pangkat : ");
        pangkat = sc.nextInt();

        n.A = RPower (basis, pangkat);
        n.B = Multiplication (basis, pangkat);
        n.C = Fac (basis);

        System.out.println("Nilai : " + n.A);
        System.out.println("Nilai : " + n.B);
        System.out.println("Nilai : " + n.C);
    }
}
