import java.util.Scanner;

public class No2_Latihan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int pkp = 0;
        double pph;
        double temp;
        double total;
        double hasil;

        System.out.print("Masukan nilai pkp :");
        pkp = sc.nextInt();

        if(pkp < 60){
            pph = pkp * 0.5;
            temp = pkp - pph;
            System.out.println(temp);
        }else if(pkp >= 60){
            pph = 60 * 0.5;
            temp = pkp / 4;
            total = temp * 0.15;
            hasil = pph + total;
            System.out.println(hasil);
        }else if(pkp > 250){
            pph = (60 * 0.5) + (190 * 0.15);
            temp = pkp / 4;
            total = temp * 0.25;
            hasil = pph + total;
            System.out.println(hasil);
        }else if(pkp > 500){
            pph = (60 * 0.5) + (190 * 0.15) + (250 * 0.25);
            temp = pkp / 4;
            total = temp * 0.30;
            hasil = pph + total;
            System.out.println(hasil);
        }else if(pkp > 5000){
            pph = (60 * 0.5) + (190 * 0.15) + (250 * 0.25) + (500 * 0.30);
            temp = pkp / 4;
            total = temp * 0.35;
            hasil = pph + total;
            System.out.println(hasil);
        }else{
            System.out.println("Invalid Numbers");
        }
    }
}