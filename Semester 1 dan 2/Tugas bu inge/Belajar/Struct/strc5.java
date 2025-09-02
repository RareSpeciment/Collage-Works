package Belajar.Struct;
public class strc5 {
    static class karyawan{
        String nama;
        double gaji;
        String status;
    }

    static void show(){
        karyawan [] karya = new karyawan[5];
        for (int i = 0; i < 5; i++){
            karya[i] = new karyawan();
        }

        karya[0].nama = "Udin";
        karya[0].gaji = 2500000;
        karya[0].status = "tetap";

        karya[1].nama = "idon";
        karya[1].gaji = 3500000;
        karya[1].status = "kontrak";

        karya[2].nama = "dion";
        karya[2].gaji = 5500000;
        karya[2].status = "tetap";

        karya[3].nama = "sudin";
        karya[3].gaji = 1500000;
        karya[3].status = "kontrak";

        karya[4].nama = "madin";
        karya[4].gaji = 2500000;
        karya[4].status = "Tetap";

        for(int i = 0; i < 5; i++){
            if(karya[i].gaji > 5000000 && karya[i].status.equalsIgnoreCase("tetap")){
                System.out.print((i + 1) + ". ");
                System.out.println(karya[i].nama + " " + karya[i].gaji + " " + karya[i].status);
            }
        }
    }
    public static void main(String[] args) {
        show();
    }
}
