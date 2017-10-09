import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import sun.text.CompactByteArray;

public class KLargestElements {

	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			int t = Integer.parseInt(reader.readLine());
			while(t > 0) {
				String line = reader.readLine();
				
				String i[] = line.split(" ");
				
				int n = Integer.parseInt(i[0]);
				int k = Integer.parseInt(i[1]);
				
				line = reader.readLine();
				String[] arr = line.split(" ");
				Integer[] intArr = new Integer[arr.length];
				for(int count = 0; count < n ; count++) {
					intArr[count] = Integer.parseInt(arr[count]);
				}
				Arrays.sort(intArr, new Comparator<Integer>() {
				
					@SuppressWarnings("unused")
					public int compare(Integer obj1, Integer obj2) {
						
						if(obj2 > obj1) {
							return 1;
						} else if( obj1 > obj2) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				for(int count = 0; count < k ; count++) {
					System.out.print(intArr[count]+ " ");
				}
				System.out.println();
				t--;
			}
		} catch(IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
