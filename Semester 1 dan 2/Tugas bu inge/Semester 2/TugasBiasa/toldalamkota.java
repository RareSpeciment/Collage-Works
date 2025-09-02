package TugasBiasa;
import java.util.Scanner;

public class toldalamkota {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] gol = new int[4];
        int [] tarif = {10000,15000,20000,25000};
        // int halo = 3;
        int c = 0;
        int totalgol = 0;
        int totaltarif = 0;

        while (c > -1 || c < -1) {
            System.out.print("Masukan Golongan mana : ");
            c = sc.nextInt();

            try {
                gol [c - 1]++;
            }catch (ArrayIndexOutOfBoundsException e) {
                break;
            }  
        }

        for(int i = 0; i < gol.length; i++){
            System.out.println("Gol " + (i+1) +" : "+ gol[i] + " Kendaraan, Pendapatan : " + (gol[i] * tarif[i]));

            totalgol += gol[i];
            totaltarif += gol[i] * tarif[i];
        }

        System.out.println("Total Kendaraan : " + totalgol + " , Total  Pendapatan : " + totaltarif);

    sc.close();
    }
}
