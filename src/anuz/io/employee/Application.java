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

	public static String inputFile = "employee.csv";
	public static String outputFile = "empOutput.csv";

	public static void main(String[] args) {
		BufferedReader br = null; // buffer reader object
		File csvData = new File(inputFile); // The file is present at the root of the project
		String currentLine; // reads the current line

		Employee[] empList = new Employee[1]; // create 1 initially and grow as it goes
		int currentIndex = 0;

		try {
			// check if the file location is present or not
			if (!csvData.exists()) {
				System.out.println("The file is not found. Please provide the correct location.");
			}

			// Create the buffered reader
			br = new BufferedReader(new FileReader(csvData));
			// this will bypass the header
			br.readLine();

			// run until there are lines to be read
			while ((currentLine = br.readLine()) != null) {
				System.out.println(currentLine);

				List<String> valList = parseEachLine(currentLine);

				// if arraylist contains the data
				if (!valList.isEmpty()) {
					// create the employee
					Employee temp = new Employee(valList.get(0), Integer.parseInt(valList.get(1)), valList.get(2),
							valList.get(3), Double.parseDouble(valList.get(4)), valList.get(5));

					// add to employee array
					if (empList[empList.length - 1] != null)
						empList = resizeArray(empList);

					empList[currentIndex++] = temp;

					System.out.println(temp);

					// System.out.println(temp.toCSV());

					// write each object/line to CSV
					writeCSV(temp);
				}
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			e.printStackTrace();
		}

	}

	public static Employee[] resizeArray(Employee[] arr) {
		System.out.println("Resizing " + arr.length + " to " + arr.length * 2);
		return Arrays.copyOf(arr, arr.length * 2);
	}

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

	public static boolean writeCSV(Employee temp) {
		boolean flag = false;

		FileWriter fw;
		try {
			// create Outtput file if not present
			File file = new File(outputFile);

			if (file.exists()) {
				fw = new FileWriter(file, true);// if file exists append to file. Works fine.
			} else {
				file.createNewFile();
				fw = new FileWriter(file);
			}

			fw.append(temp.toCSV());
			fw.append(NEW_LINE_SEPARATOR);
			
			fw.flush();
			fw.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} 

		// write to CSV

		return flag;
	}
}
