
package anuz.threads.io;

import java.io.File;
import java.nio.file.Path;

/**
 * @author anz
 *
 */
public class EmployeeFileProcessorJob implements Runnable {
	
	private File file;
	
	public EmployeeFileProcessorJob(Path file) {
		this.file = file.toFile();
	}

	@Override
	public void run() {
		// A single batch job
		System.out.println(file + " Thread");
		
		EmployeeBatchTask jobInstance = new EmployeeBatchTaskRunner(file);
		jobInstance.readFiles();
		jobInstance.validateData();
		jobInstance.storeToDB();
	}

}
