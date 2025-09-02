public class insertionsentinel {
    public static void main(String[] args) {
        int [] arr = {0,7,3,5,9,4,6};
        int temp = 0;

        System.out.print("Unsorted Numbers : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        for (int i = 2; i < arr.length; i++){
            temp = arr[i];
            int j = i - 1;

            while(temp < arr[j]){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = temp;
        }

        System.out.println();
        System.out.print("Sorted Numbers : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
