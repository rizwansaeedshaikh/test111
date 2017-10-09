
public class ForTest
{

    public static void main(String[] args)
    {
        int temp = 0;
        int n = 10;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.println(i + " " + j);
                for (int k = 0; k <= j; k++)
                {
                    temp++;
                }
            }
        }
        System.out.println(temp);
        temp = 0;
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.println(i + " " + j);

                temp++;

            }
        }
        System.out.println(temp);
    }
}
