import java.util.Scanner;

public class Modul5_No5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("masukan a : ");
        int a = sc.nextInt();

        System.out.print("masukan b : ");
        int b = sc.nextInt();

        System.out.print("masukan c : ");
        int c = sc.nextInt();

        if(phytagorascek(a,b,c)){
            System.out.println( + a + "," + b + "," + c + " Ini pitagoras");
        }else{
            System.out.println( + a + "," + b + "," + c + " Ini bukan pitagoras");
        }
        sc.close();
    }

    public static boolean phytagorascek(int a, int b, int c){
        int max = Math.max(a, Math.max(b, c));

        if (max == a){
            return (b * b + c * c == a * a);
        }else if(max == b){
            return (a * a + c * c == b * b);
        }else{
            return (b * b + a * a == c * c);
        }
    }
}
