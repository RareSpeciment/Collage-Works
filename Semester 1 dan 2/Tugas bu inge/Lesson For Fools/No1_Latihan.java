import java.util.Scanner;

public class No1_Latihan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int usia = 0;
        int gelar = 0;
        int ijasah = 0;
        double ipk;

        System.out.println("Masukan Usia : (usia harus di atas 30)");
        usia = sc.nextInt();

        System.out.println("Masukan gelar : (usia dibawah 36 harus 1, usia di bawah 41 harus 2, dan usia di atas 40 harus 3)");
        gelar = sc.nextInt();

        System.out.println("Masukan ijasah : (ijasah harus dibawah 6 tahun)");
        ijasah = sc.nextInt();

        System.out.println("Masukan IPK : (ipk harus di atas 2.75)");
        ipk = sc.nextDouble();

    // if(usia >= 18 && gelar == 1 && ipk >= 2.75 && ijasah <= 6){
    //     System.out.println("Kamu diterima 1");
    // }else {
    //     if(usia >= 30 && gelar == 2 && ipk >= 2.75 && ijasah <= 6){
    //         System.out.println("Kamu diterima 2");
    //     }else {
    //         if(usia >= 35 && gelar == 3 && ipk >= 2.75 && ijasah <= 6){
    //             System.out.println("Kamu diterima 3");
    //         }else{
    //             System.out.println("kamu tidak diterima");
    //         }
    //     }
    // }

        // if(usia >= 18 && ipk >= 2.75 && ijasah <= 6){
        //     if(usia <= 30 && gelar == 1){
        //         System.out.println("diterima 1");
        //     }else if(usia <= 35 && gelar == 2){
        //         System.out.println("diterima 2");
        //     }else if(usia <= 40 && gelar == 3){
        //         System.out.println("diterima 3");
        //     }
        // }else{
        //     System.out.println("Tidak diterima");
        // }

        if(usia >= 18 && ipk >= 2.75 && ijasah <= 6){
            if(usia <= 30 && gelar == 1){
                System.out.println("diterima 1");
            }else{
                if(usia <= 35 && gelar == 2){
                    System.out.println("diterima 2");
                }else{
                    if(usia <= 40 && gelar == 3){
                        System.out.println("diterima 3");
                    }
                }
            }
        }else{
            System.out.println("Tidak diterima");
        }
    }
}
