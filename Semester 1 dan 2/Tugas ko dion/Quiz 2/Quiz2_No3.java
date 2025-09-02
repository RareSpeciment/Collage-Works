import java.util.Scanner;

public class Quiz2_No3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String myStr = "Hello, word, this, is, a, test";
        
        String regex = "[,]";
        String[] myArray = myStr.split(regex);
        String s : myArray;

        System.out.println(s + "-");
    }
}