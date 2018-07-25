
package anuz.threads.io;

import java.io.File;
import java.nio.file.Path;

/**
 * @author anz
 *
 */
public class EmployeeFileProcessorJob implements Runnable {
	
	private File file; // the file a thread handles
	
	/**
	 * Overloaded constructor
	 * @param file
	 */
	public EmployeeFileProcessorJob(Path file) {
		this.file = file.toFile();
	}

	/**
	 * This method is the main point of thread execution
	 */
	@Override
	public void run() {
		// A single batch job
		System.out.println(file + " Thread");
		
		
		// create the batchJob instance and pass the file
		EmployeeBatchTask jobInstance = new EmployeeBatchTaskRunner(file);
		jobInstance.readFiles();
		jobInstance.validateData();
		jobInstance.storeToDB();
	}

}
