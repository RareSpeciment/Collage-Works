import java.util.Scanner;

public class quizb_1124028_RaffaelDavidYauson_No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String barang;
        int tbarang = 0;
        int bbarang = 0;
        int harga = 0;
        double total = 0;
        double ttotal = 0;
        double semuaharga = 0;
        double total1 = 0;


        System.out.println("Jumlah barang :");
        tbarang = sc.nextInt();

        for (int i = 1; i <= tbarang; i++){
            System.out.println("pengiriman : (1. reguler) (2. express)");
            int pilihan = sc.nextInt();

            System.out.println("masukan nama barang :");
            barang = sc.next();
            System.out.println("Berat barang dalam KG:");
            bbarang = sc.nextInt();
            
            if(bbarang > 5){
                harga = 20000;
            }else{
                harga = 10000;
            }

            if(tbarang < 5 && bbarang < 20){
                pilihan = 2;
            }else{
                pilihan = 1;
            }


            if(pilihan == 1){
                total = harga;
            }else{
                total = harga * 0.15;
            }

            semuaharga += total;

            System.out.println();
        }

        if(tbarang >= 5){
            ttotal = (semuaharga * 0.1) - semuaharga;
            total1 = semuaharga - ttotal;
        }else{
            System.out.print("Total harganya adalah = " + semuaharga);
        }
    }
}
