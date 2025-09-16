package sorting;

/*
 Shell Sort implementation in Java
Time Complexity: O(n log n) on average, O(n^2) in the worst case
Space Complexity: O(1) - In-place sorting algorithm
It is an optimization over Insertion Sort that allows the exchange of items that are far apart.
It starts by sorting elements far apart from each other and progressively reducing the gap between elements
 to be compared. This allows elements to move closer to their final position faster.*/


public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 54, 2, 3};
        shellSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
