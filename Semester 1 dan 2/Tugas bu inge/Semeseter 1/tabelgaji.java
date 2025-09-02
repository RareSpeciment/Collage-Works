import java.util.Scanner;

public class tabelgaji{
    String NIP, nama;
    int[] hari = new int[7];
    int UPJ;
    double[] upah = new double[4];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        tabelgaji temp = new tabelgaji("12345", "John Doe", 5000);
        int[] jamKerja = {9, 9, 9, 9, 9, 6, 4};
        temp.inputJamKerja(jamKerja);

        temp.upahBiasa();
        temp.upahLembur();
        temp.upahSabtuMinggu(); //buatlah sebbauh public
        temp.upahTotal();

        temp.tampilkanUpah();
    }

    public tabelgaji(String NIP, String nama, int UPJ){
        this.NIP = NIP;
        this.nama = nama;
        this.UPJ = UPJ;
    }

    public void upahBiasa(){
        int totalJam = 0;
        for (int i = 0; i < 5; i++){
            totalJam += hari[i];
        }

        if (totalJam > 40){
            totalJam = 40;
        }
        upah[0] = totalJam * UPJ;
    }

    public void upahLembur(){
        int totalLembur = 0;
        for (int i = 0; i < 5; i++){
            if (hari[i] > 8){
                totalLembur += (hari[i] -8);
            }
        }
        upah[1] = totalLembur * UPJ * 1.5;
    }
}