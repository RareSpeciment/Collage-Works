package Modul10;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class idontknow {
    public static void main(String[] args) {
        Queue<String> set = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        set.add("A001");
        set.add("A002");
        set.add("A003");
        set.add("A004");
        set.add("A005");
        set.add("A006");
        set.add("A007");
        set.add("A008");
        set.add("A009");
        set.add("A010");

        System.out.println("Masukan tiket yang ingin diambil : ");
        String pengambilan = sc.nextLine();

        boolean found = false;
        while (!set.isEmpty()) {
            String list = set.poll();
            if (pengambilan.equals(list)) {
                System.out.println("Pasien yang ingin diambil: " + pengambilan);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Pasien doesn't exist");
        }

        while (!set.isEmpty()) {
            System.out.println(set.poll());
        }

        sc.close();
    }
}
