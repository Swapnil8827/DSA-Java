package array;
//Q)Find the maximum and minimum element in an array
public class FindMaximumMinimumInArray {

    static class Pair{
        int min;
        int max;
    }

    public static Pair getMinMax(int[] arr, int n){
        Pair minMax = new Pair();

        if(n==1){
            minMax.min=arr[0];
            minMax.max=arr[0];
        return minMax;
        }

        if(arr[0]>arr[1]){
            minMax.min = arr[1];
            minMax.max = arr[0];
        }
        else{
            minMax.min = arr[0];
            minMax.max = arr[1];
        }

        for(int i =2; i<n;i++){
            if(arr[i]> minMax.max)
                minMax.max = arr[i];

           else if(arr[i]< minMax.min)
                minMax.min = arr[i];
        }

        return minMax;
    }

    public static Pair getMinMaxRcur(int[] arr, int low, int high){

        Pair minMax = new Pair();
        Pair mml = new Pair();
        Pair mmr = new Pair();
        int mid;

        if(low==high) {
            minMax.min = arr[low];
            minMax.max = arr[low];

            return minMax;
        }

        if(high == low+1){
            if(arr[high]>arr[low]){
                minMax.min = arr[low];
                minMax.max = arr[high];
            }

            else{
                minMax.max = arr[low];
                minMax.min = arr[high];
            }
        }

        mid = (low+high)/2;
        mml = getMinMaxRcur(arr, low, mid);
        mmr = getMinMaxRcur(arr, mid+1, high);

        /* compare minimums of two parts*/
        if (mml.min < mmr.min) {
            minMax.min = mml.min;
        } else {
            minMax.min = mmr.min;
        }

        /* compare maximums of two parts*/
        if (mml.max > mmr.max) {
            minMax.max = mml.max;
        } else {
            minMax.max = mmr.max;
        }

        return minMax;
    }


    public static void main(String[] args) {
        int arr[] = {1000, 11, 445, 1, 330, 3000};
        int arr_size = 6;
        Pair minmax = getMinMax(arr, arr_size);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

        minmax = getMinMaxRcur(arr,0, arr_size-1);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);

    }
}
