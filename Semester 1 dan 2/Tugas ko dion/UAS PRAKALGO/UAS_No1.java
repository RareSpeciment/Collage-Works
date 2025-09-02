import java.util.Scanner;

public class UAS_No1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tampungan = 0;
        int Ashard = 0;
        int Aloyteshard = 0;
        int Eteriumshard = 0;
        int Chrono = 0;
        int phrismatic = 0;
        int astralite = 0;

        System.out.print("Masukan Senjata yang ingin di upgrade : (B) | (G) | (S) : ");
        char wp = sc.next().charAt(0);
        System.out.print("Masukan Lvl Senjata saat ini : ");
        int lvlawal = sc.nextInt();
        System.out.print("Masukan tujuan Lvl Senjata : ");
        int lvltujuan = sc.nextInt();

        do {
            switch (wp) {
                case 'B':
                    if (lvlawal <= 30) {
                        Ashard = Ashard + 7;
                    } else if (lvlawal > 30) {
                        Ashard = Ashard + 20;
                        Aloyteshard = Aloyteshard + 7;
                    } else if (lvlawal > 60) {
                        Aloyteshard = Aloyteshard + 14;
                        Eteriumshard = Eteriumshard + 5;
                    } else if (lvlawal > 90) {
                        Chrono = Chrono + 1;
                    }
                    break;

                case 'G':
                    if (lvlawal <= 30) {
                        Ashard = Ashard + 7;
                    } else if (lvlawal > 30) {
                        Ashard = Ashard + 20;
                        Aloyteshard = Aloyteshard + 7;
                    } else if (lvlawal > 60) {
                        Aloyteshard = Aloyteshard + 14;
                        Eteriumshard = Eteriumshard + 5;
                    } else if (lvlawal > 90) {
                        phrismatic = phrismatic + 1;
                    }
                    break;

                case 'S':
                    if (lvlawal <= 30) {
                        Ashard = Ashard + 7;
                    } else if (lvlawal > 30) {
                        Ashard = Ashard + 20;
                        Aloyteshard = Aloyteshard + 7;
                    } else if (lvlawal > 60) {
                        Aloyteshard = Aloyteshard + 14;
                        Eteriumshard = Eteriumshard + 5;
                    } else if (lvlawal > 90) {
                        astralite = astralite + 1;
                    }
                    break;
            }

            if (lvlawal <= 30) {
                tampungan = tampungan + 6000;
            } else if (lvlawal >= 31) {
                tampungan = tampungan + 19000;
            } else if (lvlawal >= 61) {
                tampungan = tampungan + 25000;
            }

            lvlawal++;
        } while (lvlawal != lvltujuan);

        System.out.println("Material yang diperlukan Ashard : " + Ashard + " Aloyteshard : " + Aloyteshard
                + " Eteriumshard : " + Eteriumshard + " Chrono : " + Chrono);
        System.out.println("Total harga Upgrade : " + tampungan);
        
        sc.close();
    }
}
