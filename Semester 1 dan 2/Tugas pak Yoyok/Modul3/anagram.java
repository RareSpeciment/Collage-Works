import java.util.Scanner;

public class anagram {
    static String str1;

    // Fungsi untuk input string dari pengguna
    public static String input() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan String: ");
        str1 = sc.nextLine();

        sc.close();
        return str1;
    }

    // Fungsi rekursif untuk mencetak semua kemungkinan anagram
    public static void output(String prefix, String str) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                output(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
            }
        }
    }

    // Fungsi utama
    public static void main(String[] args) {

        input();
        System.out.println("Anagram yang dihasilkan:");
        output("", str1);
    }
}
