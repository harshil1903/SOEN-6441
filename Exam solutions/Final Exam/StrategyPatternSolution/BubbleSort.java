public class BubbleSort extends SortStrategy{

    protected void sort(int[] p_array){
        System.out.println("BubbleSort");
        bubbleSorter(p_array);
    }

    void bubbleSorter(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
    }
}
