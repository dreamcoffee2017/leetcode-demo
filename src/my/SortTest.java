package my;

import java.util.Arrays;

public class SortTest {
    static int c = 0;

    public static void main(String[] args) {
        int[] a = { 1, 4, 5, 6, 7, 8, 10, 222 };
        new SortTest().bubbleSort(a);
        // .mergeSort(a);
        // .quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
        System.out.println(new SortTest().binarySearch(a, 222));
        System.out.println(c);
    }

    void bubbleSort(int[] arr) {
        for (int len = arr.length - 1; len > 0; len--) {
            for (int i = 0; i < len; i++) {
                c++;
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
    }

    void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftArr = Arrays.copyOf(arr, mid);
            int[] rightArr = Arrays.copyOfRange(arr, mid, arr.length);
            mergeSort(leftArr);
            mergeSort(rightArr);
            int i = 0, j = 0, k = 0;
            while (i < leftArr.length && j < rightArr.length) {
                c++;
                if (leftArr[i] < rightArr[j]) {
                    arr[k++] = leftArr[i++];
                } else {
                    arr[k++] = rightArr[j++];
                }
            }
            while (i < leftArr.length) {
                c++;
                arr[k++] = leftArr[i++];
            }
            while (j < rightArr.length) {
                c++;
                arr[k++] = rightArr[j++];
            }
        }
    }

    void quickSort(int[] arr, int first, int last) {
        if (first < last) {
            int pivotIdx = partition(arr, first, last);
            quickSort(arr, first, pivotIdx - 1);
            quickSort(arr, pivotIdx + 1, last);
        }
    }

    private int partition(int[] arr, int first, int last) {
        int pivot = arr[first];
        int lower = first + 1;
        int upper = last;
        boolean done = false;
        while (!done) {
            while (lower <= upper && pivot >= arr[lower]) {
                c++;
                lower++;
            }
            while (lower <= upper && pivot <= arr[upper]) {
                c++;
                upper--;
            }
            if (lower > upper) {
                done = true;
            } else {
                int tmp = arr[lower];
                arr[lower] = arr[upper];
                arr[upper] = tmp;
            }
        }
        arr[first] = arr[upper];
        arr[upper] = pivot;
        return upper;
    }

    Integer binarySearch(int[] arr, int item) {
        int lower = 0, upper = arr.length - 1;
        while (lower <= upper) {
            c++;
            int mid = (lower + upper) / 2;
            if (arr[mid] == item) {
                return mid;
            }
            if (item < arr[mid]) {
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return null;
    }
}
