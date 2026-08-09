class Student {

	private Long id;
	private String name;

	public Student(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public void display() {
		System.out.println("Student Info:" + " " + id + " - " + name);
	}
}

public class Main {

    public static void main(String[] args) {

        Student student = new Student(101L, "Rahim");

        student.display();
    }
}
