import java.util.Scanner;

public class modul6No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Total Nama : ");
        int jumlahNama = sc.nextInt();
        sc.nextLine();
        
        String[] namaArray = new String[jumlahNama];
        
        System.out.println("Masukan nama :");
        for (int i = 0; i < jumlahNama; i++) {
            System.out.print("Nama " + (i + 1) + " : ");
            namaArray[i] = sc.nextLine();
        }
        
        System.out.print("Nama siapa yang ingin di ganti : ");
        String namaLama = sc.nextLine();

        boolean namaDitemukan = false;
        for (String nama : namaArray) {
            if (nama.equals(namaLama)) {
                namaDitemukan = true;
                break;
            }
        }

        if (!namaDitemukan){
            System.out.println("Nama tidak ada!");
        }else{
            System.out.print("Input nama baru : ");
            String namaBaru = sc.nextLine();
            
            for (int i = 0; i < namaArray.length; i++) {
                if (namaArray[i].equals(namaLama)) {
                    namaArray[i] = namaBaru;
                }
            }
            
            System.out.println("Hasil setelah penggantian nama : ");
            for (String nama : namaArray) {
                System.out.print(nama + " ");
            }
        }
        
        sc.close();
    }
}
