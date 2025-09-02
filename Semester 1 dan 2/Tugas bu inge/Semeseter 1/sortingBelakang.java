import java.util.Scanner;

public class sortingBelakang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] nomors = new int[6];
        
        for(int i = 0; i < 6; i++){
            System.out.println( "Masukan Nomor yang ingin di sorting :");
            nomors[i] = sc.nextInt();
        }

        for(int i = 5; i >= 0; i--){
            int min = i;
            for (int j = i; j >= 0; j--){
                if (nomors[j] < nomors[min]) {
                    min = j;
                }
            }

            int temp = nomors[i];
            nomors[i] = nomors[min];
            nomors[min] = temp;

            System.out.println(nomors[0] + "" + nomors[1] + "" + nomors[2] + "" + nomors[3] + "" + nomors[4] + "" + nomors[5]);
        }
        for(int num : nomors){
            System.out.print(num);
        }
        sc.close();
    }
}
