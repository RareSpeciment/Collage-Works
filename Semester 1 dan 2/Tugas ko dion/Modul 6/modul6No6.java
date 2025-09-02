import java.util.Scanner;

public class modul6No6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("input 1 (string utama) : ");
        String input1 = sc.nextLine();
        System.out.print("input 2 (sub-string) : ");
        String input2 = sc.nextLine();


        if (input1.contains(input2)) {
            System.out.println("Ada cuy");
        } else {
            System.out.println("Tidak ada yang cocok");
        }
        sc.close();
    }
}
