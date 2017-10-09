import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MatrixTranspose {

    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running Use either of
         * these methods for input
         */

        // BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line.split(" ")[0]);
        int M = Integer.parseInt(line.split(" ")[1]);

        // declaration and initialization
        int[][] lArray = new int[N][M];

        // populate input array into lArray.
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < M; j++) {
                lArray[i][j] = Integer.parseInt(line.split(" ")[j]);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(lArray[j][i] + " ");
            }
            System.out.println();
        }
    }
}
