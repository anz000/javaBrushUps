package anuz.threads.io;

public interface EmployeeBatchTask {
	/**
	 * This method takes in a file and converts them to objects
	 */
	public void readFiles();
	
	/**
	 * This files takes in a list and validates them with business logic
	 */
	public void validateData();
	
	/**
	 * This method stores the objects to DB (Files)
	 */
	public void storeToDB();

}
