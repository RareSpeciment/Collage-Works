package Belajar.Struct;
public class strc6 {
    static class Nilai{
        String namaSiswa;
        int nilaiTugas;
        int nilaiUts;
        int nilaiUas;
    }

    static void show(){
        Nilai [] mhs = new Nilai[4];
        for (int i = 0; i < mhs.length; i++) {
            mhs[i] = new Nilai();
        }

        mhs[0].namaSiswa = "udin";
        mhs[0].nilaiTugas = 100;
        mhs[0].nilaiUts = 80;
        mhs[0].nilaiUas = 90;

        mhs[1].namaSiswa = "udang";
        mhs[1].nilaiTugas = 50;
        mhs[1].nilaiUts = 65;
        mhs[1].nilaiUas = 80;

        mhs[2].namaSiswa = "udang keju";
        mhs[2].nilaiTugas = 87;
        mhs[2].nilaiUts = 69;
        mhs[2].nilaiUas = 79;

        mhs[3].namaSiswa = "Udang tumis";
        mhs[3].nilaiTugas = 80;
        mhs[3].nilaiUts = 80;
        mhs[3].nilaiUas = 70;

        double [] nilaiAkhir = new double [4];
        for (int i = 0; i < mhs.length; i++) {
            nilaiAkhir[i] = (mhs[i].nilaiTugas * 0.2 + mhs[i].nilaiUts * 0.3 + mhs[i].nilaiUas * 0.5);
        }

        for (int i = 0; i < nilaiAkhir.length; i++) {
            System.out.println("Nilai Mhs " + (i + 1) + ": " + nilaiAkhir[i]);
        }
    }

    public static void main(String[] args) {
        show();
    }
}
