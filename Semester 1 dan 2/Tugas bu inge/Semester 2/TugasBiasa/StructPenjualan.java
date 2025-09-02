package TugasBiasa;
import java.util.Scanner;

public class StructPenjualan {
    String nik; String nama;
    int [][] jual = new int[5][3];
    int [] hrgBarang = {20000, 25000, 35000};

    public int total(int [][] jual){
        int total = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                total += jual[i][j] * hrgBarang[j];
            }
        }
        return total;
    }

    public int [][] totalPerBarangPerBulan(int [][] jual){
        int[][] totalPerBarang = new int[5][3];

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                totalPerBarang[i][j] = jual[i][j] * hrgBarang[j];
            }
        }
        return totalPerBarang;
    }

    public int [] jualPerbulan(int [][] jual){
        int [] totalperbulan = new int [5];
        for (int i = 0; i < 5; i++){
            totalperbulan[i] = jual[i][0] + jual[i][1] + jual[i][2];
        }
        return totalperbulan;
    }


    //funtion1 untuk terlaris
    public int[] totalPerBarang() {
        int[] totalPerBarang = new int[3];
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 5; i++) {
                totalPerBarang[j] += jual[i][j];
            }
        }
        return totalPerBarang;
    }


    //terlaris untuk hasil
    public int barangTerlaris() {
        int[] total = totalPerBarang();
        int maxIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (total[i] > total[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex + 1; // Barang nomor 1, 2, atau 3
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StructPenjualan struk = new StructPenjualan();

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                System.out.print("Masukan jumblah barang : " + (j + 1) + " pada bulan " + (i + 1) + " : ");
                struk.jual [i][j] = sc.nextInt();
            }
        }

        int totalPenjualan = struk.total(struk.jual);
        int [][] totalbarangbulan = struk.totalPerBarangPerBulan(struk.jual);
        int [] jualperbulan = struk.jualPerbulan(struk.jual);
        int barangTerlaris = struk.barangTerlaris();


        System.out.println("Total penjualan: Rp " + totalPenjualan);
        //print per barang per bulang
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 3; j++){
                System.out.println("jumblah barang pada bulan " + (i + 1) + " : " + struk.jual[i][j] + " Dengan Harga : " + totalbarangbulan[i][j]);
            }
            System.out.println();
        }

        //jualperbulan
        for (int i = 0; i < 5; i++){
            System.out.println("Total Barang pada bulan " + (i+1) + " : " + jualperbulan[i]);
        }

        //terlaris
        System.out.println("Barang yang terlaris adalah Barang no : " + barangTerlaris);
    }
}
