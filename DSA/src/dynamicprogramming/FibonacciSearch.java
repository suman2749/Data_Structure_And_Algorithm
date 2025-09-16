package dynamicprogramming;

/*Similar to binary search but uses Fibonacci numbers to divide the array into sections.
Effective for arrays where division operations are more expensive than addition/subtraction.
Time Complexity: O(log n).*/

//-----------------------------------------------------------------------------------
// Fibonacci Search Algorithm
// 1. Generate Fibonacci numbers until the generated number is greater than or equal to the length of the array.
// 2. Use these Fibonacci numbers to divide the array into sections and perform comparisons.
// 3. Adjust the search range based on the comparisons until the target is found or the range is exhausted.
//-----------------------------------------------------------------------------------

public class FibonacciSearch {
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        int fibM2 = 0; // (m-2)'th Fibonacci number
        int fibM1 = 1; // (m-1)'th Fibonacci number
        int fibM = fibM2 + fibM1; // m'th Fibonacci number

        while (fibM < n) {
            fibM2 = fibM1;
            fibM1 = fibM;
            fibM = fibM2 + fibM1;
        }

        int offset = -1;

        while (fibM > 1) {
            int i = Math.min(offset + fibM2, n - 1);

            if (arr[i] < target) {
                fibM = fibM1;
                fibM1 = fibM2;
                fibM2 = fibM - fibM1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibM2;
                fibM1 = fibM1 - fibM2;
                fibM2 = fibM - fibM1;
            } else {
                return i; // Target found at index i
            }
        }

        if (fibM1 == 1 && offset + 1 < n && arr[offset + 1] == target) {
            return offset + 1; // Target found at index offset + 1
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100};
        int target = 85;
        int result = fibonacciSearch(arr, target);
        if (result == -1) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }
}
