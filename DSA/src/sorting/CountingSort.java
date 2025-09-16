package sorting;

public class CountingSort {
    public static void countingSort(int[] arr) {
        int n = arr.length;
        if (n == 0) return;

        // Find the maximum element in the array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Create a count array to store the count of each unique object
        int[] count = new int[max + 1];

        // Store the count of each number
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Modify the count array such that each element at each index
        // stores the sum of previous counts. This gives the position of
        // each number in the output array.
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements into original array
        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        countingSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
