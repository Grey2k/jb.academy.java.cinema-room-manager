import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        // fill matrix
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        // rotate
        int[][] rotation = new int[m][n];
        for (int i = matrix.length - 1, k = 0; i >= 0 && k < n; i--, k++) {
            for (int j = 0; j < m; j++) {
                rotation[j][k] = matrix[i][j];
            }
        }

        // print
        for (int[] row : rotation) {
            System.out.println(String.join(" ",
                    Arrays.stream(row)
                            .mapToObj(Integer::toString)
                            .toArray(String[]::new)
            ));
        }
    }
}