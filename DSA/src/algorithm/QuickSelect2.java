package algorithm;

public class QuickSelect2 {
    public static int quickSelect(int[] arr, int low, int high, int k) {
        if (low <= high) {
            int pi = partition(arr, low, high);

            if (pi == k) return arr[pi];
            else if (pi > k) return quickSelect(arr, low, pi - 1, k);
            else return quickSelect(arr, pi + 1, high, k);
        }
        return Integer.MAX_VALUE;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 8, 6, 11, 26};
        int k = 3; // find 3rd smallest
        System.out.println(k + "rd smallest element is " +
                quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}
