public class bubbleSort {
    public static void main(String[] args) {
      int[] num = {9,8,7,6,5,4,3,2,1,0};
      int n = 10;
      int temp = 0;

      //ascending dari depan
      for(int i = n-1; i > 0; i--){
        for(int j = 0; j < i; j++){
          if (num[j] > num[j + 1]) {
            temp = num[j];
            num[j] = num[j + 1];
            num[j + 1] = temp;
          }
        }
      }
      System.out.print(num[0]);
      for(int i = 1; i < n; i++){
        System.out.print(", " + num[i]);
      }
      
      System.out.println();
      //descending dari depan
      for(int i = n-1; i > 0; i--){
        for(int j = 0; j < i; j++){
          if (num[j] < num[j + 1]) {
            temp = num[j];
            num[j] = num[j + 1];
            num[j + 1] = temp;
          }
        }
      }
      System.out.print(num[0]);
      for (int i = 1; i < n; i++) {
        System.out.print(", "+num[i]);
      }

      System.out.println();
      // ascending dari belakang
      for(int i = 0; i < n; i++){
        for(int j = n - 1; j > i; j--){
          if (num[j - 1] > num[j]) {
            temp = num[j];
            num[j] = num[j - 1];
            num[j - 1] = temp;
          }
        }
      }
      System.out.print(num[0]);
      for (int i = 1; i < n; i++) {
        System.out.print(", "+num[i]);
      }

      System.out.println();
      // descending dari belakang
      for(int i = 0; i < n; i++){
        for(int j = n - 1; j > i; j--){
          if (num[j - 1] < num[j]) {
            temp = num[j];
            num[j] = num[j - 1];
            num[j - 1] = temp;
          }
        }
      }
      System.out.print(num[0]);
      for (int i = 1; i < n; i++) {
        System.out.print(", "+num[i]);
      }
  }
}