package searching;


// This class provides a method to search for a sublist within a main list.
// It returns the starting index of the sublist if found, otherwise returns -1.
// Time Complexity: O(n*m) in the worst case, where n is the length of the main list and m is the length of the sublist.


public class SublistSearch {
    public static int sublistSearch(int[] mainList, int[] subList) {
        int mainLength = mainList.length;
        int subLength = subList.length;

        for (int i = 0; i <= mainLength - subLength; i++) {
            int j;
            for (j = 0; j < subLength; j++) {
                if (mainList[i + j] != subList[j]) {
                    break;
                }
            }
            if (j == subLength) {
                return i; // Sublist found at index i
            }
        }
        return -1; // Sublist not found
    }

    public static void main(String[] args) {
        int[] mainList = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] subList = {4, 5, 6};
        int result = sublistSearch(mainList, subList);
        if (result == -1) {
            System.out.println("Sublist not present in main list");
        } else {
            System.out.println("Sublist found at index: " + result);
        }
    }
}
