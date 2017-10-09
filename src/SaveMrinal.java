import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaveMrinal {

    public static void main(String[] args) {

        BufferedReader lReader = null;
        try {
            lReader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(lReader.readLine());
            // System.out.println("n: " + n);

            String lLineOfNumbers = lReader.readLine();
            int[] lNumbers = new int[n];
            int lCount = 0;
            for (String s : lLineOfNumbers.split(" ")) {
                lNumbers[lCount++] = Integer.parseInt(s);
            }
            /*
             * for (int i : lNumbers) { System.out.print(i + " "); }
             */
            int lNumberOfMagicQueries = Integer.parseInt(lReader.readLine());
            // System.out.println(lNumberOfMagicQueries);

            // Trying to give sufficient initial capacity to prevent resizing.
            List<int[]> lMagicQueries = new ArrayList<>(lNumberOfMagicQueries + 5);
            for (lCount = 0; lCount < lNumberOfMagicQueries; lCount++) {
                String lMagicQueryStr = lReader.readLine();
                try {
                lMagicQueries.add(new int[] { Integer.parseInt(lMagicQueryStr.split(" ")[0]),
                        Integer.parseInt(lMagicQueryStr.split(" ")[1]) });
                } catch(ArrayIndexOutOfBoundsException e) {
                    lMagicQueries.add(new int[] { Integer.parseInt(lMagicQueryStr.split(" ")[0]),
                            lNumbers.length });
                }
            }

            /*for (int[] lMagicQuery : lMagicQueries) {
                System.out.println(lMagicQuery[0] + " " + lMagicQuery[1]);
            }
*/
            for (int[] lMagicQuery : lMagicQueries) {
                Set<Integer> lUniqueNumbersInRange = new HashSet<>();

                for (lCount = lMagicQuery[0] - 1; lCount < lMagicQuery[1]; lCount++)
                    lUniqueNumbersInRange.add(lNumbers[lCount]);

                System.out.println(lUniqueNumbersInRange.size());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                lReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
