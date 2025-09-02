import java.util.ArrayList;
import java.util.Scanner;

class Pasien {
	String nama;
	String alamat;
	String telepon;
	int usia = 0;
	String penyakit;
	boolean menggunakanBPJS;

	public Pasien(String nama, String alamat, String telepon, int usia, String penyakit, boolean menggunakanBPJS) {
		this.nama = nama;
		this.alamat = alamat;
		this.telepon = telepon;
		this.usia = usia;
		this.penyakit = penyakit;
		this.menggunakanBPJS = menggunakanBPJS;
	}

	@Override
	public String toString() {
		return "Nama: " + nama + ", Alamat: " + alamat + ", Telepon: " + telepon + ", Usia: " + usia + ", penyakit: " + penyakit + ", BPJS: " + (menggunakanBPJS ? "Ya" : "Tidak");
	}
}

public class Quiz2_No2 {
	private static final int MAKS_PASIEN = 10;
	private static ArrayList<Pasien> daftarPasien = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalHarga;
		int harga = 5000;

		while (true) {
			if (daftarPasien.size() >= MAKS_PASIEN) {
				System.out.println("Rumah sakit sudah penuh.");
				break;
			}

			System.out.println("Masukkan data pasien:");
			System.out.print("Nama: ");
			String nama = sc.nextLine();

			System.out.print("Alamat: ");
			String alamat = sc.nextLine();

			System.out.print("Telepon: ");
			String telepon = sc.nextLine();

			System.out.print("penyakit: ");
			String penyakit = sc.nextLine();

			System.out.print("Usia: ");
			int usia = sc.nextInt();

			System.out.print("Menggunakan BPJS (true/false): ");
			boolean menggunakanBPJS = sc.nextBoolean();
			sc.nextLine();

			daftarPasien.add(new Pasien(nama, alamat, telepon, usia, penyakit, menggunakanBPJS));

			System.out.print("Tambah pasien lagi? (y/n): ");
			String lagi = sc.nextLine();
			if (lagi.equalsIgnoreCase("n")) {
				break;
			}
		}

		tampilkanMenu(sc);
	}

	private static void tampilkanMenu(Scanner sc) {
		while (true) {
			System.out.println("\nMenu:");
			System.out.println("1. Hitung jumlah pasien yang terdaftar");
			System.out.println("2. Hitung pasien dengan usia kurang dari X dan menggunakan BPJS");
			System.out.println("3. Tampilkan data pasien dengan nama tertentu");
			System.out.println("4. Keluar");
			System.out.print("Pilih menu: ");
			int pilihan = sc.nextInt();
			sc.nextLine();

			switch (pilihan) {
			case 1:
				System.out.println("Jumlah pasien terdaftar: " + daftarPasien.size());
				System.out.println("Sisa kapasitas: " + (MAKS_PASIEN - daftarPasien.size()));
				break;
			case 2:
				System.out.print("Masukkan usia X: ");
				int usiaX = sc.nextInt();
				sc.nextLine();
				int count = 0;
				for (Pasien p : daftarPasien) {
					if (p.usia < usiaX && p.menggunakanBPJS) {
						count++;
					}
				}
				System.out.println("Jumlah pasien dengan usia kurang dari " + usiaX + " dan menggunakan BPJS: " + count);
				break;
			case 3:
				System.out.print("Masukkan nama pasien: ");
				String namaY = sc.nextLine();
				boolean ditemukan = false;
				for (Pasien p : daftarPasien) {
					if (p.nama.equalsIgnoreCase(namaY)) {
						System.out.println(p);
						ditemukan = true;
					}
				}
				if (!ditemukan) {
					System.out.println("Pasien dengan nama " + namaY + " tidak ditemukan.");
				}
				break;
			case 4:
				System.out.println("Keluar dari program.");
				return;
			default:
				System.out.println("Pilihan tidak valid.");
			}
		}
	}
}
