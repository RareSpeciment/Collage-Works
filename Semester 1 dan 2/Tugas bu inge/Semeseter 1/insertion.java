public class insertion {
    public static void main(String[] args) {
        int [] arr = {7, 6, 9, 4, 3, 5};
        int temp = 0;

        System.out.print("Hasil sebelum Sort : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        for(int i = 1; i < arr.length; i++){
            temp = arr[i];
            int j = i - 1;

            while (j > 0 && arr[j] > temp) {
                arr[j+1] = arr[j];
                j--;
            }

            if (arr[j] > temp) {
                arr[j+1] = arr[j];
                arr[j] = temp;
            }else{
                arr[j+1] = temp;
            }
        }

        System.out.println();

        System.out.print("Hasil sesudah Sort : ");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
