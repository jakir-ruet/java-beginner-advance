
import java.util.ArrayList;
import java.util.List;

public class Main {

	public List<Integer> givenNumber() {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		return numbers;
	}

	public List<Integer> evenNumber(List<Integer> numbers) {

        List<Integer> evenNumbers = new ArrayList<>();

        for (Integer n : numbers) {
            if (n % 2 == 0) {
                evenNumbers.add(n);
            }
        }

        return evenNumbers;
    }

	public static void main(String[] args) {
		Main main = new Main();

        List<Integer> numbers = main.givenNumber();

        List<Integer> evenNumbers =
                main.evenNumber(numbers);

        System.out.println("Numbers: " + numbers);
        System.out.println("Even Numbers: " + evenNumbers);
	}
}
