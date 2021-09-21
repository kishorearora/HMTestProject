package HMDataProcess;

import java.io.IOException;

public class StartProcess {
	
	//Main function to start processing file
	public static void main(String args[]) {

		System.out.println("Start processing file.");

		FileData fileData = new FileData();
		try {
			//Read data from file, process and populate into DB
			fileData.readAndProcessFileData("C:\\HMTest\\HMData.txt");
		} catch (IOException ex) {
			System.out.println("Error in processing the file: " + ex.getMessage());
			//ex.printStackTrace();
		}
		
		System.out.println("End processing file.");
	}
}
