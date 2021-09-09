import java.util.Arrays;

/* Problem Name is &&& Median Two Sorted Arrays &&& PLEASE DO NOT REMOVE THIS LINE. */

/**
 * Instructions to candidate.
 * 1) Run this code in the REPL to observe its behaviour. The
 * execution entry point is main().
 * 2) Find the median of the two sorted arrays.
 */

public class Solution {
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int[] mergedArray = mergeArrays(A, B);

        Arrays.sort(mergedArray);
        return findMedian(mergedArray);
    }

    private static int[] mergeArrays(int[] A, int[] B) {
        int[] mergedArray = new int[A.length + B.length];

        int mergedIndex = 0;

        for (int i = 0; i < A.length; i++) {
            mergedArray[mergedIndex] = A[i];
            mergedIndex++;
        }

        for (int j = 0; j < B.length; j++) {
            mergedArray[mergedIndex] = B[j];
            mergedIndex++;
        }
        return mergedArray;
    }

    public static double findMedian(int[] sortedArr) {

        int length = sortedArr.length;
        double median;
        if (length % 2 == 0) {
            int index1 = length / 2;
            int index2 = index1 + 1;
            //index -1 because array index starts with o
            median = (sortedArr[index1 - 1] + sortedArr[index2 - 1]) / 2.0;
        } else {
            int index = (length / 2) + 1;
            median = sortedArr[index - 1];
        }

        return median;
    }

    /**
     * boolean doTestsPass()
     * Returns true if all tests pass. Otherwise returns false.
     */
    public static boolean doTestsPass() {
        // todo: implement more tests, please
        boolean result = true;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}) == 2.5;
        result = result && findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2.0;
        return result;
    }

    /**
     * Execution entry point.
     */
    public static void main(String[] args) {
        if (doTestsPass()) {
            System.out.println("All tests pass");
        } else {
            System.out.println("There are test failures");
        }
    }
}