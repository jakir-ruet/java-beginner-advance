
import java.util.HashMap;

class EmployeeHashMap {
	HashMap<Integer, String> employeeMap = new HashMap<>();

	// Add employee to the map
	public void addEmployee(int id, String name) {
		employeeMap.put(id, name);
		System.out.println("Added Employee: ID = " + id + ", Name = " + name);
		System.out.println("Current Employees: " + employeeMap);
		System.out.println("-----------------------------");
	}
	// Get employee by ID
	public void getEmployee(int id) {
		if(employeeMap.containsKey(id)) {
			System.out.println("Employee Found: ID = " + id + ", Name = " + employeeMap.get(id));
		} else {
			System.out.println("Employee with ID " + id + " not found.");
		}
		System.out.println("");
	}
}
public class Main {
	public static void main(String[] args) {
		EmployeeHashMap employeeHashMap = new EmployeeHashMap();

		// Adding employees to the HashMap
		employeeHashMap.addEmployee(100, "John Doe");
		employeeHashMap.addEmployee(200, "Jane Smith");
		employeeHashMap.addEmployee(300, "Alice Johnson");

		// Retrieving employees by ID
		employeeHashMap.getEmployee(100);
		employeeHashMap.getEmployee(200);

		// Attempting to retrieve an employee that does not exist
		employeeHashMap.getEmployee(400);
	}
}
