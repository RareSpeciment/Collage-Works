package Belajar.Struct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class strc3 {
    static class time {
        int jam;
        int menit;
        int detik;

        LocalDateTime objTime = LocalDateTime.now();
        DateTimeFormatter formatobjTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    }

    public static void tampilkan(){
        time tm = new time();

        tm.jam = tm.objTime.getHour();
        tm.menit = tm.objTime.getMinute();
        tm.detik = tm.objTime.getSecond();

        int waktu1;
        int waktu2;

        waktu1 = tm.menit;
        waktu2 = tm.detik;

        System.out.println(tm.jam + ":" + tm.menit + ":" + tm.detik);
        System.out.println(waktu1 + " " + waktu2);
    }

    public static void main(String[] args) {
        tampilkan();
    }
}
