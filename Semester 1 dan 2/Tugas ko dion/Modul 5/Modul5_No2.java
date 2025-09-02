import java.util.Scanner;

//menggunakan printf (%.4f) atau floating point.4. supaya yang diambil hanya 4 angka setelah koma

public class Modul5_No2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double A, B, hasil;
        char operator;

        while (true) {
            System.out.print("Masukkan Nilai pertama (desimal sampai 4 angka di belakang koma) : ");
            A = sc.nextDouble();

            System.out.print("Masukkan Nilai kedua (desimal sampai 4 angka di belakang koma) : ");
            B = sc.nextDouble();

            System.out.print("Masukkan operator (+, -, *, /, %, ^) : ");
            operator = sc.next().charAt(0);

            // Cek apakah operator valid
            if(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%' || operator == '^'){
                switch (operator) {
                    case '+':
                        hasil = penjumlahan(A, B);
                        System.out.printf("%.4f + %.4f = %.4f\n", A, B, hasil);
                        System.out.println();
                    break;
                    
                    case '-':
                        hasil = pengurangan(A, B);
                        System.out.printf("%.4f - %.4f = %.4f\n", A, B, hasil);
                        System.out.println();
                    break;
                    
                    case '*':
                        hasil = perkalian(A, B);
                        System.out.printf("%.4f * %.4f = %.4f\n", A, B, hasil);
                        System.out.println();
                    break;
                    
                    case '/':
                        if(B != 0){
                            hasil = pembagian(A, B);
                            System.out.printf("%.4f / %.4f = %.4f\n", A, B, hasil);
                            System.out.println();
                        }else{
                            System.out.println("Error: Pembagian dengan nol tidak diperbolehkan.");
                            System.out.println();
                        }
                    break;
                    
                    case '%':
                        if(B == 0){
                            System.out.println("Error: Modulus dengan nol tidak diperbolehkan.");
                            System.out.println();
                        }else{
                            System.out.printf("%.4f %% %.4f = %.4f\n", A, B, mod(A, B));
                            System.out.println();
                        }
                    break;
                    
                    case '^':
                        hasil = perpangkatan(A, B);
                        System.out.printf("%.4f ^ %.4f = %.4f\n", A, B, hasil);
                        System.out.println();
                    break;
                    
                    default:
                        System.out.println("Operator tidak dikenal.");
                        System.out.println();
                    break;
                }
            } else {
                System.out.println("Operator tidak valid. Program berhenti.");
                System.out.println();
                break;
            }
        }
        sc.close();
    }


    //penjumlahan
    public static double penjumlahan(double A, double B) {
        return A + B;
    }

    //pengurangan
    public static double pengurangan(double A, double B) {
        return A - B;
    }

    //perkalian
    public static double perkalian(double A, double B) {
        return A * B;
    }

    //pembagian
    public static double pembagian(double A, double B) {
        return A / B;
    }

    //mod
    public static double mod(double A, double B) {
        return A % B;
    }

    //perpangkatan
    public static double perpangkatan(double A, double B) {
        return Math.pow(A, B);
    }
}