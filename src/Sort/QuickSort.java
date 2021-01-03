package Sort;

/**
 * @author: Xie
 * @Description: TODO
 * @Contact: qq307954865
 * @Date: 2020/12/9 16:02
 */
public class QuickSort {
    public static void main(String[] args){
        int[] arr = {3,2,5,9,5,6};
        QuickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void QuickSort(int[] arr, int low, int high){
        if (low < high){
            int mid = Partition(arr, low, high);
            // mid相当于是已经排好序的了
            QuickSort(arr, low, mid - 1);
            QuickSort(arr, mid + 1, high);
        }
    }
    public static int Partition(int[] arr, int low, int high){
        int pivot = arr[low];
        while (low < high){
            while (low < high && arr[high] >= pivot){
                high--;
            }
            arr[low] = arr[high]; // ++？

            while (low < high && arr[low] <= pivot){
                low++;
            }
            arr[high] = arr[low]; // --？
        }
        arr[low] = pivot;
        return low;
    }
}
