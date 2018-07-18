package anuz.relationship.employees;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		// creating a sample Employee - Manager
		
		Gender g1 = new Gender();
		g1.getGender();
		
		Address address1 = new Address("Dallas","USA",1,"46578","TX","McArthur",(long) 3);
		
		List<PhoneNumber> ph1 = new ArrayList<>();
		ph1.add ( new PhoneNumber("TX", "7834561324", new Employee(), "CellPhone", 2 ));
		ph1.add ( new PhoneNumber("ND", "7231453241", new Employee(), "LandLine", 2 ));
		
		EmploymentPeriod employmentPeriod1 = new EmploymentPeriod(Calendar.getInstance(), Calendar.getInstance());

		// creating a manager
		Employee manager = new Employee(
				address1, "Manohar",g1,1,"Singh", // add,name, gender,id,lname
				null, //list-managedEmployees 
				null, //manager
				employmentPeriod1, //period
				ph1, //list-phones
				null,//list-responsibilities
				4100.00,//salary
				(long) 2.0 //version
		);
		
//		System.out.println("The sample Employee detail is : " + manager);
		
		// creating a clerk
		Employee clerk = new Employee(
				address1, "Anuj",g1,20,"Shrestha", // add,name, gender,id,lname
				null, //list-managedEmployees 
				manager, //manager
				employmentPeriod1, //period
				ph1, //list-phones
				null,//list-responsibilities
				2500.00,//salary
				(long) 3.0 //version
		);
		
		// creating a developer
		Employee developer = new Employee(
				address1, "John",g1,5,"Smith", // add,name, gender,id,lname
				null, //list-managedEmployees 
				manager, //manager
				employmentPeriod1, //period
				ph1, //list-phones
				null,//list-responsibilities
				3500.00,//salary
				(long)1.0 //version
		);
		
		List<Employee> lstManagedEmployees = new ArrayList<>();
		lstManagedEmployees.add(clerk);
		lstManagedEmployees.add(developer);
		
		manager.setManagedEmployees(lstManagedEmployees);
		
		System.out.println("**************************");
//		System.out.println("The sample Employee detail is : " + manager);
		
		System.out.println("**************************");
//		System.out.println("The sample Employee detail is : " + clerk);
		
		
		//System.out.println(manager.getAddress().getCountry()); // Lombok Call
		
		
		
	}
}
