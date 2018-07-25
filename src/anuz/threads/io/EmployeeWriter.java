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
	private List<Employee> empList; 						// The list of valid employees
	private List<String> errList; 						// The list of valid employees
	private static final String NEW_LINE_SEPARATOR = "\n";	// New line generator
	private String outputFile = ""; 						// output File to be written		
	private String errorFile = ""; 							// error File to be written		

	/**
	 * Overloaded constructor - sets employees and the output file
	 * @param list 
	 * @param oFileName
	 */
	public EmployeeWriter(String oFileName, List<Employee> list, List<String> errList) {
		this.empList = list;	// setting the employees
		this.errList = errList; // corrupted data
		this.outputFile = EmployeeBatchTaskRunner.wPath + oFileName; // setting the filename, directory from taskRunner
		this.errorFile = EmployeeBatchTaskRunner.errPath + oFileName; // setting the filename, directory from taskRunner
		checkDirectory(); 		// creates the directory if not present
	}

	/**
	 * this method checks if the output directory exists or not, creates if not
	 */
	public void checkDirectory() {
		// create the output folder
		File directory = new File(String.valueOf(EmployeeBatchTaskRunner.wPath));
		if (!directory.exists()) { directory.mkdir(); }
		
		// create the error folder
		directory = new File(String.valueOf(EmployeeBatchTaskRunner.errPath));
		if (!directory.exists()) { directory.mkdir(); }
	}

	/**
	 * This method iterates over the employees and error list and writes to DB (Disk)
	 * @return
	 */
	public boolean writeFiles() {
		boolean oStatus = writeOutputFile();
		boolean eStatus = writeErrorFile();

		return (oStatus && eStatus);
	}
	
	/**
	 * This method writes the employees
	 * @return (boolean) true or false
	 */
	public boolean writeOutputFile() {
		boolean status = false;

		// write each employee to File
		Iterator<Employee> empIter = empList.iterator();
		while(empIter.hasNext()) {
			if( !writeCSV(empIter.next(), "employee") ) 
				break; // failed to write some lines
			
			status = true; //  if processed all employees 
		}

		return status;
	}
	
	/**
	 * This method writes the error
	 * @return (boolean) true or false
	 */
	public boolean writeErrorFile() {
		boolean status = false;

		// write each employee to File
		Iterator<String> empIter = errList.iterator();
		if(!empIter.hasNext()) { return true;}
		while(empIter.hasNext()) {
			if( !writeCSV(empIter.next(), "error") ) 
				break; // failed to write some lines
			
			status = true; //  if processed all employees 
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
		
		if(type.equals("employee")) { writeToFile = outputFile; }
		else { writeToFile = errorFile; }

		FileWriter fw;
		try {
			File file = new File(writeToFile);

			if (file.exists()) {
				fw = new FileWriter(file, true); // if file exists append to file
			} else {
				file.createNewFile(); 			 // create a new one if not present
				fw = new FileWriter(file);
			}
			
			if(type.equals("employee")) {
				temp = (Employee) temp;
				//fw.append(temp.toCSV()); 			 // appending to file
			}else {
				fw.append((String) temp); 			 // appending to file
			}
			
			fw.append(NEW_LINE_SEPARATOR);

			fw.flush();
			fw.close();

			flag = true;						// set the flag to true if completed successfully

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return flag;
	}

}
