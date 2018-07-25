package anuz.threads.io;

import java.io.File;
import java.util.List;

public class EmployeeBatchTaskRunner implements EmployeeBatchTask{
	
	/**
	 * Class variable instances
	 */
	private List<Employee> empList;			// The employee list 
	private File file;						// The file that contains the data 
	public static String wPath = "output/";	// The output folder where the successful records are written, set it here
	
	/**
	 * Overloaded Constructor 
	 * @param file The file handled by a thread
	 */
	public EmployeeBatchTaskRunner(File file) {
		this.file = file;
	}

	/**
	 * This method takes in a file and converts them to objects
	 */
	@Override
	public void readFiles() {
		EmployeeReader eReader = new EmployeeReader(file);
		empList = eReader.readEmployees();
	}

	/**
	 * This method takes in the employee list and 
	 * applies business logic for validating the employees 
	 */
	@Override
	public void validateData() {
		// @ToDo
		EmployeeValidator eValidator = new EmployeeValidator(empList);
		eValidator.runValidator();
		
	}

	/**
	 * This method writes the validated employees to DB (Disk)
	 */
	@Override
	public void storeToDB() {
		EmployeeWriter eWrite = new EmployeeWriter(empList, file.getName());
		boolean saveEmployees = eWrite.writeFiles();
		if(!saveEmployees) {
			System.out.println("Issue writing files " + file);
		}
	}

}
