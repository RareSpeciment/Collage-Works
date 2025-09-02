import java.util.Scanner;

public class quizb_1124028_RaffaelDavidYauson_No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steak = 200000;
        int salad = 80000;
        int wine = 150000;
        int water = 20000;
        double diskon = 0;
        double tdiskon = 0;

        double dlayanan = 0;
        double tlayanan = 0;

        System.out.println("Berapa Steak :");
        int tsteak = sc.nextInt();
        System.out.println("Berapa salad :");
        int tsalad = sc.nextInt();
        System.out.println("Berapa wine :");
        int twine = sc.nextInt();
        System.out.println("Berapa water :");
        int twater = sc.nextInt();

        System.out.println("Pilih layanan");
        System.out.println("1. Regular : Tidak ada tamabahan");
        System.out.println("2. Deluxe : Kenaikan 10%");
        System.out.println("3. Supreme : Kenaiakan 18%");
        System.out.println("Masukan jenis Layanan :");
        int jenis1 = sc.nextInt();

        int totalsemua = (tsteak * steak) + (tsalad * salad) + (twine * wine) + (twater * water); 

        if(jenis1 == 1){
            System.out.println("Tidak ada diskon");
            tlayanan = totalsemua;
        }else if(jenis1 == 2){
            dlayanan = (totalsemua * 0.1) - totalsemua;
            tlayanan = totalsemua - dlayanan;
        }else if(jenis1 == 3){
            dlayanan = (totalsemua * 0.18) - totalsemua;
            tlayanan = totalsemua - dlayanan;
        }else{
            System.out.print("Invalid input");
        }

        //gabungan diskon
        int tmakanan = tsteak + tsalad + twine + twater;
        if(tmakanan > 5){
            diskon = (tlayanan * 0.5) - tlayanan;
            tdiskon = tlayanan - diskon;
        }

        System.out.println("Total yang harus dibayar : " + tlayanan + " diskon yang didapatkan :" + tdiskon);

    }
}
