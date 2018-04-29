package demos;

import java.util.List;

public class DataReaders {

	public static void main(String[] args) {
		readXLS();

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
	
	public static void readXLS() {
		String filename = "/Users/kylederrick/Desktop/Software/UserLogin.xls";
		String[][] data = utilities.Excel.get(filename);
		for(String[] record : data) {
			System.out.println("\nNew Record");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
