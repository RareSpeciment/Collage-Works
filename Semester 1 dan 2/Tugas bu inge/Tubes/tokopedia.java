package Tubes;
import java.util.Scanner;

public class tokopedia {
    static Scanner sc = new Scanner(System.in);

    // shopping cart and payment function
    static int ID = (int) (Math.random() * 70000);
    static int transaksi = (int) (Math.random() * 70000);
    static Item[] cart = new Item[10];
    static int cartSize = 0;

    static class Item {
        String nama;
        int harga;

        Item(String nama, int harga) {
            this.nama = nama;
            this.harga = harga;
        }
    }

    static class PaymentMethod {
        String nama;
        int biayaAdmin;

        PaymentMethod(String nama, int biayaAdmin) {
            this.nama = nama;
            this.biayaAdmin = biayaAdmin;
        }
    }

    static Item[] items = {
            new Item("Laptop", 8000000),
            new Item("Smartphone", 5000000),
            new Item("Kamera", 6000000),
            new Item("Meja", 1500000),
            new Item("Kursi", 700000),
            new Item("Headset", 300000)
    };

    static PaymentMethod[] payments = {
            new PaymentMethod("BCA", 20000),
            new PaymentMethod("BNI", 15000),
            new PaymentMethod("BRI", 10000),
            new PaymentMethod("Mandiri", 5000),
            new PaymentMethod("PayLater", 5000)
    };

    // acccount class and transaction class
    static class account {
        String username;
        String password;
        transaction[] receipt = new transaction[100]; // God thats a lot of transaction
        int[] money = new int[4];
        int[] voucher = new int[5];
    }

    static class transaction {
        int ID;
        String product;
        int originalPrice;
    }

    // login and register function
    static account[] user = new account[100];
    static int userCount = 0;

    public static void register() {
        account newUser = new account();
        System.out.println("input username");
        newUser.username = sc.nextLine();

        System.out.println("input password");
        newUser.password = sc.nextLine();

        user[userCount++] = newUser;
        System.out.println("Register berhasil!\n");
    }

    public static boolean Login() {
        System.out.println("username : ");
        String checkUser = sc.nextLine();

        System.out.println("password : ");
        String checkPass = sc.nextLine();

        for (int i = 0; i < 100; i++) {
            if (user[i].username.equalsIgnoreCase(checkUser) && user[i].password.equals(checkPass)) {
                System.out.println("Login berhasil!\n");
                System.out.println("Selamat datang " + user[i].username + "!\n");
                listproduk();
                return true;
            }
        }
        System.out.println("Login gagal! Coba lagi.\n");
        return false;
    }

    // pay later function by boolean
    // public static boolean aktivasiPayLater() {
    // }

    public static void topUpVoucher(account akun) {
        System.out.println("== Top Up Voucher ==");
        System.out.println("Pilih jenis voucher:");
        System.out.println("1. Diskon Pembelian 5%!");
        System.out.println("2. Diskon Pembelian 10%!");
        System.out.println("3. Diskon Pembelian 15%!");
        System.out.println("4. Diskon Pembelian 20%!");
        System.out.println("5. Diskon Pembelian 25%!");

        int pilih = sc.nextInt();
        System.out.println("Masukkan jumlah voucher:");
        int jumlah = sc.nextInt();
        sc.nextLine();

        if (pilih >= 1 && pilih <= 5) {
            akun.voucher[pilih - 1] += jumlah;
            System.out.println("Berhasil menambahkan voucher diskon " + (pilih * 5) + "% sebanyak " + jumlah);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
        listproduk();
    }

    public static void listproduk() {
        Scanner sc = new Scanner(System.in);
        int pick = 0;
        System.out.println("== List ==");
        System.out.println("0. Log Out");
        System.out.println("1. Beli Produk");
        System.out.println("2. Top up PayLater");
        System.out.println("3. Top up Voucher");
        pick = sc.nextInt();

        switch (pick) {
            case 0:
                System.out.println("Terima kasih telah menggunakan aplikasi kami!");
                break;

            case 1:
                System.out.println("== Beli Produk ==");
                boolean shopping = true;
                while (shopping) {
                    System.out.println("\nDaftar Barang:");
                    for (int i = 0; i < items.length; i++) {
                        System.out.println((i + 1) + ". " + items[i].nama + " - Rp" + items[i].harga);
                    }

                    System.out.print("Pilih nomor barang yang ingin dibeli: ");
                    int pilihBarang = sc.nextInt();

                    if (pilihBarang > 0 && pilihBarang <= items.length) {
                        if (cartSize < cart.length) {
                            cart[cartSize++] = items[pilihBarang - 1];
                            System.out.println(items[pilihBarang - 1].nama + " telah ditambahkan ke keranjang.");
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

                
                System.out.println("\nBarang yang akan dibeli:");
                double total = 0;
                for (int i = 0; i < cartSize; i++) {
                    System.out.println(cart[i].nama + " - Rp" + cart[i].harga);
                    total += cart[i].harga;
                }

                System.out.println("\nPilih pembayaran:");
                for (int i = 0; i < payments.length; i++) {
                    System.out
                            .println((i + 1) + ". " + payments[i].nama + " - Biaya Admin Rp" + payments[i].biayaAdmin);
                }

                System.out.print("Pilih metode pembayaran: ");
                int pilihPembayaran = sc.nextInt();

                int bayar = 0;
                String Tpembayaran = "";
                if (pilihPembayaran > 0 && pilihPembayaran <= payments.length) {
                    bayar = payments[pilihPembayaran - 1].biayaAdmin;
                    Tpembayaran = payments[pilihPembayaran - 1].nama;
                }

                boolean confirm = true;
                while (confirm) {
                    System.out.println("\nBarang yang ingin dibeli:");
                    total = 0;
                    for (int i = 0; i < cartSize; i++) {
                        System.out.println(cart[i].nama + " - Rp" + cart[i].harga);
                        total += cart[i].harga;
                    }

                    // finish the shopping spree session
                    // ---------------------------------------------------------------------------------------------------------//
                    // pemilihan voucher yang ingin digunakan

                    System.out.println("\nPilih voucher yang ingin digunakan:");
                    boolean adaVoucher = false;
                    for (int i = 0; i < 5; i++) {
                        if (user[userCount - 1].voucher[i] > 0) {
                            System.out.println((i + 1) + ". Diskon " + ((i + 1) * 5) + "% ("
                                    + user[userCount - 1].voucher[i] + " tersedia)");
                            adaVoucher = true;
                        }
                    }

                    double diskon = 0;

                    if (adaVoucher) {
                        System.out.print("Pilih nomor voucher yang ingin digunakan (0 untuk tidak pakai): ");
                        int pilihVoucher = sc.nextInt();
                        sc.nextLine();

                        if (pilihVoucher >= 1 && pilihVoucher <= 5) {
                            if (user[userCount - 1].voucher[pilihVoucher - 1] > 0) {
                                diskon = ((pilihVoucher * 5) / 100.0) * total;
                                user[userCount - 1].voucher[pilihVoucher - 1]--;
                                System.out
                                        .println("Voucher diskon " + (pilihVoucher * 5) + "% digunakan. Hemat Rp" + diskon);
                            } else {
                                System.out.println("Voucher tidak tersedia.");
                            }
                        } else if (pilihVoucher == 0) {
                            System.out.println("Tidak menggunakan voucher.");
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                    } else {
                        System.out.println("Anda tidak memiliki voucher.");
                    }

                    // the end of the voucher selection
                    // ---------------------------------------------------------------------------------------------------------//
                    // the payment finalization

                    System.out.println("\nTotal Harga: Rp" + total);
                    System.out.println("Total Biaya Admin: Rp" + bayar);
                    System.out.println("Diskon dari voucher: Rp" + diskon);
                    System.out.println("Total Harga: Rp" + (total - diskon + bayar));
                    System.out.println("Pembayaran menggunakan " + Tpembayaran);

                    System.out.print("Ingin Membeli barang ini? (y/n): ");
                    String verif = sc.next();

                    if (verif.equalsIgnoreCase("n")) {
                        System.out.println("Pembelian dibatalkan.");
                        listproduk();
                        break;
                    } else {
                        System.out.println("Total Harga            : Rp" + (total - diskon + bayar));
                        System.out.println("Order ID               : " + ID);
                        System.out.println("Nomor Transaksi        : " + transaksi);
                        System.out.println("Pembayaran menggunakan : " + Tpembayaran);
                        System.out.println("Terima kasih telah berbelanja!");
                        listproduk();
                        break;
                    }
                }
                break;

            case 2:
                // function aktivasi pay later

            case 3:
                // function top up voucher
                topUpVoucher(user[userCount - 1]);
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                listproduk();
        }
        sc.close();
    }

    public static void main(String[] args) {
        int leave = 1;
        while (leave != 0) {
            if (userCount == 0) {
                System.out.println("== Register ==");
                register();
            }

            System.out.println("== Login / Register ==");
            String logcheck = sc.nextLine();

            if (logcheck.equalsIgnoreCase("login")) {
                Login();
            } else if (logcheck.equalsIgnoreCase("register")) {
                register();
            } else {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }

            System.out.println("continue? = inupt 1 to continue, 0 to exit");
            leave = sc.nextInt();
            sc.nextLine();
        }

        System.out.println("User made : " + userCount);
        // sekarang kehitung jumlah user yang terdaftar

        // 1. sekarang kita bikin menu untuk user berbelanja setelah login
        // 2 masih blom bisa per user jadi semua user share satu shopping cart 😂
        // 3 tinggal pay later masih bingung gimana ngelakinnya gak ada ide aku
    }
}