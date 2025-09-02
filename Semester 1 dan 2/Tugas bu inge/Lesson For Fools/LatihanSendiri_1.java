import java.util.Scanner;

public class LatihanSendiri_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int temp = 3;
        String [] nama = new String[temp];
        int [] usia = new int[temp];
        int [] gelar = new int[temp];
        int [] ijasah = new int[temp];
        int [] penerimaan = new int[temp];
        double [] ipk = new double[temp];

        for(int i = 0; i <= temp-1; i++){
            System.out.println("Karyawan : " + (i + 1));
            System.out.print("Masukan nama : ");
            nama[i] = sc.next();

            System.out.print("Masukan Usia : ");
            usia[i] = sc.nextInt();
            
            System.out.print("Masukan Gelar S? : ");
            gelar[i] = sc.nextInt();
            
            System.out.print("Masukan umur ijasah : ");
            ijasah[i] = sc.nextInt();

            System.out.print("Masukan IPK : ");
            ipk[i] = sc.nextDouble();

            if(usia[i] >= 18 && ipk[i] >= 2.75 && ijasah[i] <= 6){
                if(usia[i] <= 30 && gelar[i] == 1){
                    System.out.println("Kamu diterima 1 " + nama[i]);
                    penerimaan[i] = 1;
                }else{
                    if(usia[i] <= 35 && gelar[i] == 2){
                        System.out.println("Kamu Diterima 2 " + nama[i]);
                        penerimaan[i] = 1;
                    }else{
                        if(usia[i] <= 40 && gelar[i] == 3){
                            System.out.println("kamu diterima 3 " + nama[i]);
                            penerimaan[i] = 1;
                        }else{
                            System.out.println("Kamu tidak diterima " + nama[i]);
                            penerimaan[i] = 0;
                        }
                    }
                }
            }else{
                System.out.println("kamu tidak diterima " + nama[i]);
                penerimaan[i] = 0;
            }
        }

        System.out.println("Daftar Nilai");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("No.  Nama      Usia        Gelar   Umur Ijasah   IPK   Status");
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i <= temp-1; i++) {
            if(penerimaan[i] == 1){
                System.out.println(i+1 + "    " + nama[i] +"    "+ usia[i] +"    "+ gelar[i] +"    "+ ijasah[i] +"    "+ ipk[i] + "    " + " Diterima");
            }else{
                System.out.println(i+1 + "    " + nama[i] +"    "+ usia[i] +"    "+ gelar[i] +"    "+ ijasah[i] +"    "+ ipk[i] + "    " + " Tidak Diterima");
            }
        }
        System.out.println("---------------------------------------------------------------------------");

    }
}
