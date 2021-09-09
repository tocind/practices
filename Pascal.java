package prac;

public class Pascal {



    public static void main(String[] args) {
        printPascal(5);
    }


    private static void printPascal(int lines) {
        int[][] table = new int[lines][lines];

        for (int i = 0; i < lines; ++i) {

            for (int j = 0; j <= i; ++j) {

                if (i == j || j == 0) {
                    table[i][j] = 1;
                } else {
                    table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
                }

            }

        }

        for (int i = 0; i < lines; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print(table[i][j]);
                System.out.print(' ');
            }
            System.out.print('\n');
        }
    }

}
