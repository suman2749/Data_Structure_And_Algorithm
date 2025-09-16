package searching;

/*Suitable for unbounded or infinite arrays, or when the size of the array is unknown.
Finds a range where the element might be present and then performs a binary search within that range.
Time Complexity: O(log i), where i is the position of the element.*/

public class ExponentialSearch {
    public static int binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    public static int exponentialSearch(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }
        int i = 1;
        while (i < arr.length && arr[i] <= target) {
            i = i * 2;
        }
        return binarySearch(arr, i / 2, Math.min(i, arr.length - 1), target);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40, 50, 60, 70, 80};
        int target = 10;
        int result = exponentialSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
