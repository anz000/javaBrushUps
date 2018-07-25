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

	private List<Employee> empList;
	private static final String NEW_LINE_SEPARATOR = "\n";
	private String outputFile = ""; // output File

	public EmployeeWriter(List<Employee> list, String oFileName) {
		this.empList = list;
		this.outputFile = EmployeeBatchTaskRunner.wPath + oFileName;

		checkDirectory();
	}

	public void checkDirectory() {
		File directory = new File(String.valueOf(EmployeeBatchTaskRunner.wPath));
		if (!directory.exists()) {
			directory.mkdir();
			//System.out.println("Output Directory succesfully created.");
		}
	}

	public boolean writeFiles() {
		boolean status = false;

		// write each employee to File
		Iterator<Employee> empIter = empList.iterator();
		while(empIter.hasNext()) {
			if( !writeCSV(empIter.next()) ) 
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
	public boolean writeCSV(Employee temp) {
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

			flag = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
		return flag;
	}

}
