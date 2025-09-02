package Belajar;

public class forloop {
    public static void main(String[] args) {
        //square
        for (int i = 0; i < 1; i++){
            for(int j = 0; j < 5; j++){
                System.out.print("* ");
            }
            System.out.println();

            for(int j = 0; j < 3; j++){
                System.out.print("*       *");
                System.out.println();
            }

            for(int j = 0; j < 5; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

        //triangle
        for (int i = 1; i <= 5; i++){
            for(int j = 5; j > i; j--){
                System.out.print(" ");
            }

            for(int j = 0; j < i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
