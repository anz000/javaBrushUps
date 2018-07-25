package anuz.threads.io;

import java.io.File;
import java.util.List;

public class EmployeeBatchTaskRunner implements EmployeeBatchTask{
	
	private List<Employee> empList;
	private File file;
	public static String wPath = "output/";
	
	public EmployeeBatchTaskRunner(File file) {
		this.file = file;
	}

	@Override
	public void readFiles() {
		EmployeeReader eReader = new EmployeeReader(file);
		empList = eReader.readEmployees();
	}

	@Override
	public void validateData() {
		// @ToDo
		EmployeeValidator eValidator = new EmployeeValidator(empList);
		eValidator.runValidator();
		
	}

	@Override
	public void storeToDB() {
		EmployeeWriter eWrite = new EmployeeWriter(empList, file.getName());
		boolean saveEmployees = eWrite.writeFiles();
		if(!saveEmployees) {
			System.out.println("Issue writing files " + file);
		}
	}

}
