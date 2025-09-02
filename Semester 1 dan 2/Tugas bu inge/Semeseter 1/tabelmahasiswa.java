import java.util.Scanner;

public class tabelmahasiswa {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int jMhs = 5;
        String [] NIM = new String [jMhs];
        String [] nama = new String [jMhs];
        int [] quis = new int [jMhs];
        int [] uts = new int [jMhs];
        int [] uas = new int [jMhs];
        double [] na = new double [jMhs];

        int j1 = 0;
        int j2 = 0;
        int j3 = 0;

        for (int i = 0; i <= jMhs-1; i++) {
            System.out.println("Murid " + (i + 1));
            System.out.print("masukan nim murid : ");
            NIM[i] = sc.next();

            System.out.print("masukan nama murid : ");
            nama[i] = sc.next();

            System.out.print("masukan nilai quiz murid : ");
            quis[i] = sc.nextInt();

            System.out.print("masukan nilai uts murid : ");
            uts[i] = sc.nextInt();

            System.out.print("masukan nilai uas murid : ");
            uas[i] = sc.nextInt();

            System.out.println();
        }

        for (int i = 0; i <= jMhs-1; i++) {
            na[i] = quis[i] * 0.2 + uts[i] * 0.3 + uas[i] * 0.5;
        }

        System.out.println("Daftar Nilai");
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("No.  NIM      Nama        Quis   UTS   UAS   NA");
        System.out.println("------------------------------------------------------------------------------");
        for (int i = 0; i <= jMhs-1; i++) {
            System.out.println(i+1 + "    " + NIM[i] +"    "+ nama[i] +"    "+ quis[i] +"    "+ uts[i] +"    "+ uas[i] +"    "+ na[i]);
        }
        System.out.println("---------------------------------------------------------------------------");

        if(na[0] >= na[1]){
            j1 = 0;
            j2 = 1;
        }else{
            j1 = 0;
            j2 = 1;
        }

        for(int i = 2; i < jMhs; i++){
            if(na[i] > na[j1]){
                j2 = j1;
                j1 = i;
            }else if (na[i] >= na[j2]){
                j3 = j2;
                j2 = i;
            }else if (na[i] > na[j3]){
                j3 = i;
            }
        }

        System.out.println("Juara 1 : " + na[j1] + " atas nama : " + nama[j1] + " NIM : " + NIM[j1]);
        System.out.println("Juara 2 : " + na[j2] + " atas nama : " + nama[j2] + " NIM : " + NIM[j2]);
        System.out.println("Juara 3 : " + na[j3] + " atas nama : " + nama[j3] + " NIM : " + NIM[j3]);
    }
}
