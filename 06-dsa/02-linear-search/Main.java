public class Main {
	public static int LinearSearch(int[] arr, int target) {

		for (int i = 0; i < arr.length; i++){
			System.out.println("Checking: " + arr[i]);

			if(arr[i] == target){
				return i;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] numbers = { 12, 25, 18, 40, 55, 70 };
		int result = LinearSearch(numbers, 55);
		if(result != -1){
			System.out.println("Find at index: " + result);
		} else {
			System.out.println("Not Found");
		}
	}
}
