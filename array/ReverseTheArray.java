package array;

import java.util.Arrays;

public class ReverseTheArray {


    public static void reverseArray(int[] arr, int start, int end){

        int temp;
        while(start<end){
            temp=arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

    }


    public static void reverseArrayRcur(int[] arr, int start, int end){

        if(start >= end) return;

        int temp;

        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        start++;
        end--;

        reverseArrayRcur(arr, start, end);

    }

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5,6,7,8};

        reverseArray(arr, 0,7);
        System.out.println(Arrays.toString(arr));

        reverseArrayRcur(arr, 0,7);
        System.out.println(Arrays.toString(arr));

    }

}
