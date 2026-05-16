import java.util.TreeMap;

class StudentTreeMap {

    // Name -> Marks (sorted by name automatically)
    TreeMap<String, Integer> studentMarks = new TreeMap<>();

    // Add student
    public void addStudent(String name, int marks) {

        studentMarks.put(name, marks);

        System.out.println("===== Added Student =====");
        System.out.println(studentMarks);
        System.out.println();
    }

    // Get marks
    public Integer getMarks(String name) {

        return studentMarks.get(name);
    }
}

public class Main {

    public static void main(String[] args) {

        StudentTreeMap studentTreeMap = new StudentTreeMap();

        studentTreeMap.addStudent("Alice", 85);
        studentTreeMap.addStudent("Bob", 92);
        studentTreeMap.addStudent("Charlie", 78);

        System.out.println("Alice's marks: " +
                studentTreeMap.getMarks("Alice"));

        System.out.println("Bob's marks: " +
                studentTreeMap.getMarks("Bob"));

        System.out.println("Charlie's marks: " +
                studentTreeMap.getMarks("Charlie"));
    }
}
