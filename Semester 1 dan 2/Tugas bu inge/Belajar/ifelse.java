package Belajar;
import java.util.Scanner;
//pembuatan kalkulator
public class ifelse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        System.out.println("Masukin interger satu");
        int satu = sc.nextInt();

        System.out.println("Masukin Operator (+,/,*,-)");
        char operator = sc.next().charAt(0);

        System.out.println("Masukin interger dua");
        int dua = sc.nextInt();

        if(operator == '+'){
            total = satu + dua;
            System.out.println("Total adalah : " + total);
        }else if(operator == '-'){
            total = satu - dua;
            System.out.println("Total adalah : " + total);
        }else if(operator == '/'){
            total = satu / dua;
            System.out.println("Total adalah : " + total);
        }else if(operator == '*'){
            total = satu * dua;
            System.out.println("Total adalah : " + total);
        }else{
            System.out.println("operator tidak valid");
        }

        sc.close();
    }
}
