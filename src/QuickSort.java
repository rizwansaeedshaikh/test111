
public class QuickSort {

    public int[] arrangeInMaxMinForm(final int[] aArray, final int low, final int high) {
    
        int[] lArrangedArray = new int[aArray.length];
        
        sort(aArray, low, high);
        
        boolean max = false;
        int i = low;
        int j = high;
        for(int lCount = low; lCount < high + 1; lCount++) {
            if(!max) {
                lArrangedArray[lCount] = aArray[j--];
            } else {
                lArrangedArray[lCount] = aArray[i++];
            }
            
            max = !max;
        }
        return lArrangedArray;
    }
    
    public int[] sort(final int[] aArray, final int low, final int high) {
     
        int i = low;
        int j = high;
        final int pivot = aArray[low + (high - low) / 2];
        
        while(i < j) {
            
            while(aArray[i] < pivot) {
                i++;
            }
            
            while(aArray[j] > pivot) {
                j--;
            }
            
            if(i <= j) {
                swap(aArray, i, j);
                i++;
                j--;
            }
            
        }
        
        if(low < j)
            sort(aArray, low, j);
        if(i < high)
            sort(aArray, i, high);
        
        return aArray;
    }
    
    private int[] swap(int[] aArray, int i, int j) {
        
        if(i == j) 
            return aArray;
        int lTemp = aArray[i];
        aArray[i] = aArray[j];
        aArray[j] = lTemp;
        
        return aArray;
    }
}
