import java.util.Scanner;

public class Modul5_No3 {
    static double pendapatan = 0, totalppn = 0, service = 0, keuntungan = 0, totalbayar = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nasgor = 15000, geprek = 10000, nasbak = 15000, teh = 5000, airputih = 2000, total = 0;

        while(true){
            System.out.print("Atas Nama: ");
            String nama = sc.nextLine();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
            Menu();

            while(true){
                System.out.print("Pilih menu: ");
                int pilihan = sc.nextInt();
                sc.nextLine();

                if(pilihan == 0){
                    double ppn = hitungPPN(total);
                    double serviceCharge = hitungServiceCharge(total);
                    totalbayar = total + ppn + serviceCharge;

                    pendapatan += totalbayar;
                    totalppn += ppn;
                    service += serviceCharge;

                    Nota(nama, total, ppn,serviceCharge, totalbayar);

                    System.out.print("\nApakah ada pelanggan lain? (y/n): ");
                    char lanjut = sc.nextLine().charAt(0);

                    if(lanjut == 'n' || lanjut == 'N') {
                        laporanPendapatan();
                        System.out.println("Terima kasih telah menggunakan layanan kami!");
                        sc.close();
                    return;

                    }else{
                        break;
                    }
                }

                switch (pilihan) {
                    case 1:
                        total += nasgor;
                    break;

                    case 2:
                        total += geprek;
                    break;

                    case 3:
                        total += nasbak;
                    break;

                    case 4:
                        total += teh;
                    break;

                    case 5:
                        total += airputih;
                     break;

                    default:
                        System.out.println("Menu invalid");
                    continue;
                }

                System.out.println("Total sementara: Rp " + total);
            }
        }
    }

    public static void Menu() {
        System.out.println("\nPilihlah menu makanan: ");
        System.out.println("1. Nasi Goreng - Rp 15000");
        System.out.println("2. Geprek - Rp 10000");
        System.out.println("3. Nasi Bakar - Rp 15000");
        System.out.println("\nPilihlah menu minuman: ");
        System.out.println("4. Es Teh - Rp 5000");
        System.out.println("5. Air Putih - Rp 2000");
        System.out.println("\n0. The Bill Please");
    }

    public static void Nota(String nama, int total, double ppn, double serviceCharge, double totalbayar) {
        System.out.println("\nNota anda atas nama: " + nama);
        System.out.println("Total harga makanan/minuman: Rp " + total);
        System.out.println("PPN 11%: Rp " + ppn);
        System.out.println("Service Charge 5%: Rp " + serviceCharge);
        System.out.println("Total bayar: Rp " + totalbayar);  
    }

    public static double laporanPendapatan() {
        System.out.println("\n--- Laporan Pendapatan Restoran ---");
        System.out.println("Total Pendapatan Restoran: Rp " + totalppn);
        System.out.println("Total Service Charge " + pendapatan);
        System.out.println("Total PPN yang diterima resto yang diterima restoran: Rp " + service);
        System.out.println("Keuntungan Restoran: Rp " + (pendapatan - totalppn - service));

        double biayaUtilitas = pendapatan * 0.10;
        double bayarPegawai = pendapatan * 0.15;
        double bahanBaku = pendapatan * 0.20;
        double keuntungan = pendapatan - totalppn - service - biayaUtilitas - bayarPegawai - bahanBaku;
        System.out.println("Keuntungan Restoran: Rp " + keuntungan);

        return keuntungan;
    }

    public static double hitungPPN(int total) {
        return total * 0.11;
    }

    // Fungsi untuk menghitung service charge 5%
    public static double hitungServiceCharge(int total) {
        return total * 0.05;
    }
}
