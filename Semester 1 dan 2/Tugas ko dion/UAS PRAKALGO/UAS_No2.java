import java.util.Scanner;

public class UAS_No2 {
    private static boolean[] member = new boolean[10];
    private static boolean[] seats = new boolean[10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email, password;

        System.out.println("===== Login please =====");
        System.out.println("Masukan email");
        email = sc.nextLine();
        System.out.println("Masukan password");
        password = sc.nextLine();
        System.out.print("Masukkan nama: ");
        String nama = sc.nextLine();
        
        System.out.print("Masukkan jenis tiket (ekonomi/bisnis/first class): ");
        String jenisTiket = sc.nextLine();

        int hargaTiket = 0;
        switch (jenisTiket) {
            case "ekonomi":
                hargaTiket = 1000000;
                break;
            case "bisnis":
                hargaTiket = 2000000;
                break;
            case "first class":
                hargaTiket = 3000000;
                break;
            default:
                System.out.println("Jenis tiket yang Anda masukkan tidak valid.");
                System.exit(0);
        }
        
        System.out.print("Masukkan asal: ");
        String asal = sc.nextLine();
        
        System.out.print("Masukkan tujuan: ");
        String tujuan = sc.nextLine();
        
        System.out.print("Masukkan tanggal penerbangan: ");
        String tanggal = sc.nextLine();

        while (true) {
            System.out.println("1. Reserve a seat");
            System.out.println("2. View all seats");
            System.out.println("3. Exit");
            int choice = sc.nextInt();
            if (choice == 1) {
                reserveSeat();
            } else if (choice == 2) {
                viewSeats();
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        System.out.println("\n=== Data Pemesanan Tiket ===");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Tiket: " + jenisTiket);
        System.out.println("Asal: " + asal);
        System.out.println("Tujuan: " + tujuan);
        System.out.println("Tanggal Penerbangan: " + tanggal);
        System.out.println("Harga Tiket: " + hargaTiket);
        System.out.println("Mengambil Tempat duduk: " + tanggal);

        sc.close();
    }

    private static void reserveSeat() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter seat number: ");
        int seatNum = sc.nextInt();
        if (seats[seatNum - 1] == false) {
            seats[seatNum - 1] = true;
            System.out.println("Seat reserved. Thank you.");
        } else {
            System.out.println("Sorry, this seat is already reserved.");
        }
    }

    private static void viewSeats() {
        for (int i = 0; i < seats.length; i++) {
            System.out.print("Seat " + (i + 1) + ": ");
            if (seats[i] == true) {
                System.out.println("Reserved");
            } else {
                System.out.println("Available");
            }
        }
    }
}
