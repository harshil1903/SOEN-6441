import java.util.Scanner;

public class SortDriver {
	public static void main(String[] args) {
		SortArray arraySorter = new SortArray();
		int arr[] = new int[100];
		Scanner scanner;
		scanner = new Scanner(System.in);
		System.out.println("(0) \tquit \n(1) \tquicksort \n(2) \tbubble sort \n(3) \tmerge sort \n(other)\tno sort: ");
		int myint = scanner.nextInt();
		while (myint != 0) {
			arraySorter.readFromFile(arr);
			arraySorter.setSorter(myint);
			arraySorter.sort(arr);
			System.out.println("Sorted array: ");
			arraySorter.printArray(arr, arr.length);
			System.out.println("(0) \tquit \n(1) \tquicksort \n(2) \tbubble sort \n(3) \tmerge sort \n(other)\tno sort: ");
			myint = scanner.nextInt();
		}
		scanner.close();
	}
}
