package sorting;

public class BucketSort {
    public static void bucketSort(int[] arr, int bucketCount) {
        if (arr.length == 0) return;

        // Find the maximum and minimum values in the array
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int num : arr) {
            if (num < minValue) minValue = num;
            if (num > maxValue) maxValue = num;
        }

        // Initialize buckets
        int bucketRange = (maxValue - minValue) / bucketCount + 1;
        int[][] buckets = new int[bucketCount][];
        int[] bucketSizes = new int[bucketCount];

        // Distribute input array values into buckets
        for (int num : arr) {
            int bucketIndex = (num - minValue) / bucketRange;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new int[1];
            } else if (bucketSizes[bucketIndex] == buckets[bucketIndex].length) {
                // Resize bucket if necessary
                int[] newBucket = new int[buckets[bucketIndex].length * 2];
                System.arraycopy(buckets[bucketIndex], 0, newBucket, 0, buckets[bucketIndex].length);
                buckets[bucketIndex] = newBucket;
            }
            buckets[bucketIndex][bucketSizes[bucketIndex]++] = num;
        }

        // Sort each bucket and concatenate results
        int index = 0;
        for (int i = 0; i < bucketCount; i++) {
            if (buckets[i] != null) {
                insertionSort(buckets[i], bucketSizes[i]);
                for (int j = 0; j < bucketSizes[i]; j++) {
                    arr[index++] = buckets[i][j];
                }
            }
        }
    }

    private static void insertionSort(int[] arr, int length) {
        for (int i = 1; i < length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] arr = {29, 25, 3, 49, 9, 37, 21, 43};
        int bucketCount = 4;
        bucketSort(arr, bucketCount);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}