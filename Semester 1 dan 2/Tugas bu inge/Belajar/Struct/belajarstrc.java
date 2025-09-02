package Belajar.Struct;
public class belajarstrc {
    static class buku{
        String judul;
        String penulis;
        int tahun;
    }
    
    public static void data(){
        buku b1 = new buku();

        b1.judul = "the Earth";
        b1.penulis = "Hayao miyazaki";
        b1.tahun = 1997;

        System.out.println("Judul  : " + b1.judul + " BY : " + b1.penulis + " Published : " + b1.tahun);
    }

    public static void main(String[] args) {
        data();
    }
}