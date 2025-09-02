import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JoptionPane {
    static Scanner sc = new Scanner(System.in);
    static class Jurusan{
        String kode;
        String nama;
        ArrayList <MataKuliah> matkulList = new ArrayList<>();

        public Jurusan(String kode, String nama){
            this.kode = kode;
            this.nama = nama;
        }
    }

    static class Mahasiswa{
        String nim;
        String nama;
        Jurusan jurusan;
        Map<MataKuliah, String> indexNilai = new HashMap<>();

        public Mahasiswa(String nim, String nama, Jurusan jurusan){
            this.nim = nim;
            this.nama = nama;
            this.jurusan = jurusan;
        }
    }

    static class MataKuliah{
        String kode;
        String nama;
        int sks;

        public MataKuliah(String kode, String nama, int sks){
            this.kode = kode;
            this.nama = nama;
            this.sks = sks;
        }
    }

    class aList{
        static ArrayList<Mahasiswa> mhsList = new ArrayList<>();
        static ArrayList<Jurusan> jurusanList = new ArrayList<>();

        public static void tambahJurusan() {
            boolean loop = true;
            do{
                String kode = JOptionPane.showInputDialog("Masukkan kode jurusan: ");
                String nama = JOptionPane.showInputDialog("Masukkan Nama jurusan: ");

                Jurusan jurusan = new Jurusan(kode, nama);
                jurusanList.add(jurusan);

                String pilihan = JOptionPane.showInputDialog("Mau Memasukan lagi? (ya/tidak)");
                if (!pilihan.equalsIgnoreCase("ya")) {
                    loop = false;
                    Menu();
                }
            } while (loop == true);
        }

        public static void tambahMhs() {
            boolean loop = true;
            do{
                String nim = JOptionPane.showInputDialog("Masukkan NIM: ");
                String nama = JOptionPane.showInputDialog("Masukkan Nama: ");

                String daftarJurusan = "pilih jurusan: \n";
                if (jurusanList.size() < 0){
                    JOptionPane.showMessageDialog(null, "Jurusan masih belom ada, input mahasiswa dibatalkan");
                }else{
                    for (int i = 0; i < jurusanList.size(); i++){
                        daftarJurusan += (i+1) + ". " + jurusanList.get(i).nama + "\n";
                    }
                    int pilih = Integer.parseInt(JOptionPane.showInputDialog(daftarJurusan)) - 1;
                    Jurusan jurusan = jurusanList.get(pilih);

                    Mahasiswa mhs = new Mahasiswa(nim, nama, jurusan);
                    mhsList.add(mhs);
                }

                String pilihan = JOptionPane.showInputDialog("Mau Memasukan lagi? (ya/tidak)");
                if (!pilihan.equalsIgnoreCase("ya")) {
                    loop = false;
                    Menu();
                }
            } while (loop == true);
        }

        public static void tambahMatkul(){
            boolean loop = true;
            if (jurusanList.isEmpty()){
                JOptionPane.showMessageDialog(null,"Belum adanya Jurusan, Tolong tambahkan jurusan terlebih dahulu");
                loop = false;
                Menu();
            }

            do{
                String daftarJurusan = "Pilih Jurusan: \n";
                for(int i = 0; i < jurusanList.size(); i++){
                    daftarJurusan += (i+1) + ". " + jurusanList.get(i).nama + "\n";
                }

                int pilih = Integer.parseInt(JOptionPane.showInputDialog(daftarJurusan)) - 1;
                Jurusan jurusan = jurusanList.get(pilih);

                String kode = JOptionPane.showInputDialog("Masukan Kode Mata Kuliah");
                String nama = JOptionPane.showInputDialog("Masukan nama Mata Kuliah");
                int sks = Integer.parseInt(JOptionPane.showInputDialog("Berapa sks kah mata kuliah ini?"));

                MataKuliah mk = new MataKuliah(kode, nama, sks);
                jurusan.matkulList.add(mk);

                String pilihan = JOptionPane.showInputDialog("Apakah ada mata kuliah lainnya yang ingin dimasukan??");
                if (!pilihan.equalsIgnoreCase("ya")){
                    loop = false;
                    Menu();
                }
            }while(loop == true);
        }

        //sudahi. seharusnya aku bikin function biasa aja sepertinya.
        public static void tambahNilai() {
            if (aList.mhsList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Belum ada mahasiswa.");
                Menu();
                return;
            }
            String daftarMhs = "Pilih Mahasiswa:\n";
            for (int i = 0; i < aList.mhsList.size(); i++) {
                daftarMhs += (i + 1) + ". " + aList.mhsList.get(i).nama + " (" + aList.mhsList.get(i).nim + ")\n";
            }
            int pilihMhs = Integer.parseInt(JOptionPane.showInputDialog(daftarMhs)) - 1;
            Mahasiswa mhs = aList.mhsList.get(pilihMhs);

            Jurusan jurusan = mhs.jurusan;
            if (jurusan.matkulList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Jurusan belum memiliki mata kuliah.");
                Menu();
                return;
            }

            String daftarMatkul = "Pilih Mata Kuliah:\n";
            for (int i = 0; i < jurusan.matkulList.size(); i++) {
                daftarMatkul += (i + 1) + ". " + jurusan.matkulList.get(i).nama + "\n";
            }
            int pilihMk = Integer.parseInt(JOptionPane.showInputDialog(daftarMatkul)) - 1;
            MataKuliah mk = jurusan.matkulList.get(pilihMk);

            String indeks = JOptionPane.showInputDialog("Masukkan nilai indeks (A/B/C/D/E):").toUpperCase();
            if (!indeks.matches("[ABCDE]")) {
                JOptionPane.showMessageDialog(null, "Indeks tidak valid.");
                Menu();
                return;
            }

            mhs.indexNilai.put(mk, indeks);
            JOptionPane.showMessageDialog(null, "Nilai berhasil ditambahkan.");
            Menu();
        }

        public static void lihatData(){
            if(mhsList.isEmpty()){
                JOptionPane.showMessageDialog(null, "Belum ada data mahasiswa");
                Menu();
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Mahasiswa mhs : mhsList) {
                sb.append("NIM: ").append(mhs.nim)
                .append("\nNama: ").append(mhs.nama)
                .append("\nJurusan: ").append(mhs.jurusan.nama)
                .append("\nNilai Mata Kuliah:\n");
                double totalNilai = 0;
                int totalSks = 0;
                for (Map.Entry<MataKuliah, String> entry : mhs.indexNilai.entrySet()) {
                    MataKuliah mk = entry.getKey();
                    String indeks = entry.getValue();
                    int nilai = 0;
                    switch (indeks) {
                        case "A": nilai = 4; break;
                        case "B": nilai = 3; break;
                        case "C": nilai = 2; break;
                        case "D": nilai = 1; break;
                        case "E": nilai = 0; break;
                    }
                    sb.append("- ").append(mk.nama)
                    .append(" (").append(mk.sks).append(" SKS): ")
                    .append(indeks).append("\n");
                    totalNilai += nilai * mk.sks;
                    totalSks += mk.sks;
                }
                double ip = totalSks > 0 ? totalNilai / totalSks : 0;
                sb.append("IP: ").append(String.format("%.2f", ip)).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
            Menu();
        }
    }

    public static void Menu() {
        StringBuilder menu = new StringBuilder();
        menu.append("Menu \n")
        .append("0. Tambah Jurusan \n")
        .append("1. Tambah Mahasiswa \n")
        .append("2. Tambah Mata Kuliah \n")
        .append("3. Tambah Nilai \n")
        .append("4. Lihat Data \n")
        .append("5. Keluar \n");
        int pilihan = Integer.parseInt(JOptionPane.showInputDialog(menu.toString()));

        switch (pilihan) {
            case 0:
                aList.tambahJurusan();
                break;
            case 1:
                aList.tambahMhs();
                break;
            case 2:
                aList.tambahMatkul();
                break;
            case 3:
                aList.tambahNilai();
                break;
            case 4:
                aList.lihatData();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Pilihan tidak valid");
        }
    }

    public static void main(String[] args) {
        Menu();
    }
}