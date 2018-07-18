package anuz.interfaceEx.employeeOpPayment;

public class EmployeeOp implements EmployeeOpInterface {

	@Override
	public Employee createEmployee(int id, String name, double salary, String gender) {
		return new Employee(id, name, salary, gender);
	}

	@Override
	public Employee[] deleteEmployee(Employee[] e, int id) {
		for (int i = 0; i < e.length; i++) {
			if (e[i].getId() == id) {
				e[i] = null;
			}
		}

		return e;
	}

	@Override
	public Employee[] updateEmployee(Employee[] e, int id, String name, double salary, String gender) {
		for (int i = 0; i < e.length; i++) {
			if (e[i].getId() == id) {
				e[i].setName(name);
				e[i].setSalary(salary);
				e[i].setGender(gender);
			}
		}

		return e;
	}

	@Override
	public Employee readEmployee(Employee[] e, int id) {
		for (Employee temp : e) {
			if (temp.getId() == id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public double calculateGrossSalary(Employee[] e) {
		double grossSalary = 0;
		for (Employee temp : e) {
			grossSalary += temp.getSalary();
		}
		return grossSalary;
	}

	@Override
	public double calculateHRA(Employee[] e) {
		double grossHRA = 0;
		for (Employee temp : e) {
			grossHRA += temp.getSalary() * Employee.reimburseHRA * 12;
		}
		return grossHRA;
	}
}
