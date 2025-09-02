import java.util.Scanner;

public class bublesortbelakangkedepan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] angka = new int[6];

        for(int i = 0; i < 6; i++){
            System.out.println("Masukan data " + (i + 1));
            angka[i] = sc.nextInt();
        }

        for(int i = 0; i < 6 - 1; i++){
            for(int j = 6 - 1; j > i; j--){
                if(angka[j] > angka[j - 1]){
                    int temp = angka [j];
                    angka [j] = angka [j - 1];
                    angka [j - 1] = temp;
                }
            }
            System.out.println(angka[0] +""+ angka[1] +""+ angka[2] +""+ angka[3] +""+ angka[4] +""+ angka[5]);
        }

        System.out.println("Sorted array:");
        for (int i = 0; i < 6; i++) {
            System.out.print(angka[i] + " ");
        }
        sc.close();
    }
}