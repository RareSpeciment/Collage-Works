import java.util.Scanner;

public class Menarahanoi {
    public static void doTowers(int disk, char from, char inter, char to) {
        if (disk == 0) {
            return;
        }

        doTowers(disk - 1, from, to, inter);
        System.out.println("Move disk " + disk + " from rod " + from + " to rod " + inter);
        doTowers(disk - 1,  to, inter, from);
    }

    public static int getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah cakram : ");
        return sc.nextInt();
    }

    public static void main(String[] args) {
        doTowers(getInput(), 'A', 'B','C');
    }
}