import java.util.Scanner;

public class ShoppingCart{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ID = (int) (Math.random() * 70000);
        int transaksi = (int) (Math.random() * 70000);

        String[][] items = {
            {"Laptop", "8000000"},
            {"Smartphone", "5000000"},
            {"Kamera", "6000000"},
            {"Meja", "1500000"},
            {"Kursi", "700000"},
            {"Headset", "300000"}
        };

        String[][] payments = {
            {"BCA", "20000"},
            {"BNI", "15000"},
            {"BRI", "10000"},
            {"Mandiri", "5000"}
        };

        String[][] cart = new String[10][2]; // Maximum 10 items in cart
        int cartSize = 0;

        boolean shopping = true;
        while (shopping) {
            System.out.println("\nDaftar Barang:");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i][0] + " - Rp" + items[i][1]);
            }

            System.out.print("Pilih nomor barang yang ingin dibeli: ");
            int pilihBarang = sc.nextInt();

            if (pilihBarang > 0 && pilihBarang <= items.length) {
                if (cartSize < cart.length) {
                    cart[cartSize][0] = items[pilihBarang - 1][0];
                    cart[cartSize][1] = items[pilihBarang - 1][1];
                    cartSize++;
                    System.out.println(items[pilihBarang - 1][0] + " telah ditambahkan ke keranjang.");
                } else {
                    System.out.println("Keranjang penuh!");
                }
            } else {
                System.out.println("Pilihan tidak valid.");
            }

            System.out.print("Ingin menambahkan barang lain? (y/n): ");
            String again = sc.next();
            shopping = again.equalsIgnoreCase("y");
        }

        double total = 0;
        System.out.println("\nBarang yang akan dibeli:");
        for (int i = 0; i < cartSize; i++) {
            System.out.println(cart[i][0] + " - Rp" + cart[i][1]);
            total += Double.parseDouble(cart[i][1]);
        }

        System.out.println("\nPilih pembayaran:");
        for (int i = 0; i < payments.length; i++) {
            System.out.println((i + 1) + ". " + payments[i][0] + " - Biaya Admin Rp" + payments[i][1]);
        }

        System.out.print("Pilih metode pembayaran: ");
        int pilihPembayaran = sc.nextInt();

        int bayar = 0;
        String Tpembayaran = "";
        if (pilihPembayaran > 0 && pilihPembayaran <= payments.length) {
            bayar = Integer.parseInt(payments[pilihPembayaran - 1][1]);
            Tpembayaran = payments[pilihPembayaran - 1][0];
        }

        boolean confirm = true;
        while (confirm) {
            System.out.println("\nBarang yang ingin dibeli:");
            total = 0;
            for (int i = 0; i < cartSize; i++) {
                System.out.println(cart[i][0] + " - Rp" + cart[i][1]);
                total += Double.parseDouble(cart[i][1]);
            }
            System.out.println("\nTotal Harga: Rp" + total);
            System.out.println("Total Biaya Admin: Rp" + bayar);
            System.out.println("Total Harga: Rp" + (total + bayar));
            System.out.println("Pembayaran menggunakan " + Tpembayaran);

            System.out.print("Ingin Membeli barang ini? (y/n): ");
            String verif = sc.next();

            if (verif.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Total Harga            : Rp" + (total + bayar));
                System.out.println("Order ID               : " + ID);
                System.out.println("Nomor Transaksi        : " + transaksi);
                System.out.println("Pembayaran menggunakan : " + Tpembayaran);
                System.out.println("Terima kasih telah berbelanja!");
                break;
            }
        }
        sc.close();
    }
}