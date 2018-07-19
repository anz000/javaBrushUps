package anuz.io.employee;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Application {

	private static final String NEW_LINE_SEPARATOR = "\n";

	public static String inputFile = "employee.csv"; // input File
	public static String outputFile = "empOutput.csv"; // output File

	/**
	 * Main Method
	 */
	public static void main(String[] args) {
		System.out.println("Reading CSV file...");
		Employee[] empObjects = readCSV(); 			// reading the CSV

		System.out.println("Writing CSV file...");
		for (Employee e : empObjects) {
			if(e == null)	break;					// if object is empty skip	
			writeCSV(e); 							// writing CSV line by line
		}
		
		System.out.println("All the operations have been completed.");
	}

	/**
	 * This method resizes the array - doubles the size
	 * 
	 * @param arr  The employee array
	 * @return empList Employee[] The resized employee array
	 */
	public static Employee[] resizeArray(Employee[] arr) {
		System.out.println("Resizing " + arr.length + " to " + arr.length * 2);
		return Arrays.copyOf(arr, arr.length * 2);
	}

	/**
	 * This method reads in the CSV data and returns the Employees object in an
	 * array
	 * 
	 * @return Employee[] The array containing employee objects parsed from CSV
	 */
	public static Employee[] readCSV() {
		BufferedReader br = null;			  // buffer reader object
		File csvData = new File(inputFile);   // The file is present at the root of the project
		String currentLine;					  // reads the current line

		Employee[] empList = new Employee[1]; // create 1 initially and grow as it goes
		int currentIndex = 0;

		try {
			if (!csvData.exists()) { 		  // check if the file location is present or not
				System.out.println("The file is not found. Please provide the correct location.");
			}

			br = new BufferedReader(new FileReader(csvData));   // Create the buffered reader
			br.readLine(); 										// this will bypass the header

			while ((currentLine = br.readLine()) != null) { 	// run until there are lines to be read
				// System.out.println(currentLine);
				List<String> valList = parseEachLine(currentLine); // get all the values in a single line

				if (!valList.isEmpty()) { 						// if arraylist contains the data
					// create the employee
					Employee temp = new Employee(valList.get(0), Integer.parseInt(valList.get(1)), valList.get(2),
							valList.get(3), Double.parseDouble(valList.get(4)), valList.get(5));

					// add to employee array
					if (empList[empList.length - 1] != null)	 // if the last index contains object, then resize
						empList = resizeArray(empList);

					empList[currentIndex++] = temp;				 // push the temp object to the main Array
					// System.out.println(temp);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			// e.printStackTrace();
		}
		return empList;
	}

	/**
	 * This method parses a given line and returns the arrays from which the object
	 * can be constructed
	 * 
	 * @param line
	 *            The object data as a line in a CSV
	 * @return The list of values parsed from the line
	 */
	public static List<String> parseEachLine(String line) {
		// parse each line delimited by comma
		StringTokenizer strTokens = new StringTokenizer(line, ",");
		ArrayList<String> values = new ArrayList<>();

		// csv is supposed to have 6 elements per employee
		if (strTokens.countTokens() != 6) {
			System.out.println("Bad data @line containing " + line);
		} else {
			while (strTokens.hasMoreTokens()) {
				values.add(strTokens.nextToken());
			}
		}
		return values;
	}

	/**
	 * This method writes an individual employee object to a CSV file
	 * 
	 * @param temp
	 *            An employee object to be written
	 * @return flag Boolean values whether the CSV gets written or not
	 */
	public static boolean writeCSV(Employee temp) {
		boolean flag = false;

		FileWriter fw;
		try {
			File file = new File(outputFile);

			if (file.exists()) {
				fw = new FileWriter(file, true); // if file exists append to file
			} else {
				file.createNewFile(); // create a new one if not present
				fw = new FileWriter(file);
			}

			fw.append(temp.toCSV()); // appending to file
			fw.append(NEW_LINE_SEPARATOR);

			fw.flush();
			fw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return flag;
	}
}
