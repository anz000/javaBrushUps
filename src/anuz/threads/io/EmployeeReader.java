package anuz.threads.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class EmployeeReader {
	File file; 				// file to be read
	List<Employee> empList;	// This will contain the employee objects 
	List<String> errList;	// This will contain the corrupt lines
	
	/**
	 * Overloaded constructor
	 * @param file data to be read
	 */
	public EmployeeReader(File file, List<Employee> employeeList, List<String> errList) {
		this.file = file;
		this.empList = employeeList;
		this.errList = errList;
	}
	
	/**
	 * This method reads in the employee data 
	 * converts them to objects and return the list
	 * @return
	 */
	public void readEmployees(){
		/**
		 *  parse the files and add it to arrayList
		 */
		BufferedReader br = null;			  // buffer reader object
		String currentLine = "";			  // reads the current line

		try {
			if (!file.exists()) {			  // check if the file location is present or not
				System.out.println("The file:" + file + " is not found. Please provide the correct location.");
			}

			br = new BufferedReader(new FileReader(file));  	// Create the buffered reader
			while ((currentLine = br.readLine()) != null) { 	// run until there are lines to be read
				
				List<String> valList = parseEachLine(currentLine); // get all the values in a single line
				
				if (!valList.isEmpty()) { 						// if StringArrayList contains the data
					// create the employee
					Employee temp = new Employee(Integer.parseInt(valList.get(0)), valList.get(1),
							Double.parseDouble(valList.get(2)), valList.get(3));
					
					empList.add(temp);			// adding to valid employee list
				}else {
					errList.add(currentLine);	// adding to corrupt list if cannot create an object
				}
			}
		} catch (Exception e) {
			errList.add(currentLine); // adding to corrupt list if exception
			System.out.println("Exception : " + e.getMessage());
			//e.printStackTrace();
		}		
	}
	
	/**
	 * This method parses a given line and returns the arrays from which the object
	 * can be constructed
	 * 
	 * @param line
	 *            The object data as a line in a CSV
	 * @return The list of values parsed from the line
	 */
	private List<String> parseEachLine(String line) {
		// parse each line delimited by comma
		StringTokenizer strTokens = new StringTokenizer(line, ",");
		ArrayList<String> values = new ArrayList<>();

		// csv is supposed to have 4 elements per employee
		if (strTokens.countTokens() != 4) {
			System.out.println("Bad data @line containing " + line);
		} else {
			while (strTokens.hasMoreTokens()) {
				values.add(strTokens.nextToken());
			}
		}
		return values;
	}

}
