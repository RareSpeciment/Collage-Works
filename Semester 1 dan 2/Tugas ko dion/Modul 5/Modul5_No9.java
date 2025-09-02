import java.util.Scanner;
//need some Assistent with this one.

public class Modul5_No9 {
    public static void input(){
        Scanner sc = new Scanner(System.in);
        String baris1 = "qwertyuiop";
        String baris2 = "asdfghjkl";
        String baris3 = "zxcvbnm";

        char text;

        while (true) {
            System.out.println("Masukan huruf yang ingin di cari : ");
            String input = sc.nextLine().toLowerCase();

            if(input.length() != 1){
                System.out.println("Input harus berupa satu huruf. Coba lagi.");
                continue;
            }

            text = input.charAt(0);

            if (baris1.indexOf(text) != -1) {
                System.out.println("Baris 1, Huruf ke-" + (baris1.indexOf(text) + 1));
                break;
            } else if (baris2.indexOf(text) != -1) {
                System.out.println("Baris 2, Huruf ke-" + (baris2.indexOf(text) + 1));
                break;
            } else if (baris3.indexOf(text) != -1) {
                System.out.println("Baris 3, Huruf ke-" + (baris3.indexOf(text) + 1));
                break;
            } else {
                System.out.println("Huruf yang dimasukkan tidak valid. Coba lagi.");
            }
        }
        sc.close();
    }
    public static void main(String[] args) {

        input();
    }

    public static void cariLokasiHuruf(String baris, char text) {
        int posisi = baris.indexOf(text);
        if (posisi != -1) {
            System.out.println("Text '" + text + "' ditemukan pada posisi ke-" + (posisi + 1));
        } else {
            System.out.println("Text '" + text + "' tidak ditemukan pada baris ini.");
        }
    }
}
