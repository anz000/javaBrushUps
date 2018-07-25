package anuz.threads.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author anz
 *
 */
public class Application {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		// get the files list
		List<Path> filesList = getFilesList("raw"); // set the input directory path here
		
		// create the executor with the thread pool
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i=0 ; i<filesList.size() ; i++) {
			// create the thread instance
			EmployeeFileProcessorJob employeeFileProcessorJob = new EmployeeFileProcessorJob(filesList.get(i));
			
			//pass it to executorService
			executorService.execute(employeeFileProcessorJob);
			
		}
		
		// close the executorSerive once done.
		executorService.shutdown();

	}
	
	/**
	 * This method scans the given path and returns all the list of files
	 * @param path
	 * @return
	 */
	public static List<Path> getFilesList(String path) {
		List<Path> list = null;
		try (Stream<Path> paths = Files.walk(Paths.get(path))) {
		    list = paths
		        .filter(Files::isRegularFile)
		        .collect(Collectors.toList());
		        //.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println(" Exception : Issue getting files ");
		}
		
		if(list == null) {
			System.out.println("No Files to Read. Exiting...");
			
			System.exit(0);
		}
		
		return list;
	}

}
