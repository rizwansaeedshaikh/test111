package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) {

		// Step 1 - Create two file objects representing source and destination
		File source = new File("C:\\Users\\AH0663232\\Desktop\\SCJP6.pdf");
		File destination = new File("C:\\Resources\\Ebooks\\SCJP6.pdf");

		// Step 2 - Create FileInputStream to read the contents from source
		FileInputStream sourceStream = null;
		try{
			sourceStream = new FileInputStream(source);
		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		// Step 3 - Create FileOutputStream to write the contents to destination
		FileOutputStream destinationStream = null;
		try {
			destinationStream = new FileOutputStream(destination);
		} catch(FileNotFoundException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
			try {
				sourceStream.close();
			} catch (IOException e1) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
			throw new RuntimeException(e.getMessage());
		}
				
		// Step 4 - Create a byte array of size 1024. To hold 1KB data
		byte[] aKBdata = new byte[1024];
		
		// Step 5 - Read 1 KB data at a time from source FileInputStream and
		// write it to destination FileOutputStream
		try{
			while(sourceStream.read(aKBdata) != -1){
				destinationStream.write(aKBdata);
			}
			sourceStream.close();
			destinationStream.close();
		} catch(IOException e){
			e.printStackTrace();
			System.err.println(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		
		
	}
}
