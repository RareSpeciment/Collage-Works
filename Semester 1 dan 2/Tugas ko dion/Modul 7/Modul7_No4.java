class pesanan {
    int nomormenu;
    int banyak;

    pesanan(int nomormenu, int banyak){
        this.nomormenu = nomormenu;
        this.banyak = banyak;
    }
}

class tamuRestoran{
    int nomormeja;
    pesanan [] pesanan;

    tamuRestoran(int nomormeja){
        this.nomormeja = nomormeja;
        this.pesanan = new pesanan[10];
    }
}

class restoran {
    static final int[] hargamenu = {500 , 1000 , 1500 , 2000, 2500};

    public static int hitungPembayaran(tamuRestoran tamu){
        int total = 0;

        for (pesanan pesanan : tamu.pesanan){
            if (pesanan != null && pesanan.nomormenu > 0 && pesanan.nomormenu <= hargamenu.length) {
                total += hargamenu[pesanan.nomormenu - 1] * pesanan.banyak;
            }
        }
        return total;
    }
}

public static int hitungTotalPendapatan(tamuRestoran[] semuaTamu) {
    int total = 0;

    for (tamuRestoran tamu : semuaTamu) {
        if (tamu != null) {
            total += hitungPembayaran(tamu);
        }
    }
    return total;
}


public class Modul7_No4 {
    public static void main(String[] args) {
        tamuRestoran[] semuatamu = new tamuRestoran[3];

        semuatamu[0] = new tamuRestoran(1);
        semuatamu[0].pesanan[0] = new pesanan(1 , 2);
        semuatamu[0].pesanan[1] = new pesanan(3 , 1);

        semuatamu[1] = new tamuRestoran(2);
        semuatamu[1].pesanan[0] = new pesanan(2, 3); // Menu 2, 3 porsi

        semuatamu[2] = new tamuRestoran(3);
        semuatamu[2].pesanan[0] = new pesanan(5, 1); // Menu 5, 1 porsi
        semuatamu[2].pesanan[1] = new pesanan(4, 4); // Menu 4, 4 porsi

        for (int i = 0; i < semuatamu.length; i++) {
            System.out.println("Total pembayaran Tamu " + (i + 1) + ": Rp" + restoran.hitungPembayaran(semuatamu[i]));
        }
        System.out.println("Total pendapatan restoran: Rp" + restoran.hitungTotalPendapatan(semuatamu));
    
    }
}
