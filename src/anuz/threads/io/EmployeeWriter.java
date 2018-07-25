package anuz.threads.io;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeWriter {

	/**
	 * Class level variable instances
	 */
	private List<Employee> empList; // The list of valid employees
	private List<String> errList; // The list of corrupted lines
	private List<Employee> invalidList; // The list of invalid employees
	private static final String NEW_LINE_SEPARATOR = "\n"; // New line generator
	
	private String outputFile = ""; // output File to be written
	private String errorFile = ""; // error File to be written
	private String invalidFile = ""; // invalid employees File to be written

	/**
	 * Overloaded constructor - sets employees and the output file
	 * 
	 * @param list
	 * @param oFileName
	 */
	public EmployeeWriter(String oFileName, List<Employee> list, List<String> errList, List<Employee> invList) {
		this.empList = list; // setting the employees
		this.errList = errList; // corrupted data
		this.invalidList = invList; // list of invalid employees
		this.outputFile = EmployeeBatchTaskRunner.wPath + oFileName; // setting the filename, directory from taskRunner
		this.errorFile = EmployeeBatchTaskRunner.errPath + oFileName; // setting the filename, directory from taskRunner
		this.invalidFile = EmployeeBatchTaskRunner.invalidPath + oFileName; // setting the filename, directory from taskRunner
		checkDirectory(); // creates the directory if not present
	}

	/**
	 * this method checks if the output directory exists or not, creates if not
	 */
	public void checkDirectory() {
		// create the output folder
		File directory = new File(String.valueOf(EmployeeBatchTaskRunner.wPath));
		if (!directory.exists()) {
			directory.mkdir();
		}

		// create the error folder
		directory = new File(String.valueOf(EmployeeBatchTaskRunner.errPath));
		if (!directory.exists()) {
			directory.mkdir();
		}

		// create the invalid folder
		directory = new File(String.valueOf(EmployeeBatchTaskRunner.invalidPath));
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	/**
	 * This method iterates over the employees and error list and writes to DB
	 * (Disk)
	 * 
	 * @return
	 */
	public boolean writeFiles() {
		boolean oStatus = writeOutputFile();
		boolean eStatus = writeErrorFile();
		boolean iStatus = writeInvalidFile();

		return (oStatus && eStatus && iStatus);
	}

	/**
	 * This method writes the Invalid employees
	 * 
	 * @return (boolean) true or false
	 */
	private boolean writeInvalidFile() {
		boolean status = false;

		// write each employee to File
		Iterator<Employee> empIter = invalidList.iterator();
		while (empIter.hasNext()) {
			if (!writeCSV(empIter.next(), "employee-invalid"))
				break; // failed to write some lines

			status = true; // if processed all employees
		}

		return status;
	}

	/**
	 * This method writes the employees
	 * 
	 * @return (boolean) true or false
	 */
	private boolean writeOutputFile() {
		boolean status = false;

		// write each employee to File
		Iterator<Employee> empIter = empList.iterator();
		while (empIter.hasNext()) {
			if (!writeCSV(empIter.next(), "employee"))
				break; // failed to write some lines

			status = true; // if processed all employees
		}

		return status;
	}

	/**
	 * This method writes the error
	 * 
	 * @return (boolean) true or false
	 */
	public boolean writeErrorFile() {
		boolean status = false;

		// write each employee to File
		Iterator<String> empIter = errList.iterator();
		if (!empIter.hasNext()) {
			return true;
		}
		while (empIter.hasNext()) {
			if (!writeCSV(empIter.next(), "error"))
				break; // failed to write some lines

			status = true; // if processed all employees
		}

		return status;
	}

	/**
	 * This method writes an individual employee object to a CSV file
	 * 
	 * @param temp
	 *            An employee object to be written
	 * @return flag Boolean values whether the CSV gets written or not
	 */
	public boolean writeCSV(Object temp, String type) {

		boolean flag = false;
		String writeToFile;

		if (type.equals("employee")) {
			writeToFile = outputFile;
		} else if(type.equals("employee-invalid")) {
			writeToFile = invalidFile;
		} else {
			writeToFile = errorFile;
		}

		FileWriter fw;
		try {
			File file = new File(writeToFile);

			if (file.exists()) {
				fw = new FileWriter(file, true); // if file exists append to file
			} else {
				file.createNewFile(); // create a new one if not present
				fw = new FileWriter(file);
			}

			if (type.equals("employee")) {
				Employee e = (Employee) temp;
				fw.append(e.toCSV()); // appending to file
			} else if (type.equals("employee-invalid")) {
				Employee e = (Employee) temp;
				fw.append(e.toCSV()); // appending to file
			} else {
				fw.append((String) temp); // appending to file
			}

			fw.append(NEW_LINE_SEPARATOR);

			fw.flush();
			fw.close();

			flag = true; // set the flag to true if completed successfully

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return flag;
	}

}
