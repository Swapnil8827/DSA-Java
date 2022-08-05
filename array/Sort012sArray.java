package array;

import java.util.Arrays;

// Q) Given an array which consists of only 0, 1 and 2. Sort the array without
//    using any sorting algo.
public class Sort012sArray {

    private static void sort012(int[] arr, int arr_size) {

        var low = 0;
        var mid = 0;
        var high = arr_size - 1;
        var temp = 0;

        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    mid++;
                    low++;
                }

                case 1 -> {
                    mid++;
                }

                case 2 ->{
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 1, 2, 1, 2,2,2, 0, 0, 0,0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);

        System.out.println(Arrays.toString(arr));
    }
}
