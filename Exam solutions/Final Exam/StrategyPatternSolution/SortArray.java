import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class that includes quicksort, mergesort and bubblesort
 */
class SortArray {
	private SortStrategy d_sortStrategy;

	///////////////////////////////
	// GENERAL UTILITY FUNCTIONS //
	///////////////////////////////
	
	public void setSorter(int answer) {
		switch (answer) {
		case 1:
			d_sortStrategy = new QuickSort();
			break;
		case 2:
			d_sortStrategy = new BubbleSort();
			break;
		case 3:
			d_sortStrategy = new MergeSort();
			break;
		default:
			d_sortStrategy = new SortStrategy();
			break;
		}
	}

	public void sort(int[] arr) {
			d_sortStrategy.sort(arr);
	}

	public void readFromFile(int[] arr) {
		int index = 0;
		Scanner scanner;

		try {
			scanner = new Scanner(new File("numbers.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("File cannot be opened. Aborting.");
			return;
		}
		while (scanner.hasNext()) {
			if (scanner.hasNextInt()) {
				arr[index] = scanner.nextInt();
			} else {
				scanner.next();
			}
			index++;
		}
		scanner.close();
	}
	
	void printArray(int[] arr, int size) {
		for (int i = 1; i <= size; i++) {
			System.out.print(arr[i - 1] + " ");
			if (i % 5 == 0)
				System.out.println();
		}
		System.out.println();
	}
}
