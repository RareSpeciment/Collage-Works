import java.util.Scanner;

public class Modul5_No6 {
    public static double hasil(double x1, double y1, double x2, double y2){
        double jarak = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1,2));
        return jarak;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = 5, y1 = 10;
        double x2 = 4, y2 = 3;

        double jarak = hasil(x1,y1,x2,y2);

        System.out.println("Jarak antara P1 : " + x1 + " , " + y1 + " dan p2 : " + x2 + " , " + y2 + " Adalah :" + jarak);

        sc.close();
    }
}
