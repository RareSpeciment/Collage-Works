import java.util.Scanner;

public class Modul5_No7 {
    public static void rata(double [] ratata){
        Scanner sc = new Scanner(System.in);

        int totalangka = 0;
        double total = 0;

        System.out.print("Masukan Angka : ");

        while(true){
            int angka = sc.nextInt();

            if(angka == 9999){
                break;
            }else{
                total += angka;
                totalangka++;
            }

            if(totalangka > 0){
                ratata[0] = total / totalangka;
                System.out.println("Yang sudah dimasukan : " + ratata[0]);
            }else{
                System.out.println("Invalid");
            }
        }
        sc.close();

        //this thing will loop and get div until the number is set to 9999
    }


    public static void main(String[] args) {
        double[] ratata = new double[1];

        rata(ratata);
    }
}
