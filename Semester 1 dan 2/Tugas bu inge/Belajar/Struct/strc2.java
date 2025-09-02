package Belajar.Struct;
public class strc2 {
    static class Mahasiswa {
        String nama;
        int umur;
        double IPK;
    }

    public static void cek(){
        Mahasiswa [] mhs = new Mahasiswa[3];
        mhs[0] = new Mahasiswa();
        mhs[1] = new Mahasiswa();
        mhs[2] = new Mahasiswa();
        
        mhs[0].nama = "Raffael";
        mhs[0].umur = 19;
        mhs[0].IPK = 3.08;

        mhs[1].nama = "Dang";
        mhs[1].umur = 18;
        mhs[1].IPK = 3.0;

        mhs[2].nama = "pak raul";
        mhs[2].umur = 30;
        mhs[2].IPK = 3.75;

        System.out.println("All Mahasiswa : ");
        for (int i = 0; i < 3; i++){
            System.out.println(mhs[i].nama + " " + mhs[i].umur + " " + mhs[i].IPK);
        }

        System.out.println();
        System.out.println("Mahasiswa yang mempunyai 3.0 ke atas");
        for (int i = 0; i < 3; i++){
            if (mhs[i].IPK > 3.0) {
                System.out.println(mhs[i].nama + " " + mhs[i].umur + " " + mhs[i].IPK);
            }
        }
    }
    public static void main(String[] args) {
        cek();
    }
}
