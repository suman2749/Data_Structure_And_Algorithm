package searching;

/*A variation of binary search for sorted arrays.
Estimates the position of the target value based on its value relative to the lowest and highest values in the search range, similar to how one might look up a name in a phone book.
Time Complexity: O(log log n) on average for uniformly distributed data, but can degrade to O(n) in the worst case.*/


public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            if (low == high) {
                if (arr[low] == target) return low;
                return -1;
            }

            // Probing the position with keeping uniform distribution in mind.
            int pos = low + ((target - arr[low]) * (high - low)) / (arr[high] - arr[low]);

            if (arr[pos] == target) {
                return pos; // Target found at index pos
            }
            if (arr[pos] < target) {
                low = pos + 1; // Target is in upper part
            } else {
                high = pos - 1; // Target is in lower part
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int target = 30;
        int result = interpolationSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
