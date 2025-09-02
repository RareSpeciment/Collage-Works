public class pemanasan {

    public static double NA (int jumlahAlpha, double nilaiAkhir){
        double total;

        if (jumlahAlpha >= 3){
            total = nilaiAkhir - ((jumlahAlpha - 2) * 5);
            return total;
        }else{
            return nilaiAkhir;
        }
    }
    public static void main(String[] args) {
        System.out.println(NA(3,80));
    }
}
