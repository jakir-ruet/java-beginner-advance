public class myMulArray {
	static void myMulArray() {
		// Create a 3x3 matrix
		int[][] myAarry = {
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 }
		};
			// ACCESSING elements
        	System.out.println("Element at row 1, col 2 = " + myAarry[1][2]);  // 6
			System.out.println("Element at row 0, col 0 = " + myAarry[0][0]); // 1

		   // MODIFYING elements
        	myAarry[1][2] = 100;
			myAarry[0][0] = 900;

			// ACCESSING elements
			System.out.println("Element at row 1, col 2 = " + myAarry[1][2]);  // 100
			System.out.println("Element at row 0, col 0 = " + myAarry[0][0]); // 900

			// traversing the 2D array
			System.out.println("Traversing the 2D array:");
			for (int i = 0; i < myAarry.length; i++) {
				for (int j = 0; j < myAarry[i].length; j++) {
					System.out.print(myAarry[i][j] + " ");
				}
				System.out.println();
			}
	}

	public static void main(String[] args) {
		myMulArray();
	}
}
