package Modul2;

public class Tdimensi {
    public static void main(String[] args) {
        double rgb [][][] = new double [5][5][3];
        int greyscale[][] = new int [5][5];

        for (int i = 0; i < rgb.length; i++){
            for (int j = 0; j < rgb[i].length; j++){
                for (int r = 0; r < rgb[i][j].length; r++){
                    rgb[i][j][r] = Math.floor(Math.random() * 225);
                }
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < greyscale[i].length; j++){
                greyscale[i][j] = (int) ((rgb[i][j][0] * 0.2989) + (rgb[i][j][0] * 0.5870)
                + (rgb[i][j][0] * 0.1140));
            }
        }

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                System.out.print(greyscale[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
