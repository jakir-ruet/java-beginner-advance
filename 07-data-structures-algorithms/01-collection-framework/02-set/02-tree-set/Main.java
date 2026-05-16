import java.util.TreeSet;

class StudentRankingSystem {
	private static TreeSet<Integer> students = new TreeSet<>();
	// Add student score to the system
	public static void addStudent(int score) {
		if (students.add(score)) {
			System.out.println("Added student with score: " + score);
		} else {
			System.out.println("Student with score " + score + " already exists.");
		}
	}
	// Get the all student scores in sorted order
	public static void displayStudentScores() {
		System.out.println("Student Scores in sorted order: " + students);
	}

	// Get the highest score
	public static void displayHighestScore() {
		if (!students.isEmpty()) {
			System.out.println("Highest Score: " + students.last());
		} else {
			System.out.println("No students in the system.");
		}
	}
	// Get the lowest score
	public static void displayLowestScore() {
		if (!students.isEmpty()) {
			System.out.println("Lowest Score: " + students.first());
		} else {
			System.out.println("No students in the system.");
		}
	}
}
public class Main {
	public static void main(String[] args) {
		StudentRankingSystem.addStudent(85);
		StudentRankingSystem.addStudent(92);
		StudentRankingSystem.addStudent(78);
		StudentRankingSystem.addStudent(85); // Duplicate score
		StudentRankingSystem.displayStudentScores();
		StudentRankingSystem.displayHighestScore();
		StudentRankingSystem.displayLowestScore();
	}
}
