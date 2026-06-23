// A method used to read private variable value.
// A method used to assign/update private variable value.

class Employee {
	// private variable
	private double salary;

	// setter
	public void setSalary(double s) {
		salary = s;
	}

	// getter
	public double getSalary() {
		return salary;
	}
}

public class Main {
	public static void main(String[] args) {
		Employee e = new Employee();

		// set value
		e.setSalary(56000);
		
		// get value
		System.out.println(e.getSalary());
	}
}
