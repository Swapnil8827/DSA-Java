package array;


import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//Find the "Kth" max and min element of an array
public class KthMaxMinElementOfArray {

    static class Pair {
        int min;
        int max;
    }

    public static Pair getKthMinMax(int[] arr1, int k) {
        Pair minMax = new Pair();
        int[] arr = arr1;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        minMax.min = arr[k - 1];
        minMax.max = arr[arr.length - k];

        return minMax;
    }

    public static int getKthMax(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k; i++)
            queue.add(arr[i]);

        for (int i = k; i < arr.length; i++) {

            if (queue.peek() < arr[i]) {
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return queue.peek();
    }

    private static int getKthMin(int[] arr, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(arr[i]);
        }


        for (int i = k; i < arr.length; i++){
            if(queue.peek() > arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        int arr[] = { 82, 789,12, 3, 5, 7, 19, 64};

        Pair minmax = getKthMinMax(arr, 3);
        System.out.println("Minimum Kth element is " + minmax.min);
        System.out.println("Maximum Kth element is " + minmax.max);

        System.out.println("Maximum Kth element is " +getKthMax(arr, 3));
        System.out.println("Minimum Kth element is " +getKthMin(arr, 3));

    }


}
