public class bublesortoptimasi {
    public static void main(String[] args) {
        int[] num = {9,8,7,6,5,4,3,2,1,0};
        int n = 10;
        int temp = 0;

        //ascending dari belakang
        int i = 0;
        boolean tukar = true;
        while (tukar) {
            tukar = false;
            for(int j = n-1; j > i; j--){
                if (num[j-1] > num[j]){
                    temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                    tukar = true;
                }
            }
            i++;
            if (i == n-1) {
                tukar = false;
            }
        }
        System.out.println();
        for(int p = 0; p < n; p++){
            System.out.print(num[p] + ", ");
        }

        //descending dari belakang
        i = 0;
        tukar = true;
        while (tukar) {
            tukar = false;
            for(int j = n-1; j > i; j--){
                if (num[j-1] < num[j]){
                    temp = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = temp;
                    tukar = true;
                }
            }
            i++;
            if (i == n-1) {
                tukar = false;
            }
        }
        System.out.println();
        for(int p = 0; p < n; p++){
            System.out.print(num[p] + ", ");
        }
    }
}
