package anuz.io.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Application {

	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		String oFile = "customer.dat";

		Address theAddress = new Address("1736 10th Street", "175", "Fargo", "ND");
		Customer theCustomer = new Customer(1, "Anuj", "Shrestha", theAddress);

		serialize(theCustomer, oFile);

		deserialize(oFile);
	}

	/**
	 * This method serializes the object to a file
	 * @param theCustomer a customer object 
	 * @param oFile file to be written
	 * @return boolean flag whether the operation was successful or not
	 */
	public static boolean serialize(Customer theCustomer, String oFile) {
		boolean flag = false;
		try (FileOutputStream foStream = new FileOutputStream(new File(oFile));
				ObjectOutputStream ooStream = new ObjectOutputStream(foStream)) {
			ooStream.writeObject(theCustomer);
			ooStream.flush();

			flag = true;
			System.out.println("The object has been serialized. Details \n" + theCustomer);
			System.out.println();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}

	/**
	 * This method deserializes the file into an object
	 * @param iFile The serialized file
	 * @return The customer object
	 */
	public static Customer deserialize(String iFile) {
		Customer tempCustomer = null;
		try (FileInputStream fiStream = new FileInputStream(new File(iFile));
				ObjectInputStream oiStream = new ObjectInputStream(fiStream)) {
			tempCustomer = (Customer) oiStream.readObject();					// type-casted
			System.out.println("The object has been de-serialized. Details \n " + tempCustomer);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tempCustomer;
	}
}
