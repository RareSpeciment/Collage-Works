import java.util.Random;

public class modul6No2 {
    public static void main(String[] args) {
        int [] data = new int[15];
        Random rand = new Random();

        //random number generator
        for (int i = 0; i < data.length; i++) {
            data[i] = rand.nextInt(50) + 1;
        }

        System.out.print("Total :  ");
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }

        int[] count = new int[51];

        for (int num : data) {
            count[num]++;
        }

        int maxCount = 0;
        int angkasama = -1;

        for (int i = 1; i <= 50; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                angkasama = i;
            }
        }
        System.out.println("Hasil : " + angkasama);
    }
}
