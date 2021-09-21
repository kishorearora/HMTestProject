package HMDataProcess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class FileData {

	public void readAndProcessFileData(String filePath) throws IOException  {

		//List to store the data read from file
		List<String> dataList = new ArrayList<>();
		//Reader object to read file
		FileReader fr = new FileReader(filePath);

		//Buffer the data
		BufferedReader br = new BufferedReader(fr);

		//String to store each line
		String data;

		//iterate over buffer reader for each line
		while ((data = br.readLine()) != null && !data.equals("")) {
			//Check and add data to list if data is alphanumeric. 
			if(isAlphaNumeric(data))
				dataList.add(data);
		}
		//Close BufferReader
		br.close();
		
		//check if list is null
		Optional<List<String>> op = Optional.ofNullable(dataList);
		
		//if there is data in list, populate it into DB
		if(op.isPresent()) {
			DBService.populateDB(op.get());
		}
		else
			System.out.println("No Data in file to process.");
		
	}
	
	//pattern object for alphanumeric
    private Pattern pattern = Pattern.compile("^[a-zA-Z0-9]*$");
    
    /*
     * Method to check if a string contains alphanumeric characters.
     */
    public boolean isAlphaNumeric(String s) {
        return pattern.matcher(s).find();
    }

}
