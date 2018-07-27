package anuz.jdbc.employeeDAO;

@SuppressWarnings("serial")
public class InvalidSalaryException extends Exception{
	public InvalidSalaryException( String s ) {
		super(s);
	}
}
