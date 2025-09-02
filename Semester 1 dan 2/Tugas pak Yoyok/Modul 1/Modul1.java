import java.util.Scanner;

class Student{
    String Nama;
    String Nim;

    public Student(){
        this.Nama = "Unknown";
        this.Nim = "000000";
    }

    public Student(String Nama, String Nim){
        this.Nama = Nama;
        this.Nim = Nim;
    }

    public void printDetail() {
        System.out.println("Nama : " + Nama + " Nim : " + Nim);
    }
}

public class Modul1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student st1 = new Student("Andi", "1224015");
        Student st2 = new Student("Noni", "1224020");
        Student st3 = inputStudent();

        st1.printDetail();
        st2.printDetail();
        st3.printDetail();
        
        sc.close();
    }

    public static Student inputStudent(){
        Scanner sc = new Scanner(System.in);
        String nama;
        String nim;

        System.out.print("Masukkan nama : ");
        nama = sc.nextLine();

        System.out.print("Masukkan nim : ");
        nim = sc.nextLine();

        return new Student(nama,nim);
    }
}