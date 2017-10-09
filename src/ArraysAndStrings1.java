
/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 * @author AH0663232
 *
 */
public class ArraysAndStrings1 {

	public static void main(String[] args) {
		
		/**
		 *  1 1 1 1 1
			1 1 0 1 1
			1 1 0 1 0
			1 1 1 1 1
		 */
		int[][] matrix = new int[4][5];
		matrix[0] = new int[] {1,1,1,1,1};
		matrix[1] = new int[] {1,1,0,1,1};
		matrix[2] = new int[] {1,1,0,1,0};
		matrix[3] = new int[] {1,1,1,1,1};
		
		display(matrix);
		setZeros(matrix);
		display(matrix);
	}
	
	private static void setZeros(int[][] matrix) {
		

		int[] row = new int[matrix.length];
		int[] column = new int[matrix[0].length];
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j] == 0) {
					row[i] = 1;
					column[j] = 1;
				}
			}
		}
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				if(row[i] == 1 || column[j] == 1)
					matrix[i][j] = 0;
			}
		}
	}
	
	private static void display(int[][] matrix) {
		
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
