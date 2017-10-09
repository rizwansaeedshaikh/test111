import java.util.Stack;


public class LongestBalancedSubArray
{

    public static void main(String[] args)
    {
        
        Stack<Integer> stack = new Stack<Integer>();
        int longestBalanced = 0;
        int balanced = 0;
        int[] input = {1, -1, 2, 3, 4, -4, -3, -2, 1, 2, 3, 4, 5, -5, -4, -3, -2, -1, -3, 1, 3, -3, -1};
        for(int i : input){
            if(stack.empty()){
                stack.push(i);
                balanced = 1;
                continue;
            }
            if(stack.peek() >= 0 && i >= 0){
                stack.push(i);
                balanced++;
            }
            else if(i < 0 && stack.peek() == Math.abs(i) && stack.peek() >= 0){
                balanced++;
                if(balanced > longestBalanced)
                    longestBalanced = balanced;
                stack.pop();
            }
            else {
                balanced = 0;
                stack.removeAllElements();
                stack.push(i);
                balanced++;
            }
            
        }
        System.out.println(longestBalanced);
    }
}
