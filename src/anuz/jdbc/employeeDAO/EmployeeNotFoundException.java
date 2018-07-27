package anuz.jdbc.employeeDAO;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception{
	public EmployeeNotFoundException( String s ) {
		super(s);
	}
}
