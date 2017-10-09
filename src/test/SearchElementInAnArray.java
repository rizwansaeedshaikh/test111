package test;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SearchElementInAnArray
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator());
        int noOfTestCases = scanner.nextInt();
        for (int countT = 0; countT < noOfTestCases; countT++)
        {

            int arraySize = scanner.nextInt();
            int input[] = new int[arraySize];
            String s = scanner.next();
            StringTokenizer tokenizer = new StringTokenizer(s, " ");
            int countS = 0;
            while (tokenizer.hasMoreTokens())
            {

                input[countS++] = Integer.parseInt(tokenizer.nextToken());
            }
            int find = scanner.nextInt();
            for (int count = 0; count < arraySize; count++)
            {
                if (input[count] == find)
                {
                    System.out.println(count);
                    break;
                }
                else if (count == arraySize - 1)
                {
                    System.out.println(-1);
                }
            }

        }

        scanner.close();
    }
}
