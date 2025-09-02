public class bubblesortv1 {
    public static void main(String[] args) {
        int arr[] = {1,9,5,8,3};

        System.out.print("Array Awal : ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        for(int i=0; i<arr.length; i++){
            for(int j=1;j<arr.length-i; j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }

        System.out.print("\nArray Sorted : ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
