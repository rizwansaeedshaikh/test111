//a variant of quick sort is used here.
public class DutchNationalFlag {

	public static void main(String[] args) {

		DutchNationalFlag d = new DutchNationalFlag();
		int[] lArray = { 1, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 2, 1 };
		for (int i : lArray) {
			System.out.print(i + " ");
		}
		System.out.println();
		d.sort1(lArray, 0, lArray.length - 1);
		for (int i : lArray) {
			System.out.print(i + " ");
		}
		System.out.println();

		int[] lArray2 = { 1, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 2, 1 };
		d.sort2(lArray2, 0, lArray2.length - 1);
		for (int i : lArray2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	//O(N) time. O(N) space
	public void sort1(int[] aArray, int low, int high) {

		int pivot = 1;
		int current = low;
		int start = current;
		int end = high;
		int iter = 0;
		while (current <= end) {
			++iter;
			if (aArray[current] > pivot) {
				swap(aArray, current, start);
				start++;
			} else if (aArray[current] < pivot) {
				swap(aArray, current, end);
				end--;
				// current++;
			} else {
				current++;
			}
		}
		System.out.println(iter);
	}

	//O(2N) = O(N) time. O(N) space
	public void sort2(int[] aArray, int low, int high) {

		int pivot = aArray[low];
		int smaller = 0;
		int iter = 0;
		//move 0 to start of the array.
		for (int i = 0; i <= high; i++) {
			iter++;
			if (aArray[i] < pivot) {
				swap(aArray, i, smaller++);
			}
		}
		
		//move 2 to the end of the array 
		int larger = high;
		for (int i = high; i >= 0; i--) {
			iter++;
			if (aArray[i] > pivot) {
				swap(aArray, i, larger--);
			}
		}
		System.out.println(iter);
	}
	
		//O(N) time. O(N) space
		public void sort3(int[] aArray, int low, int high) {

			int pivot = aArray[low];
			int smaller = low;
			int iter = 0;
			int larger = high;
			//move 0 to start of the array.
			for (int i = 0; i <= high; i++) {
				iter++;
				if (aArray[i] < pivot) {
					swap(aArray, i, smaller++);
				}
				if (aArray[i] > pivot) {
					swap(aArray, i, larger--);
				}
			}
			System.out.println(iter);
		}

	private void swap(int[] aArray, int i, int j) {

		if (i == j)
			return;
		int lTemp = aArray[i];
		aArray[i] = aArray[j];
		aArray[j] = lTemp;
	}
}
