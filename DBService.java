package HMDataProcess;

import java.util.List;

public class DBService {

	/*
	 * Dummy Method to populate data into DB
	 */
	public static void populateDB(List<String> inputList) {
		//Commit data in batch of 5 records
		int chunkCount = 5;
		for(int count=0; count<inputList.size(); count++) {
			System.out.println(inputList.get(count));
			
			if(((count+1)%chunkCount == 0) || count == inputList.size()-1)
				System.out.println("Committed batch.");
		}
	}
	
}
