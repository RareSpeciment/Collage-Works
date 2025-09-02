
public class normalsortv1 {
    public static void main(String[] args) {
        int arr[] = {5,2,8,7,1};

        System.out.println("Original Array");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + " ");

        int temp = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=4;j>i;j--){
                if(arr[i] < arr[j]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
            System.out.println();
        }

        System.out.println("Sorted Array");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");
    }
}

//temp 5