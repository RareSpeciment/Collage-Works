package Tubes;
import java.util.Scanner;
class Account {

    String username;
    String password;
    String nomorHP;
    String noRek;
    String KTP;

    Transaction receipt;
    Giftcard gReceipt;
    Voucher vReceipt;
    Listrik PLN;
    Pinjaman pinjaman;

    int[] money = new int[4]; // [0] = cash, [1] = saldo bank, [2] = gopay, [3] = gopaylater maybe?
    int[] voucher = new int[5]; // assuming different voucher types?

    Mutasi[] mHist = new Mutasi[10]; // fixed size, newest replaces oldest
    
}

class Transaction {

    int ID;
    String[] product = new String[100]; 
    int originalPrice;
    int finalPrice;

    Transaction next;
    Transaction prev;
}

class Giftcard {

    String forUser; // renamed from 'for' cuz it's a Java keyword
    String from;
    String comment;
    String through;
    int total;

    Giftcard next;
    Giftcard prev;
}


class Listrik {

    String noMeterRumah;
    int token;
}

class Mutasi {

    String namaBank;
    String totalPengisian;
}

class Pinjaman {

    int totalTagihan;
    int totalPembayaran;
}

class Voucher {
    
    int ID;
    int tipeVoucher;
    int totalBought;
    int totalPembayaran;
    
    Voucher next;
    Voucher prev;
}

public class TUBESSTRUKDAT {

    static Scanner in = new Scanner(System.in);
    static Account[] accounts = new Account[100];
    static int accCount = 0;
    static int currentUserIndex = -1;
    public static void dummyAccount(){
        accounts[0] = new Account();
        accounts[0].username = "james";
        accounts[0].password = "0";
        accounts[0].nomorHP = "1";
        accounts[0].noRek = "2";
        accounts[0].KTP = "3";
        accounts[0].money[0] = 10000000;
        accounts[0].money[1] = 10000000;
        accounts[0].money[2] = 5000000;
        accounts[0].voucher[4] = 1;
        accCount++;
        currentUserIndex = 0;
        
        accounts[1] = new Account();
        accounts[1].username = "raffael";
        accounts[1].password = "0";
        accounts[1].nomorHP = "1";
        accounts[1].noRek = "2";
        accounts[1].KTP = "3";
        accounts[1].money[0] = 10000000;
        accounts[1].money[1] = 10000000;
        accounts[1].money[2] = 5000000;
        accounts[1].voucher[4] = 1;
        accCount++;
    }
    public static void main(String[] args) {
        

        int choice;
        dummyAccount();
        do {
            System.out.println("\n==== MENU UTAMA ====");
            if (currentUserIndex == -1) {
                System.out.println("1. Login / Register");
                System.out.println("0. Keluar");
            } else {
                System.out.println("Logged in as: " + accounts[currentUserIndex].username);
                System.out.println("1. Shopping");
                System.out.println("2. Voucher");
                System.out.println("3. GiftCard");
                System.out.println("4. Keuangan");
                System.out.println("5. Receipts");
                System.out.println("6. Logout");
            }
            
            System.out.print("Pilih menu: ");
            choice = in.nextInt();
            in.nextLine(); // buffer clear

            if (currentUserIndex == -1) {
                switch (choice) {
                    case 1:
                        loginOrRegister();
                        break;
                    case 0:
                        System.out.println("Bye bye~");
                        break;
                    default:
                        System.out.println("Pilihan gak valid!");
                }
            } else {
                switch (choice) {
                    case 1:
                        shopping();
                        break;
                    case 2:
                        kelolaVoucher();
                        break;
                    case 3:
                        kirimGiftcard();
                        break;
                    case 4:
                        menuKeuangan();
                        break;
                    case 5:
                        tampilkanReceipt();
                        break;
                    case 6:
                        logout();
                        break;
                    default:
                        System.out.println("Pilihan gak valid!");
                }
            }

        } while (choice != 0);
    }

    static void login() {
        System.out.println("\n--- LOGIN ---");
        System.out.print("Username: ");
        String uname = in.nextLine();

        System.out.print("Password: ");
        String pass = in.nextLine();

        for (int i = 0; i < accCount; i++) {
            if (accounts[i].username.equals(uname)) {
                if (accounts[i].password.equals(pass)) {
                    currentUserIndex = i;
                    System.out.println("Logged in! Selamat datang, " + uname + "!");
                    return;
                } else {
                    System.out.println("Password salah!");
                    return;
                }
            }
        }

        System.out.println("Username not found");
    }

    static void register() {
        System.out.println("\n--- REGISTER ---");
        System.out.print("Masukkan username baru: ");
        String uname = in.nextLine();

        // Check if username exists
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].username.equals(uname)) {
                System.out.println("Username used");
                return;
            }
        }

        Account newAcc = new Account();
        newAcc.username = uname;

        System.out.print("Masukkan password: ");
        newAcc.password = in.nextLine();
        System.out.print("No Rekening: ");
        newAcc.noRek = in.nextLine();

        accounts[accCount++] = newAcc;
        System.out.println("Akun berhasil dibuat!");
    }

    static void loginOrRegister() {
        System.out.println("\n--- LOGIN / REGISTER ---");
        System.out.print("Register (1) Login (2) : ");
        int pilih = in.nextInt();
        in.nextLine();

        if (pilih == 1) {
            register();
        } else if (pilih == 2) {
            login();
        } else {
            System.out.println("invalid");
        }
    }

    static void logout() {
        System.out.println("Logged out. Sampai jumpa, " + accounts[currentUserIndex].username + "!");
        currentUserIndex = -1;
    }

    static void shopping() {
        System.out.println("\n--- Shopping ---");
        Account user = accounts[currentUserIndex];

        String[] items = { "Mouse", "Keyboard", "Laptop", "Headphones", "Charger" };
        int[] prices = { 80000, 150000, 15000000, 300000, 50000 };

        String[] cart = new String[100];
        int itemCount = 0;
        int totalHarga = 0;
        int finalTotal = 0;
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n--- Daftar Produk ---");
            for (int i = 0; i < items.length; i++) {
                System.out.println((i + 1) + ". " + items[i] + " - Rp " + prices[i]);
            }

            System.out.print("Pilih produk (1-5): ");
            int pilih = in.nextInt();
            in.nextLine();

            if (pilih < 1 || pilih > 5) {
                System.out.println("Pilihan tidak valid.");
                continue;
            }

            System.out.print("Jumlah produk ini: ");
            int jumlah = in.nextInt();
            in.nextLine();

            for (int i = 0; i < jumlah; i++) {
                if (itemCount < 100) {
                    cart[itemCount++] = items[pilih - 1];
                    totalHarga += prices[pilih - 1];
                }
            }

            System.out.print("Tambah produk lain? (y/n): ");
            String jawab = in.nextLine();
            if (!jawab.equalsIgnoreCase("y")) {
                lanjut = false;
            }

            finalTotal = totalHarga;
            System.out.println("Total Belanja: Rp " + totalHarga);
        }

        if (itemCount == 0) {
            System.out.println("Tidak ada produk yang dipilih.");
            return;
        }

        boolean punyaVoucher = false;
        String[] diskon = { "5%", "10%", "15%", "20%", "25%" };
        for (int i = 0; i < user.voucher.length; i++) {
            if (user.voucher[i] > 0) {
                System.out.println(diskon[i] + " tersedia (" + user.voucher[i] + " buah)");
                punyaVoucher = true;
            }
        }

        if (punyaVoucher) {
            System.out.print("Pakai voucher? (y/n): ");
            String pakaiVoucher = in.nextLine();
            if (pakaiVoucher.equalsIgnoreCase("y")) {
                System.out.println("Pilih jenis voucher:");
                for (int i = 0; i < user.voucher.length; i++) {
                    if (user.voucher[i] > 0) {
                        System.out.println((i + 1) + ". Voucher Diskon " + diskon[i] + " (" + user.voucher[i] + " buah)");
                    }
                }
                System.out.print("Pilih voucher (1-5): ");
                int idx = in.nextInt();
                in.nextLine();

                if (idx >= 1 && idx <= 5 && user.voucher[idx - 1] > 0) {
                    int diskonPersen = idx * 5;
                    finalTotal = totalHarga - (totalHarga * diskonPersen / 100);
                    user.voucher[idx - 1]--;
                    System.out.println("Voucher diskon " + diskonPersen + "% digunakan! Total setelah diskon: Rp " + finalTotal);
                } else {
                    System.out.println("Voucher tidak valid atau tidak tersedia.");
                }
            }
        }

        System.out.println("\nMetode Pembayaran:");
        System.out.println("1. Mandiri");
        System.out.println("2. BCA");
        System.out.println("3. BRI");
        System.out.println("4. GoPayLater");

        System.out.print("Pilih metode: ");
        int metode = in.nextInt();
        in.nextLine();

        if (metode < 1 || metode > 4) {
            System.out.println("Metode pembayaran tidak valid.");
            return;
        }

        if (metode == 4 && user.money[3] == 0) {
            System.out.println("GoPayLater belum diaktifkan!");
            return;
        } else if (metode == 4) {
            if (finalTotal > user.money[3]) {
                System.out.println("Limit GoPayLater tidak cukup!");
                return;
            }
            user.money[3] -= finalTotal;
            user.pinjaman.totalTagihan += finalTotal;
            System.out.println("Pembayaran berhasil menggunakan GoPayLater!");
        } else {
            if (user.money[metode - 1] < finalTotal) {
                System.out.println("Saldo tidak cukup!");
                return;
            }

            user.money[metode - 1] -= finalTotal;
            System.out.println("Pembayaran berhasil!");
        }

        if (user.money[metode - 1] < finalTotal) {
            System.out.println("Saldo tidak cukup!");
            return;
        }

        // Buat transaksi
        Transaction newT = new Transaction();
        newT.ID = (int) (Math.random() * 100000);
        newT.originalPrice = totalHarga;
        newT.finalPrice = finalTotal;
        for (int i = 0; i < itemCount; i++) {
            newT.product[i] = cart[i];
        }

        newT.next = user.receipt;
        if (user.receipt != null) {
            user.receipt.prev = newT;
        }
        user.receipt = newT;

        System.out.println("Transaksi disimpan! ID: " + newT.ID);
    }

    static void kelolaVoucher() {
        System.out.println("\n--- Voucher Management ---");
        Account user = accounts[currentUserIndex];

        System.out.println("1. Lihat Voucher");
        System.out.println("2. Tambah Voucher");
        System.out.print("Pilih menu: ");
        int pilih = in.nextInt();
        in.nextLine();

        switch (pilih) {
            case 1:
                System.out.println("\n--- Daftar Voucher Anda ---");
                boolean adaVoucher = false;
                String[] diskon = { "5%", "10%", "15%", "20%", "25%" };
                for (int i = 0; i < user.voucher.length; i++) {
                    if (user.voucher[i] > 0) {
                        System.out.println(diskon[i] + ": " + user.voucher[i] + " buah");
                        adaVoucher = true;
                    }
                }
                if (!adaVoucher) {
                    System.out.println("Anda tidak memiliki voucher.");
                }
                break;

            case 2:
                System.out.println("\n--- Tambah Voucher ---");
                System.out.println("Pilih jenis voucher:");
                System.out.println("1. Voucher Diskon 5%  - Rp 5.000");
                System.out.println("2. Voucher Diskon 10% - Rp 10.000");
                System.out.println("3. Voucher Diskon 15% - Rp 15.000");
                System.out.println("4. Voucher Diskon 20% - Rp 20.000");
                System.out.println("5. Voucher Diskon 25% - Rp 25.000");
                System.out.print("Pilih jenis voucher (1-5): ");
                int jenisVoucher = in.nextInt();
                in.nextLine();

                if (jenisVoucher < 1 || jenisVoucher > 5) {
                    System.out.println("Pilihan voucher tidak valid!");
                    return;
                }

                System.out.print("Masukkan jumlah voucher: ");
                int jumlah = in.nextInt();
                in.nextLine();

                if (jumlah <= 0) {
                    System.out.println("Jumlah voucher harus lebih dari 0!");
                    return;
                }

                // Hitung total harga voucher
                int hargaVoucher = jenisVoucher * 5000;
                int totalHarga = hargaVoucher * jumlah;

                System.out.println("Total pembayaran: Rp " + totalHarga);
                System.out.println("\nPilih metode pembayaran:");
                System.out.println("1. Mandiri");
                System.out.println("2. BCA");
                System.out.println("3. BRI");
                System.out.print("Pilih bank (1-3): ");
                int bank = in.nextInt();
                in.nextLine();

                if (bank < 1 || bank > 3) {
                    System.out.println("Pilihan bank tidak valid!");
                    return;
                }

                if (user.money[bank - 1] < totalHarga) {
                    System.out.println("Saldo tidak cukup!");
                    return;
                }

                // Kurangi saldo dan tambah voucher
                user.money[bank - 1] -= totalHarga;
                user.voucher[jenisVoucher - 1] += jumlah;
                
                //simpan ke voucher
                Voucher newV = new Voucher();
                newV.ID = (int) (Math.random() * 100000);;
                newV.tipeVoucher = jenisVoucher;
                newV.totalBought = jumlah;
                newV.totalPembayaran = totalHarga;
                newV.next = user.vReceipt;
                if (user.vReceipt != null) {
                    user.vReceipt.prev = newV;
                }
                user.vReceipt = newV;

                System.out.println("Berhasil membeli " + jumlah + " voucher diskon " + (jenisVoucher * 5) + "%!");
                System.out.println("Saldo tersisa: Rp " + user.money[bank - 1]);
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    static void kirimGiftcard() {
        System.out.println("\n--- Kirim Gift Card ---");

        Account sender = accounts[currentUserIndex];

        System.out.print("Masukkan username penerima: ");
        String receiverUsername = in.nextLine();
        int receiverIndex = -1;

        // Cari penerima
        for (int i = 0; i < accCount; i++) {
            if (accounts[i].username.equalsIgnoreCase(receiverUsername)) {
                receiverIndex = i;
                break;
            }
        }

        if (receiverIndex == -1) {
            System.out.println("Username penerima tidak ditemukan!");
            return;
        }

        Account receiver = accounts[receiverIndex];

        System.out.print("Komentar: ");
        String comment = in.nextLine();

        System.out.println("Metode Pengiriman:");
        System.out.println("1. Mandiri");
        System.out.println("2. BCA");
        System.out.println("3. BRI");
        System.out.print("Pilih metode (1-3): ");
        int metode = in.nextInt();
        in.nextLine();

        if (metode < 1 || metode > 3) {
            System.out.println("Metode tidak valid.");
            return;
        }

        String[] metodeNames = { "Mandiri", "BCA", "BRI" };

        System.out.print("Jumlah yang ingin dikirim: ");
        int total = in.nextInt();
        in.nextLine();

        // Cek saldo pengirim
        if (sender.money[metode - 1] < total) {
            System.out.println("Saldo tidak cukup.");
            return;
        }

        // Transfer duit
        sender.money[metode - 1] -= total;
        receiver.money[metode - 1] += total;

        // Simpan ke giftcard list
        Giftcard newGC = new Giftcard();
        newGC.forUser = receiverUsername;
        newGC.from = sender.username;
        newGC.comment = comment;
        newGC.through = metodeNames[metode-1];
        newGC.total = total;
        
        newGC.next = sender.gReceipt;
        if (sender.gReceipt != null) {
            sender.gReceipt.prev = newGC;
        }
        receiver.gReceipt = newGC;
        sender.gReceipt = newGC;
        
        System.out.println("Giftcard berhasil dikirim ke " + receiver.username + " melalui " + metodeNames[metode - 1] + "!");
    }

    static void menuKeuangan() {
        System.out.println("\n--- Menu Keuangan ---");
        System.out.println("1. Listrik PLN");
        System.out.println("2. Setor ke Bank");
        System.out.println("3. GoPayLater");
        System.out.println("4. Tampil Saldo ");
        System.out.print("Pilih opsi: ");
        int pilih = in.nextInt();
        in.nextLine();

        switch (pilih) {
            case 1:
                bayarPLN();
                break;
            case 2:
                setorBank();
                break;
            case 3:
                goPayLater();
                break;
            case 4:
                tampilSaldo();
                break;
            default:
                System.out.println("error.");
        }
    }

    static void tampilkanReceipt() {
        System.out.println("\n--- Receipts ---");
        System.out.println("1. Shopping");
        System.out.println("2. Voucher");
        System.out.println("3. Giftcard");
        System.out.println("Pilih Opsi : ");
            int pilih = in.nextInt();
            in.nextLine();
            
            switch(pilih){
                case 1 :
                    shoppingT();
                    break;
                case 2 :
                    voucherT();
                    break;
                case 3 :
                    giftcardT();
                    break;
                default :
                    System.out.println("invalid option");
            }
    }
    
    static void shoppingT(){
        Account user = accounts[currentUserIndex];
        Transaction current = user.receipt;
        if (current == null) {
            System.out.println("Tidak ada transaksi.");
            return;
        }

        int receiptCount = 1;
        while (current != null) {
            System.out.println("\n=== Receipt #" + receiptCount + " ===");
            System.out.println("ID Transaksi: " + current.ID);
            System.out.println("Produk yang dibeli:");
            
            // Display all products in this transaction
            for (int i = 0; i < current.product.length && current.product[i] != null; i++) {
                System.out.println("- " + current.product[i]);
            }
            
            System.out.println("Harga Awal: Rp " + current.originalPrice);
            System.out.println("Harga Akhir: Rp " + current.finalPrice);
            
            if (current.originalPrice != current.finalPrice) {
                int diskon = current.originalPrice - current.finalPrice;
                System.out.println("Total Diskon: Rp " + diskon);
            }
            
            System.out.println("==================");
            current = current.next;
            receiptCount++;
        }
    }
    
    static void voucherT(){
        Account user = accounts[currentUserIndex];
        Voucher current = user.vReceipt;
        if (current == null) {
            System.out.println("Tidak ada transaksi.");
            return;
        }

        int receiptCount = 1;
        while (current != null) {
            System.out.println("\n=== Receipt #" + receiptCount + " ===");
            System.out.println("Tipe Voucher    :   " + current.tipeVoucher+"%");
            System.out.println("Total Dibeli    :   " + current.totalBought);
            System.out.println("Total Harga     :   " + current.totalPembayaran);
            System.out.println("==================");
            current = current.next;
            receiptCount++;
        }
    }
    
    static void giftcardT(){
        Account user = accounts[currentUserIndex];
        Giftcard current = user.gReceipt;
        if (current == null) {
            System.out.println("Tidak ada transaksi.");
            return;
        }

        int receiptCount = 1;
        while (current != null) {
            System.out.println("\n=== Receipt #" + receiptCount + " ===");
            System.out.println("From    :   " + current.from);
            System.out.println("To      :   " + current.forUser);
            System.out.println("Through :   " + current.through);
            System.out.println("Comment :   " + current.comment);
            System.out.println("Total Given : " + current.total);
            System.out.println("==================");
            current = current.next;
            receiptCount++;
        }
    }

    static void bayarPLN() {
        Account user = accounts[currentUserIndex];

        System.out.print("Masukkan password: ");
        String pw = in.nextLine();
        if (!pw.equals(user.password)) {
            System.out.println("Password salah!");
            return;
        }

        System.out.print("Masukkan nomor meter rumah: ");
        String noMeter = in.nextLine();

        int token = 100000 + (int) (Math.random() * 900000); // random 6-digit token

        user.PLN.noMeterRumah = noMeter;
        user.PLN.token = token;

        System.out.println("Pembayaran berhasil.");
        System.out.println("No Meter Rumah: " + user.PLN.noMeterRumah);
        System.out.println("Token Listrik: " + user.PLN.token);
    }

    static void setorBank() {
        Account user = accounts[currentUserIndex];
        System.out.println("Pilih bank:");
        System.out.println("1. Mandiri");
        System.out.println("2. BCA");
        System.out.println("3. BRI");

        System.out.print("Pilihan: ");
        int bank = in.nextInt();
        in.nextLine();

        if (bank < 1 || bank > 3) {
            System.out.println("Pilihan bank tidak valid.");
            return;
        }

        System.out.print("Masukkan nominal setor: ");
        int nominal = in.nextInt();
        in.nextLine();

        user.money[bank - 1] += nominal;

        System.out.println("Setor berhasil ke rekening " + (bank == 1 ? "Mandiri" : bank == 2 ? "BCA" : "BRI") + ".");
        System.out.println("Saldo sekarang: Rp " + user.money[bank - 1]);
    }

    static void goPayLater() {
        Account user = accounts[currentUserIndex];

        if (user.money[3] == 0) {
            System.out.println("\n--- Aktivasi GoPayLater ---");
            System.out.print("Masukkan KTP: ");
            String ktp = in.nextLine();
            System.out.print("Masukkan password: ");
            String pass = in.nextLine();
            System.out.print("Masukkan Nomor HP: ");
            String hp = in.nextLine();

            if (pass.equals(user.password)) {
                user.nomorHP = hp;
                user.pinjaman = new Pinjaman();
                user.money[3] = 20000000;
                System.out.println("GoPayLater berhasil diaktifkan!");
            } else {
                System.out.println("Password salah!");
            }

        } else {
            System.out.println("\n--- GoPayLater Aktif ---");
            System.out.println("Nomor HP terdaftar: " + user.nomorHP);
            System.out.println("Total tagihan: Rp " + user.pinjaman.totalTagihan);

            if (user.pinjaman.totalTagihan == 0) {
                System.out.println("Tidak ada tagihan untuk dibayar.");
                return;
            }

            System.out.print("Bayar tagihan sekarang? (y/n): ");
            String jawab = in.nextLine();

            if (jawab.equalsIgnoreCase("y")) {
                int bayar = user.pinjaman.totalTagihan + (user.pinjaman.totalTagihan * 2 / 100);
                System.out.println("Total dengan bunga 2%: Rp " + bayar);

                // Pilih bank untuk bayar
                System.out.println("Bayar dari:");
                System.out.println("1. Mandiri");
                System.out.println("2. BCA");
                System.out.println("3. BRI");
                System.out.print("Pilih bank: ");
                int bank = in.nextInt();
                in.nextLine();

                if (bank < 1 || bank > 3) {
                    System.out.println("Pilihan bank tidak valid.");
                    return;
                }

                if (user.money[bank - 1] >= bayar) {
                    user.money[bank - 1] -= bayar;
                    user.pinjaman.totalPembayaran += bayar;
                    user.pinjaman.totalTagihan = 0;
                    System.out.println("Tagihan GoPayLater berhasil dibayar!");
                } else {
                    System.out.println("Saldo tidak cukup untuk membayar tagihan!");
                }
            }
        }
    }
    
    static void tampilSaldo(){
        Account user = accounts[currentUserIndex];
        String[] bank= {"Mandiri","BCA","BRI"};
        
        for (int i = 0; i < 3; i++) {
            System.out.println("Saldo "+bank[i]+"  :   "+user.money[i]);
        }
        System.out.println("");
    }
}