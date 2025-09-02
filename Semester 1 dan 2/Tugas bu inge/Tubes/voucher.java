package Tubes;
import java.util.Scanner;

public class voucher {
    static Scanner sc = new Scanner(System.in);
    static class Item {
        String nama;
        int harga;

        Item(String nama, int harga) {
            this.nama = nama;
            this.harga = harga;
        }
    }

    static class Voucher {
        String name;
        int discount;
        int amount;

        Voucher(String name, int discount, int amount) {
            this.name = name;
            this.discount = discount;
            this.amount = amount;
        }
    }

    static Item[] items = {
        new Item("Produk A", 100000),
        new Item("Produk B", 200000),
        new Item("Produk C", 300000)
    };

    static Voucher[] vouchers = {
        new Voucher("Diskon 5%", 5, 0),
        new Voucher("Diskon 10%", 10, 0),
        new Voucher("Diskon 15%", 15, 0),
        new Voucher("Diskon 20%", 20, 0),
        new Voucher("Diskon 25%", 25, 0)
    };


    //Top Up Voucher
    public static void topUpVoucher() {
        System.out.println("== Top Up Voucher ==");
        System.out.println("Pilih jenis voucher yang ingin di beli:");

        for(int i = 0; i < vouchers.length; i++) {
            System.out.println((i + 1) + ". " + vouchers[i].name);
        }

        int pilih = sc.nextInt();
        System.out.println("Masukkan jumlah voucher:");
        int jumlah = sc.nextInt();
        sc.nextLine();

        if (pilih >= 1 && pilih <= vouchers.length) {
            vouchers[pilih - 1].amount += jumlah;
            System.out.println("Berhasil menambahkan " + vouchers[pilih - 1].name + " sebanyak " + jumlah);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }


    //Pembelian Product && proses pembelian product ada disini, dan juga penggunaan voucher ada disini
    public static void buyProduct() {
        System.out.println("== Beli Produk ==");
        for (int i = 0; i < items.length; i++) {
            System.out.println((i + 1) + ". " + items[i].nama + " - Rp" + items[i].harga);
        }

        System.out.print("Pilih produk: ");
        int pilihProduk = sc.nextInt();

        if (pilihProduk >= 1 && pilihProduk <= items.length) {
            Item selectedItem = items[pilihProduk - 1];
            System.out.println("Produk yang dipilih: " + selectedItem.nama + " - Rp" + selectedItem.harga);

            System.out.println("\nPilih voucher yang ingin digunakan:");
            boolean adaVoucher = false;
            //tidak ada voucher dari awal


            //pengecekan voucher
            for (int i = 0; i < vouchers.length; i++) {
                if (vouchers[i].amount > 0) {
                    System.out.println((i + 1) + ". " + vouchers[i].name + " (" + vouchers[i].amount + " tersedia)");
                    adaVoucher = true;
                    //voucher true maka voucher ada
                }
            }

            //jika ada voucher maka akan menampilkan text bahwa voucher telah dibeli dan bisa digunakan untuk pembayaran
            double diskon = 0;
            if (adaVoucher) {
                System.out.print("Pilih nomor voucher yang ingin digunakan (0 untuk tidak pakai): ");
                int pilihVoucher = sc.nextInt();

                if (pilihVoucher >= 1 && pilihVoucher <= vouchers.length) {
                    if (vouchers[pilihVoucher - 1].amount > 0) {
                        diskon = (vouchers[pilihVoucher - 1].discount / 100.0) * selectedItem.harga;
                        vouchers[pilihVoucher - 1].amount--;
                        System.out.println("Voucher " + vouchers[pilihVoucher - 1].name + " digunakan. Hemat Rp" + diskon);
                    } else {
                        System.out.println("Voucher tidak tersedia.");
                    }
                } else if (pilihVoucher == 0) {
                    System.out.println("Tidak menggunakan voucher.");
                } else {
                    System.out.println("Pilihan tidak valid.");
                }
            }
            //jika tidak ada voucher maka akan muncul text ini
            else {
                System.out.println("Anda tidak memiliki voucher.");
            }


            //harga total
            double total = selectedItem.harga - diskon;
            System.out.println("Total yang harus dibayar: Rp" + total);
        } else {
            System.out.println("Pilihan produk tidak valid.");
        }
    }

    public static void listproduk() {
        while (true) {
            System.out.println("\n== Menu ==");
            System.out.println("1. Beli Produk");
            System.out.println("2. Top Up Voucher");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            int menu = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println();
                    buyProduct();
                    break;
                case 2:
                    System.out.println();
                    topUpVoucher();
                    break;
                case 0:
                    System.out.println("Ini adalah simulasi voucher");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Selamat datang di simulasi voucher");
        listproduk();
    }
}