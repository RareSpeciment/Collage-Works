package Modul2;

public class Ddimensi {
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3, 4, 5 },
                        { 6, 7, 8, 9, 0 },
                        { 2, 5, 1, 0, 3 },
                        { 3, 1, 7, 2, 1 },
                        { 4, 1, 6, 2, 3 }
        };

        int[][] totalArr = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int total = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        if (x == 0 && y == 0)continue;
                        int px = i + x; //variable khusus untuk mendeteksi
                        int py = j + y;

                        if (px >= 0 && px < 5 && py >= 0 && py < 5) {
                            total += arr[px][py];
                        }
                    }
                }
                totalArr[i][j] = total;
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();

        System.out.println("Matriks Total:");
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(totalArr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
