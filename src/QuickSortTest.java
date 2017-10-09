
import org.junit.Test;
import static org.junit.Assert.*;

public class QuickSortTest {

    QuickSort sort = new QuickSort();
    
    @Test
    public void testSort() {
        int[] lSortedArray = sort.sort(new int[] {10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 0, 9);
        for(int l : lSortedArray) {
            System.out.print(l + " ");
        }
        for(int lCount = 0; lCount < 10; lCount++)
            assertEquals(lCount + 1, lSortedArray[lCount] );
        System.out.println();
    }
    
    @Test
    public void arrangeInMaxMinForm() {
        
        System.out.println("Max min");
        int[] maxMinArray = sort.arrangeInMaxMinForm(new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 0, 9);
        for(int l : maxMinArray) {
            System.out.print(l + " ");
        }
        System.out.println();
    }

}
