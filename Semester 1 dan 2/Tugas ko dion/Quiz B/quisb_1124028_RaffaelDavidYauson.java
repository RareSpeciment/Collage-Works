import java.util.Scanner;

public class quisb_1124028_RaffaelDavidYauson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double hasil = 0;
        double bTambahan = 0;
        double bDiskon = 0;
        double keseluruhan = 0;
        int total = 0;


        System.out.println("pilihlah tipe permainan");
        System.out.println("1. Laser tag : Rp100.000");
        System.out.println("2. VR adventure : Rp150.000");
        System.out.println("3. Escape room : Rp200.000");
        System.out.println("Masukan jenis permainan :");
        int jenis1 = sc.nextInt();

        System.out.println("Lvl Tantangan");
        System.out.println("1. Newbie");
        System.out.println("2. Intermidiate : Biaya tamabhan 12%");
        System.out.println("3. Expert : Biaya tambahan 20%");
        System.out.println("Masukan jenis permainan :");
        int jenis2 = sc.nextInt();

        System.out.println("Tipe anggota");
        System.out.println("1. Bronze");
        System.out.println("2. Silver : DIskon 10%");
        System.out.println("3. Gold : Diskon 15%");
        System.out.println("Masukan jenis permainan :");
        int jenis3 = sc.nextInt();

        System.out.println("Masukan total pemain :");
        int tPemain = sc.nextInt();

        switch (jenis1){
            case 1:
                int lt = 100000;
                total = lt * tPemain;

                if(jenis3 == 1){
                    System.out.println("Tidak ada diskon");
                }else if(jenis3 == 2){
                    bDiskon = (total * 0.1) - total;
                    hasil = total - bDiskon ;
                }else if(jenis3 == 3){
                    bDiskon = (total * 0.15) - total;
                    hasil = total - bDiskon;
                }else{
                    System.out.print("Invalid input");
                }
                
                if(jenis2 == 1){
                    System.out.println("Tidak ada Penambahan");
                }else if(jenis2 == 2){
                    bTambahan = hasil * 0.12;
                }else if(jenis2 == 3){
                    bTambahan = hasil * 0.20;
                }else{
                    System.out.print("Invalid input");
                }

                System.out.println("Total Keseluruhan adalah : " + total + " diskon yang didapat : " + hasil + " Penambahan dana : " + bTambahan);
            break;

            case 2:
                int Va = 150000;
                total = Va * tPemain;

                if(jenis3 == 1){
                    System.out.println("Tidak ada diskon");
                }else if(jenis3 == 2){
                    bDiskon = (total * 0.1) - total;
                    hasil = total - bDiskon ;
                }else if(jenis3 == 3){
                    bDiskon = (total * 0.15) - total;
                    hasil = total - bDiskon;
                }else{
                    System.out.print("Invalid input");
                }
                
                if(jenis2 == 1){
                    System.out.println("Tidak ada Penambahan");
                }else if(jenis2 == 2){
                    bTambahan = hasil * 0.12;
                }else if(jenis2 == 3){
                    bTambahan = hasil * 0.20;
                }else{
                    System.out.print("Invalid input");
                }

                System.out.println("Total Keseluruhan adalah : " + total + " diskon yang didapat : " + hasil + " Penambahan dana : " + bTambahan);
            break;

            case 3:
                int Er = 200000;
                total = Er * tPemain;

                if(jenis3 == 1){
                    System.out.println("Tidak ada diskon");
                }else if(jenis3 == 2){
                    bDiskon = (total * 0.1) - total;
                    hasil = total - bDiskon ;
                }else if(jenis3 == 3){
                    bDiskon = (total * 0.15) - total;
                    hasil = total - bDiskon;
                }else{
                    System.out.print("Invalid input");
                }
                
                if(jenis2 == 1){
                    System.out.println("Tidak ada Penambahan");
                }else if(jenis2 == 2){
                    bTambahan = hasil * 0.12;
                }else if(jenis2 == 3){
                    bTambahan = hasil * 0.20;
                }else{
                    System.out.print("Invalid input");
                }

                System.out.println("Total Keseluruhan adalah : " + total + " diskon yang didapat : " + hasil + " Penambahan dana : " + bTambahan);
            break;

            default:
                System.out.print("Salah memasukan input");
            break;  
        }
    }
}
