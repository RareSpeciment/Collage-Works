package Belajar;

import java.util.Scanner;

public class whilecalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = 0;

        System.out.println("Masukan angka pertama");
        int no1 = sc.nextInt();
        System.out.println("Masukan Operator");
        char operator = sc.next().charAt(0);
        System.out.println("Masukan angka Kedua");
        int no2 = sc.nextInt();

        if (operator == '+') {
            total = no1 + no2;
        } else if (operator == '-') {
            total = no1 + no2;
        } else if (operator == '/') {
            total = no1 / no2;
        } else if (operator == '*') {
            total = no1 * no2;
        } else {
            System.out.println("Operator invalid");
        }
        System.out.println("Total : " + total);
        System.out.println("Apakah ingin dilanjutkan?");
        char a = sc.next().charAt(0);

        if (a == 'n' || a == 'N') {
            System.out.println("Bye bye");
        } else if (a == 'y' || a == 'Y'){
            while (true) {
                System.out.println("Masukan operator lanjutan");
                operator = sc.next().charAt(0);
                System.out.println("Masukan nomor ke tiga");
                int no3 = sc.nextInt();

                if (operator == '+') {
                    total += no3;
                } else if (operator == '-') {
                    total -= no3;
                } else if (operator == '/') {
                    total /= no3;
                } else if (operator == '*') {
                    total *= no3;
                } else {
                    System.out.println("Operator invalid");
                }
                System.out.println("Total : " + total);
                System.out.println("Apakah ingin dilanjutkan?");
                a = sc.next().charAt(0);

                if (a == 'n' || a == 'N') {
                    break;
                }
            }
        }else{
            System.out.println("tidak valid");
        }
        sc.close();
    }
}