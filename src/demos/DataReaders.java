package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readCSV();

	}

	
	public static void readCSV() {
		String filename = "/Users/kylederrick/Desktop/Software/UserAccounts.csv";
		List <String[]> records = utilities.CSV.get(filename);
		
		//iterating through the data list
		for(String[] record : records) {
			for(String field : record) {
				System.out.println(field);
			}
		}
	}
}
