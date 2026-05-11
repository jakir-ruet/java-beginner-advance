// Parent class
class Employee {
	String name;
	double salary;

	void work() {
		System.out.println(name + " is working");
	}
}

// Child class for Developer
class Developer extends Employee {
	void writeCode() {
		System.err.println(name + " is writing Java code");
	}
}

// Child class for Manager
class Manager extends Employee {
	void manageTead() {
		System.err.println(name + " is managing the team");
	}
}

// Main class
public class Main {

	public static void main(String[] args) {
		// Create developer object
		Developer dev = new Developer();
		System.out.println("--------Developer---------");
		dev.name = "Jakir";
		dev.salary = 85000;

		dev.work();
		dev.writeCode();

		System.out.println("Salary " + dev.salary);

		System.out.println("---------Manager---------");

		// Create Manager object
		Manager mgr = new Manager();
		mgr.name = "Rahim";
		mgr.salary = 95000;

		mgr.work();
		mgr.manageTead();

		System.out.println("Salary " + mgr.salary);
		System.out.println("------------------------");
	}
}
