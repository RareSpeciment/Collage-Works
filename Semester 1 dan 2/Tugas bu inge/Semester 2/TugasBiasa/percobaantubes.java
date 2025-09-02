package TugasBiasa;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - Rp" + price;
    }
}

public class percobaantubes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ID = (int)(Math.random() * 70000);
        int transaksi = (int)(Math.random() * 70000);
        LocalDate date = LocalDate.now();

        List<Item> items = new ArrayList<>();
        List<Item> cart = new ArrayList<>();
        List<Item> pembayaran = new ArrayList<>();

        // Menambahkan daftar barang dengan harga
        items.add(new Item("Laptop", 8000000));
        items.add(new Item("Smartphone", 5000000));
        items.add(new Item("Kamera", 6000000));
        items.add(new Item("Meja", 1500000));
        items.add(new Item("Kursi", 700000));
        items.add(new Item("Headset", 300000));

        //list cara bayar
        pembayaran.add(new Item("BCA", 20000));
        pembayaran.add(new Item("BNI", 15000));
        pembayaran.add(new Item("BRI", 10000));
        pembayaran.add(new Item("Mandiri", 5000));

        boolean shopping = true;

        while (shopping) {
            // Menampilkan daftar barang
            System.out.println("\nDaftar Barang:");
            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }


            // Memilih barang
            System.out.print("Pilih nomor barang yang ingin dibeli: ");
            int pilihBarang = sc.nextInt();

            if (pilihBarang > 0 && pilihBarang <= items.size()) {
                cart.add(items.get(pilihBarang - 1));
                System.out.println(items.get(pilihBarang - 1).name + " telah ditambahkan ke keranjang.");
            } else {
                System.out.println("Pilihan tidak valid.");
            }


            // Menanyakan apakah ingin menambahkan barang lagi
            System.out.print("Ingin menambahkan barang lain? (y/n): ");
            String again = sc.next();
            shopping = again.equalsIgnoreCase("y");
        }


        // Verivication
        System.out.println("\nBarang yang akan dibeli:");
        double total = 0;
        for (Item item : cart) {
            System.out.println(item);
            total += item.price;
        }


        //pemilihan metode pembayaran
        System.out.println("\nPilih pembayaran:");
        for (int i = 0; i < pembayaran.size(); i++) {
            System.out.println((i + 1) + ". " + pembayaran.get(i));
        }

        System.out.print("Pilih metode pembayaran: ");
        int pilihPembayaran = sc.nextInt();
        
        int bayar = 0;
        String Tpembayaran = "";
        switch (pilihPembayaran) {
            case 1:
                bayar += 20000;
                Tpembayaran = "BCA";
            break;

            case 2:
                bayar += 15000;
                Tpembayaran = "BNI";
            break;

            case 3:
                bayar += 10000;
                Tpembayaran = "BRI";
            break;

            case 4:
                bayar += 5000;
                Tpembayaran = "Mandiri";
            break;
        
            default:
                
            break;
        }

        //verif jika ingin beli apa tidak
        boolean confirm = true;
        while (confirm) {
            System.out.println("\nBarang yang ingin dibeli:");
            total = 0;
            for (Item item : cart) {
                System.out.println(item);
                total += item.price;
            }
            System.out.println();

            System.out.println("Total Harga: Rp" + (total));
            System.out.println("Total Biaya Admin Rp" + (bayar));
            System.out.println("Total Harga: Rp" + (total + bayar));
            System.out.println("Pembayaran menggunakan " + Tpembayaran);


            //confirm?
            System.out.print("Ingin Membeli barang ini? (y/n): ");
            String verif = sc.next();
            
            if (verif == "n" || verif == "N"){
                break;
            }else{
                System.out.println();
                System.out.println("Total Harga            : \t Rp" + (total + bayar));
                System.out.println("Order ID               : \t " + (ID));
                System.out.println("Nomor Transaksi        : \t " + (transaksi));
                System.out.println("Waktu Transaksi        : \t " + (date));
                System.out.println("Pembayaran menggunakan : \t " + Tpembayaran);
                System.out.println("Terima kasih telah berbelanja!");

                break;
            }
        }

        sc.close();
    }
}