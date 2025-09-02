package Belajar.Struct;
public class strc4 {
    static class film{
        String judul;
        String sutradara;
        int durasi;
    }

    static void show(){
        film [] flm = new film[3];
        for (int i = 0; i < 3; i++){
            flm[i] = new film();
        }

        flm[0].judul = "Rainy sky";
        flm[1].judul = "To the moon";
        flm[2].judul = "Interstellar";

        flm[0].sutradara = "Hayao Miyazaki";
        flm[1].sutradara = "IDK";
        flm[2].sutradara = "james";

        flm[0].durasi = 120;
        flm[1].durasi = 110;
        flm[2].durasi = 140;

        for (int i = 0; i < 3; i++){
            System.out.print((i + 1) + ". ");
            System.out.println(flm[i].judul + " " + flm[i].sutradara + " " + flm[i].durasi);
        }
        
        System.out.println("Film berdurasi lebih dari 120 menit : ");
        for (int i = 0; i < 3; i++){
            if(flm[i].durasi > 120){
                System.out.print((i + 1) + ". ");
                System.out.println(flm[i].judul + " " + flm[i].sutradara + " " + flm[i].durasi);
            }
        }
    }

    public static void main(String[] args) {
        show();
    }
}
