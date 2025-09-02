import java.util.Scanner;
public class Modul5_No8 {

    public static int jarak (int x1, int y1, int x2, int y2){
        int jarakJauh = (x1 - y1) + (x2 - y2);

        return jarakJauh;
    }

    public static void awal(){
        System.out.println("Pilihlah dari negara mana : ");
        System.out.println("1. Indonesia : (x:100, Y:23)");
        System.out.println("2. Jerman : (x:15, Y:1243)");
        System.out.println("3. Rusia : (x:129, Y:3948)");
        System.out.println("4. China : (x:283, Y:382)");
        System.out.println("5. Burkina Faso : (x:374, Y:10)");
        System.out.println("6. Ukraina : (x:203, Y:989)");
        System.out.println("7. Afganistan : (x:2390, Y:1)");
        System.out.println("8. Inggris : (x:394, Y:38)");
        System.out.println("9. Prancis : (x:232, Y:90)");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        awal();

        
        sc.close();
    }
}
