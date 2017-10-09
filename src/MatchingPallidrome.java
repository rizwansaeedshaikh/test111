
public class MatchingPallidrome
{

    public static void main(String[] args)
    {
        String input = "asgdkjashnitinsjahdk";
        
        //System.out.println(isPallidrome(input));
        
        boolean pallidromeFound = false;
        for(int i = 0; i < input.length() - 3; i++){
        	if(pallidromeFound)
        		break;
            for(int j = i + 3; j <= input.length(); j++){
                //System.out.println( i + " " + (j) + " " + input.substring(i,j) + " " );
                
                if(isPallidrome(input.substring(i,j))){
                    System.out.println(i);
                    pallidromeFound  = true;
                    break;
                }
            }
        }
        if(!pallidromeFound)
            System.out.println(-1);
    }

    /**
     * first iteration i 0 j 1 to length -1
     * i 0 j 3 to 20  
     * i 1 j 4 to 20
     * i 2 j 5 to 20
     * i 3 j 6 to 20
     * @param input
     * @return
     */
    private static boolean isPallidrome(String input)
    {

        if (input == null || input.length() == 0 || input.length() == 1)
            return false;
        else
            return input.equals(reverse(input));
    }

    private static String reverse(String input)
    {
        if (input == null || "".equals(input))
            return null;
        else
        {
            String output = "";
            String[] chars = input.split("");
            for (int count = chars.length - 1; count >= 0; count--)
            {
                output += chars[count];
            }
            return output;
        }
    }
}
