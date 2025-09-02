import java.util.Scanner;

public class array {
    static Scanner sc = new Scanner (System.in);
    static int [] Jkerja = new int[7];

    //array
    public static void totalJ(int [] total){
        int tutal = 0;
        for (int i = 0; i < total.length; i++) {
            tutal += total[i];
        }

        System.out.print("total dari Jkerja : "  + tutal);
    }

    public static void input2(){
        int [] total = new int [7];

        for (int i = 0; i < 7; i++) {
            System.out.print("Tolong Masukan Jkerja " + (i+1) + " : ");
            Jkerja[i] = sc.nextInt();
            total[i] = Jkerja[i];
        }

        totalJ(total);
    }


    //non array
    public static void persegi(int a){
        System.out.print("Hasil dari perkalian luas persegi : ");
        int luasP = a * a;

        System.out.println(luasP);
    }

    public static void input(){
        System.out.print("Tolong masukan input : ");
        int a = sc.nextInt();

        persegi(a);
    }

    public static void main(String[] args) {
        //non array
        input();
        input2();
    }
}
